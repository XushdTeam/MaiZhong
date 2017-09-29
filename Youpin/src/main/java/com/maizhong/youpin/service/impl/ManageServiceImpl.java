package com.maizhong.youpin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.*;
import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.*;
import com.maizhong.youpin.dto.*;

import com.maizhong.youpin.mapper.*;
import com.maizhong.youpin.pojo.*;
import com.maizhong.youpin.service.ManageService;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public ManagerUser getSysUserByToken(String token) {
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
        JSONArray jsonArray = new JSONArray();
        SaleRecordExample example = new SaleRecordExample();
        example.setOrderByClause("createtime desc");
        List<SaleRecord> saleRecords = saleRecordMapper.selectByExample(example);
        if (saleRecords != null && saleRecords.size() > 0) {
            for (SaleRecord saleRecord : saleRecords) {
                try {
                    JSONObject object = new JSONObject();
                    User user = userMapper.selectByPrimaryKey(saleRecord.getUserId());
                    String record_info = super.getJedisClient().hget("RECORD_INFO", saleRecord.getOrdernum());
                    OrderInfoDto orderInfoDto = JsonUtils.jsonToPojo(record_info, OrderInfoDto.class);
                    Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
                    if (company == null) {
                        Company company1 = new Company();
                        company1.setName("个人");
                        object.put("company", company1);//公司信息
                    } else {
                        object.put("company", company);//公司信息
                    }
                    object.put("record_info", orderInfoDto);//订单信息
                    object.put("user", user);//用户信息

                    object.put("saleRecord", saleRecord);//
                    jsonArray.add(object);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }

        PageInfo pageInfo = new PageInfo(jsonArray);
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

    /**
     * 根据订单编查询详情
     *
     * @param orderNumber
     * @return
     */
    @Override
    public JsonResult getOrderDetail(long orderNumber) {
        JSONObject object = null;
        try {

            SaleRecordExample example = new SaleRecordExample();
            SaleRecordExample.Criteria criteria = example.createCriteria();
            criteria.andOrdernumEqualTo(String.valueOf(orderNumber));
            List<SaleRecord> saleRecords = saleRecordMapper.selectByExample(example);
            SaleRecord saleRecord=saleRecords.get(0);

            object = new JSONObject();
            User user = userMapper.selectByPrimaryKey(saleRecord.getUserId());
            String record_info = super.getJedisClient().hget("RECORD_INFO", saleRecord.getOrdernum());
            OrderInfoDto orderInfoDto = JsonUtils.jsonToPojo(record_info, OrderInfoDto.class);
            Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
            if (company == null) {
                Company company1 = new Company();
                company1.setName("个人");
                object.put("company", company1);//公司信息
            } else {
                object.put("company", company);//公司信息
            }
            object.put("record_info", orderInfoDto);//订单信息
            object.put("user", user);//用户信息

            object.put("saleRecord", saleRecord);//
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.OK(null);
        }
        return JsonResult.OK(object);
    }

    @Override
    public JsonResult price(long ordernumber, String price,String token) {
        try {
            SaleRecordExample saleRecordExample=new SaleRecordExample();
            SaleRecordExample.Criteria criteria = saleRecordExample.createCriteria();
            criteria.andOrdernumEqualTo(String.valueOf(ordernumber));
            List<SaleRecord> saleRecords = saleRecordMapper.selectByExample(saleRecordExample);
            SaleRecord saleRecord=saleRecords.get(0);
            saleRecord.setPrice(price);
            saleRecord.setStatus(2);
            if(saleRecord.getSolveTime()==null||"".equals(saleRecord.getSolveTime())){
                saleRecord.setSolveTime(TimeUtils.getFormatDateTime3(new Date()));
            }else{
                saleRecord.setUpdatetime(TimeUtils.getFormatDateTime3(new Date()));
            }

            saleRecordMapper.updateByPrimaryKeySelective(saleRecord);

        } catch (Exception e) {
            e.printStackTrace();
            return  JsonResult.Error("修改失败");
        }
        return  JsonResult.OK();
    }

    /**
     * 估值
     * @param ordernumber
     * @return
     */
    @Override
    public JsonResult getGuZhi(long ordernumber) {

        String record_info = super.getJedisClient().hget("RECORD_INFO", String.valueOf(ordernumber));
        if(StringUtils.isBlank(record_info)){
            return JsonResult.Error("数据错误，订单编号不存在");
        }
        AppRecordDto appRecordDto = JsonUtils.jsonToPojo(record_info, AppRecordDto.class);
        String param1 = appRecordDto.getParam1();
        Che300Dto che300Data = getChe300Data(param1);
        if(che300Data!=null){
            String param2 = appRecordDto.getParam2();
            String precisePrice = getPrecisePrice(param2, che300Data);
            if(precisePrice==null)return JsonResult.Error("数据错误,车辆信息有误");
            che300Data.setPrecisePrice(precisePrice);
            return JsonResult.OK(che300Data);

        }else{
            return JsonResult.Error("CHE300 Data ERROR");
        }

    }

    /**
     * 获取车300数据
     * @param param
     */
    private Che300Dto getChe300Data(String param){

        try {
            String che_300 = super.getJedisClient().get("CHE_300:"+param);

            if(StringUtils.isNotBlank(che_300)){
                return JsonUtils.jsonToPojo(che_300,Che300Dto.class);
            }

            String[] paramarry = param.split("c|m|r|g");
            String url = String.format("%s?token=%s&modelId=%s&regDate=%s&mile=%s&zone=%s", super.getCHE300_GUZHI(), super.getCHE300_TOKEN(), paramarry[2], paramarry[3], paramarry[4], paramarry[1]);
            String result = HttpClientUtil.doGet(url);
            JSONObject object = JSON.parseObject(result);
            Che300Dto dto = new Che300Dto();
            String default_car_condition = object.getString("default_car_condition");
            dto.setDefault_condition(default_car_condition);
            JSONArray eval_prices = object.getJSONArray("eval_prices");
            for (Object eval_price : eval_prices) {
                JSONObject obj = (JSONObject) eval_price;
                if (obj.getString("condition").equals("excellent")) {
                    //车况优秀
                    dto.setPriceA_max(obj.getString("individual_low_sold_price"));
                    dto.setPriceA_min(obj.getString("dealer_low_buy_price"));
                }
                if (obj.getString("condition").equals("good")) {
                    //车况良好
                    dto.setPriceB_max(obj.getString("individual_low_sold_price"));
                    dto.setPriceB_min(obj.getString("dealer_low_buy_price"));
                }
                if (obj.getString("condition").equals("normal")) {
                    //车况一般
                    dto.setPriceC_max(obj.getString("individual_low_sold_price"));
                    dto.setPriceC_min(obj.getString("dealer_low_buy_price"));
                    //车况较差
                    dto.setPriceD_max(new BigDecimal(obj.getDouble("individual_low_sold_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                    dto.setPriceD_min(new BigDecimal(obj.getDouble("dealer_low_buy_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                }
            }
            //放入缓存
            super.getJedisClient().set("CHE_300:"+param,JsonUtils.objectToJson(dto));
            //设置过期时间7天
            super.getJedisClient().expire("CHE_300:"+param,60*60*24*7);
            return dto;

        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }

    /**
     * 二次精准估值
     * @param param
     * @param che300Dto
     * @return
     */
    public String getPrecisePrice(String param,Che300Dto che300Dto){

        try {
            String[] otherArry = param.split("o|j|h|t|x|n|d|k");

            String ck = otherArry[7], color = otherArry[0], jqx = otherArry[1],
                    gh = otherArry[2], ghtime = otherArry[3], xz = otherArry[4],
                    nj = otherArry[5], method = otherArry[6];

            BigDecimal basePrice ;
            if (StringUtils.equals("1", ck)) {
                basePrice = new BigDecimal(che300Dto.getPriceA_min());
            } else if (StringUtils.equals("2", ck)) {
                basePrice = new BigDecimal(che300Dto.getPriceB_min());
            } else if (StringUtils.equals("3", ck)) {
                basePrice = new BigDecimal(che300Dto.getPriceC_min());
            } else {
                basePrice = new BigDecimal(che300Dto.getPriceD_min());
            }

            String colorParam = super.getJedisClient().hget("GZ_PARAM", "color");

            JSONObject colorObject = JSON.parseObject(colorParam);
            String rate = colorObject.getString("p" + color);
            //颜色影响
            basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));
            if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
                basePrice = BigDecimal.ZERO;
            }
            String jqxParam = super.getJedisClient().hget("GZ_PARAM", "jqx");
            JSONObject jqxObject = JSON.parseObject(jqxParam);
            rate = jqxObject.getString("p" + jqx);
            //交强险影响 减法
            basePrice = basePrice.subtract(new BigDecimal(rate));
            if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
                basePrice = BigDecimal.ZERO;
            }

            String ghParam = super.getJedisClient().hget("GZ_PARAM", "gh");
            JSONObject ghObject = JSON.parseObject(ghParam);
            rate = ghObject.getString("p" + gh);
            //过户次数影响
            basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));
            if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
                basePrice = BigDecimal.ZERO;
            }

            String ghtParam = super.getJedisClient().hget("GZ_PARAM", "ghtime");
            JSONObject ghtObject = JSON.parseObject(ghtParam);
            rate = ghtObject.getString("p" + ghtime);
            //过户时间影响
            basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));
            if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
                basePrice = BigDecimal.ZERO;
            }
            String xzParam = super.getJedisClient().hget("GZ_PARAM", "xz");
            JSONObject xzObject = JSON.parseObject(xzParam);
            rate = xzObject.getString("p" + xz);
            //性质
            basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));
            if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
                basePrice = BigDecimal.ZERO;
            }
            String njParam = super.getJedisClient().hget("GZ_PARAM", "nj");
            JSONObject njObject = JSON.parseObject(njParam);
            rate = njObject.getString("p" + nj);
            //年检 (减法)
            basePrice = basePrice.subtract(new BigDecimal(rate));
            if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
                basePrice = BigDecimal.ZERO;
            }

            String methodParam = super.getJedisClient().hget("GZ_PARAM", "method");
            JSONObject mObject = JSON.parseObject(methodParam);
            rate = mObject.getString("p" + method);
            //使用方式
            basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));
            if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
                basePrice = BigDecimal.ZERO;
            }

            if (basePrice.compareTo(new BigDecimal(1))<0){
                /**
                 * 201706068
                 * 小于1w 保留3位小数 若最后一位为零 保留2位小数
                 * Xushd
                 */
                String price = basePrice.setScale(3, BigDecimal.ROUND_HALF_DOWN).toString();
                while (price.endsWith("0")){
                    price = price.substring(0,price.length()-1);
                }
                return price;

            }else{
                return basePrice.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
