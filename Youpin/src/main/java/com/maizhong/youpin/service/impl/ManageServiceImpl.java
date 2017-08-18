package com.maizhong.youpin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.youpin.dto.MenuDto;
import com.maizhong.youpin.dto.RecordDto;
import com.maizhong.youpin.dto.UserDto;
import com.maizhong.youpin.mapper.*;
import com.maizhong.youpin.pojo.*;
import com.maizhong.youpin.service.ManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-17
 * Time: 11:27
 */

@Service
public class ManageServiceImpl extends BaseService implements ManageService {


    @Autowired
    private ManagerUserMapper managerUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private SaleRecordMapper saleRecordMapper;

    @Autowired
    private SaleImgMapper saleImgMapper;

    @Autowired
    private ModelMapper modelMapper;





    /**
     * 后台登录验证
     *
     * @param account
     * @param password
     * @param checked
     * @return
     */
    @Override
    public JsonResult loginCheck(String account, String password, boolean checked) {

        ManagerUserExample example = new ManagerUserExample();
        ManagerUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0).andPhoneEqualTo(account);
        List<ManagerUser> managerUsers = managerUserMapper.selectByExample(example);
        if (managerUsers.size() == 0) {
            return JsonResult.build(AuthEnum.USER_NO_EXIT);
        } else {
            ManagerUser managerUser = managerUsers.get(0);
            if (!StringUtils.equals(password, managerUser.getPassword())) {
                return JsonResult.build(AuthEnum.USER_ERROR_PASSWORD);
            } else {
                if (managerUser.getStatus() == 0) {
                    return JsonResult.build(AuthEnum.USER_STOP);
                }
                String token = IDUtils.getUUID();
                super.getJedisClient().set("YOUPIN_LOGIN:" + token, JsonUtils.objectToJson(managerUser));
                if (!checked) {
                    super.getJedisClient().expire("YOUPIN_LOGIN:" + token, 60 * 30);
                }
                return JsonResult.build(200, "登录成功", token);
            }
        }

    }

    /**
     * 验证登录状态
     *
     * @param token
     * @return
     */
    @Override
    public JsonResult checkLoginStatus(String token) {

        String s = super.getJedisClient().get("YOUPIN_LOGIN:" + token);
        if (StringUtils.isBlank(s)) {
            return JsonResult.Error("TIME IS OUT");
        }
        return JsonResult.OK(JsonUtils.jsonToPojo(s, ManagerUser.class).getName());
    }

    /**
     * 获取用户的菜单
     *
     * @param token
     * @return
     */
    @Override
    public String getSystemMenu(String token) {
        List<SysMenu> sysMenus = sysMenuMapper.selectByExample(null);
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(0L).andDelflagEqualTo(0);
        List<SysMenu> parents = sysMenuMapper.selectByExample(example);

        List<MenuDto> list = new ArrayList<>();

        for (SysMenu parent : parents) {
            List<MenuDto> temp = new ArrayList<>();
            for (SysMenu menu : sysMenus) {
                if (menu.getParentId() == parent.getId()) {
                    MenuDto dto = new MenuDto();
                    dto.setIcon(menu.getIcon());
                    dto.setName(menu.getName());
                    dto.setUrl(menu.getUrl());
                    temp.add(dto);
                }
            }
            if (temp.size() > 0) {
                MenuDto dto = new MenuDto();
                dto.setIcon(parent.getIcon());
                dto.setName(parent.getName());
                dto.setUrl(parent.getUrl());
                dto.setSubs(temp);
                list.add(dto);
            }

        }
        return JsonUtils.objectToJson(list);
    }

    /**
     * 退出登录
     *
     * @param token
     * @return
     */
    @Override
    public JsonResult logOff(String token) {

        super.getJedisClient().del("YOUPIN_TOKEN:" + token);

        return JsonResult.OK();
    }


    /**
     * 获取用户列表
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getSysAccountList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        ManagerUserExample example = new ManagerUserExample();
        ManagerUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);

        if (StringUtils.isNotBlank(param.getFiled("name"))) {
            criteria.andNameLike(SqlUtils.getLikeSql(param.getFiled("name")));
        }
        if (StringUtils.isNotBlank(param.getFiled("phone"))) {
            criteria.andPhoneEqualTo(param.getFiled("phone"));
        }

        List<ManagerUser> sysUsers = managerUserMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(sysUsers);

        return JsonResult.OK(pageInfo);
    }


    /**
     * 系统用户保存
     *
     * @param user
     * @param token
     * @return
     */
    @Override
    public JsonResult saveSysAccount(ManagerUser user, String token) {
        ManagerUser sysUser = this.getSysUserByToken(token);


        if (user.getId() == -1) {
            //新增
            ManagerUserExample example = new ManagerUserExample();
            ManagerUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(user.getPhone()).andDelflagEqualTo(0);
            List<ManagerUser> sysUsers = managerUserMapper.selectByExample(example);
            if (sysUsers.size() > 0) return JsonResult.Error("手机号重复");

            user.setId(null);
            user.setRegisttime(TimeUtils.getFormatDateTime3(new Date()));
            user.setPassword(IDUtils.sha256("123456"));
            user.setStatus(1);
            user.setDelflag(0);
            int i = managerUserMapper.insertSelective(user);
            if (i > 0) return JsonResult.OK(OperateEnum.SUCCESS);
        } else {
            //更新
            ManagerUserExample example = new ManagerUserExample();
            ManagerUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(user.getPhone()).andDelflagEqualTo(0).andIdNotEqualTo(user.getId());
            List<ManagerUser> sysUsers = managerUserMapper.selectByExample(example);
            if (sysUsers.size() > 0) return JsonResult.Error("手机号重复");

            int i = managerUserMapper.updateByPrimaryKeySelective(user);
            if (i > 0) return JsonResult.OK(OperateEnum.SUCCESS);
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 用户状态修改
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public JsonResult statusSysAccount(long id, int status) {

        ManagerUser user = new ManagerUser();
        user.setId(id);
        user.setStatus(status == 1 ? 0 : 1);
        int i = managerUserMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 用户删除
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult delSysAccount(long id) {

        ManagerUser user = new ManagerUser();
        user.setId(id);
        user.setDelflag(1);
        int i = managerUserMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }


    /**
     * 客户删除
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult delUser(long id) {

        User user = new User();
        user.setId(id);
        user.setDelflag(1);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }


    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return
     */
    private ManagerUser getSysUserByToken(String token) {
        String userStr = super.getJedisClient().get("YOUPIN_LOGIN:" + token);
        ManagerUser managerUser = JsonUtils.jsonToPojo(userStr, ManagerUser.class);
        return managerUser;
    }

    /**
     * 获取全部用户列表
     *
     * @return
     */
    @Override
    public JsonResult getUserListAll() {
        List<UserDto> userDtoList = new ArrayList<>();

        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andStatusEqualTo(1).andDelflagEqualTo(0);
        List<User> users = userMapper.selectByExample(userExample);
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setPhone(user.getPhone());
            userDto.setLevel(String.valueOf(user.getLevel()));
            userDto.setType(String.valueOf(user.getType()));
            userDto.setJob(user.getJob());
            userDto.setStatus(user.getStatus());
            userDto.setRegisttime(user.getRegisttime());
            if (user.getCompanyId() == 1) {
                userDto.setCompany("个人");
            } else {

                try {
                    Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
                    if (company != null && company.getId() > 0) {
                        userDto.setCompany(company.getName());
                    } else {
                        userDto.setCompany("未知");
                    }
                } catch (Exception e) {
                    userDto.setCompany("未知");
                }

            }
            userDtoList.add(userDto);
        }


        return JsonResult.OK(userDtoList);
    }

    /**
     * 根据条件获取用户列表
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getUserList(PageSearchParam param) {
        List<UserDto> userDtoList = new ArrayList<>();
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        if (StringUtils.isNotBlank(param.getFiled("name"))) {
            criteria.andNameLike(SqlUtils.getLikeSql(param.getFiled("name")));
        }
        List<User> users = userMapper.selectByExample(example);

        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setPhone(user.getPhone());
            userDto.setLevel(String.valueOf(user.getLevel()));
            userDto.setType(String.valueOf(user.getType()));
            userDto.setJob(user.getJob());
            userDto.setStatus(user.getStatus());
            userDto.setRegisttime(user.getRegisttime());
            if (user.getCompanyId() == 0) {
                userDto.setCompany("个人");
            } else {

                try {
                    Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
                    if (company != null && company.getId() > 0) {
                        userDto.setCompany(company.getName());
                    } else {
                        userDto.setCompany("未知");
                    }
                } catch (Exception e) {
                    userDto.setCompany("未知");
                }

            }
            userDtoList.add(userDto);
        }

        PageInfo pageInfo = new PageInfo(userDtoList);
        return JsonResult.OK(pageInfo);
    }



    /*订单信息*/


    /**
     * 获取订单列表
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getRecordList(PageSearchParam param) {

        List<RecordDto> recordDtoList=new ArrayList<>();

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        SaleRecordExample example = new SaleRecordExample();
        SaleRecordExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(param.getFiled("status"))) {
            criteria.andStatusEqualTo(Integer.valueOf(param.getFiled("status")));
        }

        List<SaleRecord> saleRecords = saleRecordMapper.selectByExample(example);

        for (SaleRecord saleRecord : saleRecords) {
            try {
                RecordDto recordDto = new RecordDto();
                User user = userMapper.selectByPrimaryKey(saleRecord.getUserId());//查询用户
                Model model=modelMapper.selectByPrimaryKey(saleRecord.getModelId());//获取车辆信息
                SaleImgExample example1 = new SaleImgExample();
                SaleImgExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andRecordIdEqualTo(saleRecord.getId());
                List<SaleImg> saleImgs = saleImgMapper.selectByExample(example1);//查询图片

                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setName(user.getName());
                userDto.setPhone(user.getPhone());
                userDto.setLevel(String.valueOf(user.getLevel()));
                userDto.setType(String.valueOf(user.getType()));
                userDto.setJob(user.getJob());
                userDto.setStatus(user.getStatus());
                userDto.setRegisttime(user.getRegisttime());
                if (user.getCompanyId() == 0) {
                    userDto.setCompany("个人");
                } else {
                    Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
                    if (company != null && company.getId() > 0) {
                        userDto.setCompany(company.getName());
                    } else {
                        userDto.setCompany("未知");
                    }
                }

                recordDto.setUser(user);//用户
                recordDto.setUserDto(userDto);//用户DTO
                recordDto.setSaleImgList(saleImgs);//图片列表
                recordDto.setSaleRecord(saleRecord);//订单信息
                recordDto.setModel(model);//车辆信息
                recordDtoList.add(recordDto);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        PageInfo pageInfo = new PageInfo(recordDtoList);

        return JsonResult.OK(pageInfo);
    }


    /**
     * 订单保存
     *
     * @param saleRecord
     * @param token
     * @return
     */
    @Override
    public JsonResult saveRecord(SaleRecord saleRecord, String token) {
        ManagerUser user = this.getSysUserByToken(token);

        if (user.getId() == -1) {
            //新增
            ManagerUserExample example = new ManagerUserExample();
            ManagerUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(user.getPhone()).andDelflagEqualTo(0);
            List<ManagerUser> sysUsers = managerUserMapper.selectByExample(example);
            if (sysUsers.size() > 0) return JsonResult.Error("手机号重复");

            user.setId(null);
            user.setRegisttime(TimeUtils.getFormatDateTime3(new Date()));
            user.setPassword(IDUtils.sha256("123456"));
            user.setStatus(1);
            user.setDelflag(0);
            int i = managerUserMapper.insertSelective(user);
            if (i > 0) return JsonResult.OK(OperateEnum.SUCCESS);
        } else {
            //更新
            ManagerUserExample example = new ManagerUserExample();
            ManagerUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(user.getPhone()).andDelflagEqualTo(0).andIdNotEqualTo(user.getId());
            List<ManagerUser> sysUsers = managerUserMapper.selectByExample(example);
            if (sysUsers.size() > 0) return JsonResult.Error("手机号重复");

            int i = managerUserMapper.updateByPrimaryKeySelective(user);
            if (i > 0) return JsonResult.OK(OperateEnum.SUCCESS);
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 订单状态修改
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public JsonResult statusRecord(long id, int status) {

        ManagerUser user = new ManagerUser();
        user.setId(id);
        user.setStatus(status == 1 ? 0 : 1);
        int i = managerUserMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 订单删除
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult delRecord(long id) {

        ManagerUser user = new ManagerUser();
        user.setId(id);
        user.setDelflag(1);
        int i = managerUserMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }


}
