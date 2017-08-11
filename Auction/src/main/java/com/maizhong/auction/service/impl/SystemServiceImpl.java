package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.*;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.SystemService;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.dto.WaitAuctionQueueDto;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Xushd on 2017/7/4.
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private CkUserMapper ckUserMapper;
    @Autowired
    private SysCompanyMapper sysCompanyMapper;
    @Autowired
    private CkCarbaseMapper carbaseMapper;
    @Autowired
    private CkOtherMapper ckOtherMapper;
    @Autowired
    private CkVerifyMapper ckVerifyMapper;
    @Autowired
    private CkQtzMapper ckQtzMapper;
    @Autowired
    private CkPzMapper ckPzMapper;
    @Autowired
    private CkDlMapper ckDlMapper;
    @Autowired
    private CkCksgMapper ckCksgMapper;
    @Autowired
    private CkCkpsMapper ckCkpsMapper;
    @Autowired
    private CkCkhsMapper ckCkhsMapper;
    @Autowired
    private CkCkwgqxMapper ckCkwgqxMapper;
    @Autowired
    private CkCknsqxMapper ckCknsqxMapper;
    @Autowired
    private CkDjzMapper djzMapper;
    @Autowired
    private CkBaseimgMapper ckBaseimgMapper;
    @Autowired
    private CkXszMapper ckXszMapper;
    @Autowired
    private CkCarmodelMapper ckCarmodelMapper;
    @Autowired
    private AcAuctionOverMapper acAuctionOverMapper;
    @Autowired
    private AcOrderMapper acOrderMapper;
    @Autowired
    private AcUserMapper acUserMapper;
    @Autowired
    private AcBzjRecordMapper acBzjRecordMapper;
    @Autowired
    private AcAuctionNowMapper acAuctionNowMapper;
    @Autowired
    private AcAuctionRecordMapper acAuctionRecordMapper;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public JsonResult getSysAccountList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);

        if (StringUtils.isNotBlank(param.getFiled("username"))) {
            criteria.andUsernameLike(SqlUtils.getLikeSql(param.getFiled("username")));
        }
        if (StringUtils.isNotBlank(param.getFiled("phoneNum"))) {
            criteria.andPhoneNumEqualTo(Long.valueOf(param.getFiled("phoneNum")));
        }

        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);

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
    public JsonResult saveSysAccount(SysUser user, String token) {
        SysUser sysUser = this.getSysUserByToken(token);


        if (user.getId() == -1) {
            //新增
            SysUserExample example = new SysUserExample();
            SysUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneNumEqualTo(user.getPhoneNum()).andDelflagEqualTo(0);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
            if (sysUsers.size() > 0) return JsonResult.Error("手机号重复");

            user.setId(null);
            user.setCreateTime(new Date());
            user.setPassword(IDUtils.sha256("123456"));
            user.setStatus(1);
            user.setDelflag(0);
            int i = sysUserMapper.insertSelective(user);
            if (i > 0) return JsonResult.OK(OperateEnum.SUCCESS);
        } else {
            //更新
            SysUserExample example = new SysUserExample();
            SysUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneNumEqualTo(user.getPhoneNum()).andDelflagEqualTo(0).andIdNotEqualTo(user.getId());
            List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
            if (sysUsers.size() > 0) return JsonResult.Error("手机号重复");

            int i = sysUserMapper.updateByPrimaryKeySelective(user);
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

        SysUser user = new SysUser();
        user.setId(id);
        user.setStatus(status == 1 ? 0 : 1);
        int i = sysUserMapper.updateByPrimaryKeySelective(user);
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

        SysUser user = new SysUser();
        user.setId(id);
        user.setDelflag(1);
        int i = sysUserMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取检测端用户
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getCheckAccountList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        CkUserExample example = new CkUserExample();
        CkUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);

        if (StringUtils.isNotBlank(param.getFiled("username"))) {
            criteria.andUserNameLike(SqlUtils.getLikeSql(param.getFiled("username")));
        }
        if (StringUtils.isNotBlank(param.getFiled("phoneNum"))) {
            criteria.andUserPhoneEqualTo(Long.valueOf(param.getFiled("phoneNum")));
        }
        if (StringUtils.isNotBlank(param.getFiled("companyId"))) {
            criteria.andComanyIdEqualTo(Long.valueOf(param.getFiled("companyId")));
        }

        SysCompanyExample companyExample = new SysCompanyExample();
        SysCompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andStatusEqualTo(1).andDelflagEqualTo(0);
        List<SysCompany> sysCompanies = sysCompanyMapper.selectByExample(companyExample);


        List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
        for (CkUser ckUser : ckUsers) {
            for (SysCompany company : sysCompanies) {
                if (company.getId().equals(ckUser.getComanyId())) {
                    ckUser.setCompanyName(company.getName());
                    break;
                }
            }
        }

        PageInfo pageInfo = new PageInfo(ckUsers);

        return JsonResult.OK(pageInfo);
    }

    @Override
    public JsonResult getCompanyListAll() {
        SysCompanyExample companyExample = new SysCompanyExample();
        SysCompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andStatusEqualTo(1).andDelflagEqualTo(0);
        List<SysCompany> sysCompanies = sysCompanyMapper.selectByExample(companyExample);
        return JsonResult.OK(sysCompanies);
    }

    /**
     * 检测端新增用户
     *
     * @param user
     * @param token
     * @return
     */
    @Override
    public JsonResult saveCheckAccount(CkUser user, String token) {
        CkUserExample example = new CkUserExample();
        CkUserExample.Criteria criteria = example.createCriteria();
        if (user.getId() == -1) {

            criteria.andUserPhoneEqualTo(user.getUserPhone());
            List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
            if (ckUsers.size() > 0) return JsonResult.Error("手机号重复");
            //新增
            user.setId(null);
            user.setDelflag(0);
            user.setStatus(1);
            user.setPassword(IDUtils.sha256("123456"));
            user.setUpdateTime(new Date());
            int i = ckUserMapper.insertSelective(user);
            if (i > 0) return JsonResult.OK();

        } else {
            //更新
            criteria.andUserPhoneEqualTo(user.getUserPhone()).andIdNotEqualTo(user.getId());
            List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
            if (ckUsers.size() > 0) return JsonResult.Error("手机号重复");
            int i = ckUserMapper.updateByPrimaryKeySelective(user);
            if (i > 0) return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 检测端用户状态修改
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public JsonResult statusCheckAccount(long id, int status) {

        CkUser user = new CkUser();
        user.setId(id);
        user.setStatus(status == 1 ? 0 : 1);
        int i = ckUserMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 检测端用户删除
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult delSCheckAccount(long id) {
        CkUser user = new CkUser();
        user.setId(id);
        user.setDelflag(1);
        int i = ckUserMapper.updateByPrimaryKeySelective(user);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取商户列表
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getCompanyList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        SysCompanyExample example = new SysCompanyExample();
        SysCompanyExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        if (StringUtils.isNotBlank(param.getFiled("name"))) {
            criteria.andNameLike(SqlUtils.getLikeSql(param.getFiled("name")));
        }

        List<SysCompany> sysCompanies = sysCompanyMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(sysCompanies);

        return JsonResult.OK(pageInfo);
    }

    /**
     * 保存修改商户信息
     *
     * @param company
     * @param token
     * @return
     */
    @Override
    public JsonResult saveCompany(SysCompany company, String token) {

        if (company.getId() == -1) {
            //新增
            company.setId(null);
            company.setStatus(1);
            company.setDelflag(0);
            company.setCreateTime(new Date());
            int i = sysCompanyMapper.insertSelective(company);
            if (i > 0) return JsonResult.OK();


        } else {
            //修改
            int i = sysCompanyMapper.updateByPrimaryKeySelective(company);
            if (i > 0) return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 修改商户状态
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    @Transactional
    public JsonResult statusCompany(long id, int status) {
        SysCompany company = new SysCompany();
        company.setId(id);
        company.setStatus(status == 1 ? 0 : 1);
        int i = sysCompanyMapper.updateByPrimaryKeySelective(company);
        if (i > 0) {
            //删除商户下的检测用户
            CkUserExample example = new CkUserExample();
            CkUserExample.Criteria criteria = example.createCriteria();
            criteria.andComanyIdEqualTo(id);
            CkUser ckUser = new CkUser();
            ckUser.setDelflag(status);
            ckUserMapper.updateByExampleSelective(ckUser, example);
            return JsonResult.OK();
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 删除商户
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public JsonResult delCompany(long id) {
        SysCompany company = new SysCompany();
        company.setId(id);
        company.setDelflag(1);
        int i = sysCompanyMapper.updateByPrimaryKeySelective(company);
        if (i > 0) {
            //删除商户下的检测用户
            CkUserExample example = new CkUserExample();
            CkUserExample.Criteria criteria = example.createCriteria();
            criteria.andComanyIdEqualTo(id);
            CkUser ckUser = new CkUser();
            ckUser.setDelflag(1);
            ckUserMapper.updateByExampleSelective(ckUser, example);
            return JsonResult.OK();
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取审核车辆
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getExamineCarList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        CkCarbaseExample example = new CkCarbaseExample();
        CkCarbaseExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(2);
        if (StringUtils.isNotBlank(param.getFiled("timeBegin"))) {
            criteria.andCreateTimeGreaterThanOrEqualTo(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        if (StringUtils.isNotBlank(param.getFiled("timeEnd"))) {
            criteria.andCreateTimeLessThanOrEqualTo(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        List<CkCarbase> list = carbaseMapper.selectByExample(example);

        List<CarExamineDto> rows = new ArrayList<>();
        for (CkCarbase carbase : list) {
            CarExamineDto dto = new CarExamineDto();
            dto.setId(carbase.getId());
            dto.setCreateTime(carbase.getCreateTime());
            dto.setModelName(carbase.getModelName());
            dto.setUserName(carbase.getUserName());
            dto.setUserPhone(carbase.getUserPhone());
            dto.setStatus(carbase.getStatus());
            dto.setStartPrice(carbase.getStartPrice());
            //牌照号码
            CkXszExample ckXszExample = new CkXszExample();
            CkXszExample.Criteria ckXszExampleCriteria = ckXszExample.createCriteria();
            ckXszExampleCriteria.andCarIdEqualTo(carbase.getId());
            List<CkXsz> ckXszs = ckXszMapper.selectByExample(ckXszExample);
            if (ckXszs.size() == 0) ckXszs.add(new CkXsz());
            dto.setCarNum(ckXszs.get(0).getNumber());
            //左45
            CkBaseimgExample ckBaseimgExample = new CkBaseimgExample();
            CkBaseimgExample.Criteria ckBaseimgExampleCriteria = ckBaseimgExample.createCriteria();
            ckBaseimgExampleCriteria.andCarIdEqualTo(carbase.getId());
            List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(ckBaseimgExample);
            if (ckBaseimgs.size() == 0) ckBaseimgs.add(new CkBaseimg());
            dto.setPicMain(ckBaseimgs.get(0).getZq45());
            //商户名称
            CkUserExample ckUserExample = new CkUserExample();
            CkUserExample.Criteria ckUserExampleCriteria = ckUserExample.createCriteria();
            ckUserExampleCriteria.andUserPhoneEqualTo(carbase.getUserPhone());
            List<CkUser> ckUsers = ckUserMapper.selectByExample(ckUserExample);
            if (ckUsers.size() == 0) continue;
            SysCompany company = sysCompanyMapper.selectByPrimaryKey(ckUsers.get(0).getComanyId());
            dto.setCompanyName(company.getName());
            rows.add(dto);
        }
        PageInfo<CarExamineDto> pageInfo = new PageInfo(rows);

        return JsonResult.OK(pageInfo);
    }

    /**
     * 审核通过
     *
     * @param id
     * @param token
     * @return
     */
    @Override
    public JsonResult examinePass(long id, String token) {

        SysUser user = this.getSysUserByToken(token);
        CkCarbase ckCarbase = new CkCarbase();
        ckCarbase.setId(id);
        ckCarbase.setStatus(3);
        ckCarbase.setExamineUserId(user.getId());
        ckCarbase.setExamineUsername(user.getUsername());
        ckCarbase.setExamineTime(new Date());
        ckCarbase.setExamineReason("通过");
        int i = carbaseMapper.updateByPrimaryKeySelective(ckCarbase);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 驳回审核
     *
     * @param id
     * @param reason
     * @param token
     * @return
     */
    @Override
    public JsonResult examineReject(long id, String reason, String token) {

        SysUser user = this.getSysUserByToken(token);
        CkCarbase ckCarbase = new CkCarbase();
        ckCarbase.setId(id);
        ckCarbase.setStatus(9);
        ckCarbase.setExamineUserId(user.getId());
        ckCarbase.setExamineUsername(user.getUsername());
        ckCarbase.setExamineTime(new Date());
        ckCarbase.setExamineReason(reason);
        int i = carbaseMapper.updateByPrimaryKeySelective(ckCarbase);
        if (i > 0) return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);

    }

    /**
     * 候拍车辆
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getWaitCarList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        CkCarbaseExample example = new CkCarbaseExample();
        CkCarbaseExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(3);
        if (StringUtils.isNotBlank(param.getFiled("timeBegin"))) {
            criteria.andCreateTimeGreaterThanOrEqualTo(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        if (StringUtils.isNotBlank(param.getFiled("timeEnd"))) {
            criteria.andCreateTimeLessThanOrEqualTo(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        List<CkCarbase> list = carbaseMapper.selectByExample(example);

        List<CarExamineDto> rows = new ArrayList<>();
        for (CkCarbase carbase : list) {
            CarExamineDto dto = new CarExamineDto();
            dto.setId(carbase.getId());
            dto.setCreateTime(carbase.getCreateTime());
            dto.setModelName(carbase.getModelName());
            dto.setUserName(carbase.getUserName());
            dto.setUserPhone(carbase.getUserPhone());
            dto.setStatus(carbase.getStatus());
            dto.setStartPrice(carbase.getStartPrice());
            dto.setSavePrice(carbase.getSavePrice());

            //牌照号码
            CkXszExample ckXszExample = new CkXszExample();
            CkXszExample.Criteria ckXszExampleCriteria = ckXszExample.createCriteria();
            ckXszExampleCriteria.andCarIdEqualTo(carbase.getId());
            List<CkXsz> ckXszs = ckXszMapper.selectByExample(ckXszExample);
            if (ckXszs.size() == 0) ckXszs.add(new CkXsz());
            dto.setCarNum(ckXszs.get(0).getNumber());
            //左45
            CkBaseimgExample ckBaseimgExample = new CkBaseimgExample();
            CkBaseimgExample.Criteria ckBaseimgExampleCriteria = ckBaseimgExample.createCriteria();
            ckBaseimgExampleCriteria.andCarIdEqualTo(carbase.getId());
            List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(ckBaseimgExample);
            if (ckBaseimgs.size() == 0) ckBaseimgs.add(new CkBaseimg());
            dto.setPicMain(ckBaseimgs.get(0).getZq45());
            //商户名称
            CkUserExample ckUserExample = new CkUserExample();
            CkUserExample.Criteria ckUserExampleCriteria = ckUserExample.createCriteria();
            ckUserExampleCriteria.andUserPhoneEqualTo(carbase.getUserPhone());
            List<CkUser> ckUsers = ckUserMapper.selectByExample(ckUserExample);
            if (ckUsers.size() == 0) continue;
            SysCompany company = sysCompanyMapper.selectByPrimaryKey(ckUsers.get(0).getComanyId());
            dto.setCompanyName(company.getName());
            rows.add(dto);
        }
        PageInfo<CarExamineDto> pageInfo = new PageInfo(rows);

        return JsonResult.OK(pageInfo);

    }


    @Value("${CHNUM}")
    private String CH_NUM;

    /**
     * 获取通道列表
     *
     * @return
     */
    @Override
    public JsonResult selectChannel() {

        JSONArray list = new JSONArray();
        int num = Integer.parseInt(CH_NUM);
        for (int i = 0; i < num; i++) {
            String key = "AuctionQueue:CH" + i;
            long llen = jedisClient.llen(key.getBytes());
            JSONObject object = new JSONObject();
            object.put("name", "通道" + i);
            object.put("chKey", "CH" + i);
            object.put("length", llen);
            list.add(object);
        }
        return JsonResult.OK(list);
    }

    /**
     * 获取对应通道的拍卖队列
     *
     * @param key
     * @return
     */
    @Override
    public JsonResult selectChannelQueueByKey(String key) {
        key = "AuctionQueue:" + key;
        List<byte[]> lrange = jedisClient.lrange(key.getBytes());
        return null;
    }

    /**
     * 通道队列添加车辆
     *
     * @param carIds
     * @param time
     * @param ch
     * @return
     */
    @Override
    public JsonResult channelAdd(String carIds, int time, String ch) {
        byte[] redisKey = ("AuctionQueue:" + ch).getBytes();
        String[] ids = carIds.split(",");
        for (String id : ids) {
            long carId = Long.valueOf(id);
            //缓存一下汽车信息
            Map<String, Object> map = this.getCarInfoandDetailDto(carId,ch);


            jedisClient.hset("CAR_INFO", carId + "", JsonUtils.objectToJson(map.get("info")));
            jedisClient.hset("CAR_DETAIL", carId + "", JsonUtils.objectToJson(map.get("detail")));


            CkCarbase ckCarbase = carbaseMapper.selectByPrimaryKey(carId);
            WaitAuctionQueueDto dto = new WaitAuctionQueueDto();
            dto.setCarId(carId);
            dto.setChannel(ch);
            dto.setMinutes(time);
            dto.setStartPrice(ckCarbase.getStartPrice());
            jedisClient.lpush(redisKey, ObjectUtil.serializer(dto));
            ckCarbase.setStatus(4);
            carbaseMapper.updateByPrimaryKeySelective(ckCarbase);

        }


        return JsonResult.OK();
    }


    /**
     * 修改起拍价
     *
     * @param carId
     * @param price
     * @return
     */
    @Override
    public JsonResult setCarStartPrice(long carId, String price) {

        CkCarbase ckCarbase = new CkCarbase();
        ckCarbase.setId(carId);
        ckCarbase.setStartPrice(price);
        int i = carbaseMapper.updateByPrimaryKeySelective(ckCarbase);
        if (i > 0) return JsonResult.OK();


        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取拍卖结束车辆
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getChannelOverList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        AcAuctionRecordExample example = new AcAuctionRecordExample();
        AcAuctionRecordExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);

        List<AcAuctionRecord> acAuctionRecords = acAuctionRecordMapper.selectByExample(example);

        List<CarExamineDto> rows = new ArrayList<>();
        for (AcAuctionRecord record : acAuctionRecords) {

            Long carId = record.getCarId();
            CkCarbase carbase = carbaseMapper.selectByPrimaryKey(carId);

            String car_info = jedisClient.hget("CAR_INFO", carId + "");
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);

            CarExamineDto dto = new CarExamineDto();

            dto.setChKey(record.getChKey());
            dto.setEndPrice(record.getPrice());
            dto.setId(carId);

            dto.setModelName(carbase.getModelName());
            dto.setUserName(carbase.getUserName());
            dto.setUserPhone(carbase.getUserPhone());
            dto.setStatus(carbase.getStatus());
            dto.setStartPrice(carbase.getStartPrice());
            //牌照号码
            dto.setCarNum(infoDto.getNumber());
            //左45
            dto.setPicMain(infoDto.getZq45());
            //商户名称
            CkUserExample ckUserExample = new CkUserExample();
            CkUserExample.Criteria ckUserExampleCriteria = ckUserExample.createCriteria();
            ckUserExampleCriteria.andUserPhoneEqualTo(carbase.getUserPhone());
            List<CkUser> ckUsers = ckUserMapper.selectByExample(ckUserExample);
            if (ckUsers.size() == 0) continue;
            SysCompany company = sysCompanyMapper.selectByPrimaryKey(ckUsers.get(0).getComanyId());
            dto.setCompanyName(company.getName());
            rows.add(dto);

        }
        PageInfo pageInfo = new PageInfo<>(rows);


        return JsonResult.OK(pageInfo);
    }

    /**
     * 车辆成交
     *
     * @param carId
     * @return
     */
    @Override
    @Transactional
    public JsonResult carDeal(long carId) {

        AcOrderExample example = new AcOrderExample();
        AcOrderExample.Criteria criteria = example.createCriteria();
        criteria.andCarIdEqualTo(carId);
        AcOrder acOrder = new AcOrder();
        acOrder.setStatus(1);
        int i = acOrderMapper.updateByExampleSelective(acOrder, example);
        if (i > 0) {
            AcAuctionRecord record = new AcAuctionRecord();
            record.setStatus(3);
            AcAuctionRecordExample recordExample = new AcAuctionRecordExample();
            AcAuctionRecordExample.Criteria recordExampleCriteria = recordExample.createCriteria();
            recordExampleCriteria.andStatusEqualTo(1).andCarIdEqualTo(carId);

            acAuctionRecordMapper.updateByExampleSelective(record,recordExample);

            CkCarbase ckCarbase = new CkCarbase();
            ckCarbase.setId(carId);
            ckCarbase.setStatus(8);
            carbaseMapper.updateByPrimaryKeySelective(ckCarbase);
            return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 二拍
     *
     * @param carId
     * @return
     */
    @Override
    public JsonResult carSecond(long carId) {
        CkCarbase ckCarbase = new CkCarbase();
        ckCarbase.setId(carId);
        ckCarbase.setStatus(3);
        ckCarbase.setAuctionCount(2);
        int i = carbaseMapper.updateByPrimaryKeySelective(ckCarbase);
        if (i > 0) {
            AcAuctionRecord record = new AcAuctionRecord();
            record.setStatus(2);
            AcAuctionRecordExample recordExample = new AcAuctionRecordExample();
            AcAuctionRecordExample.Criteria recordExampleCriteria = recordExample.createCriteria();
            recordExampleCriteria.andStatusEqualTo(1).andCarIdEqualTo(carId);

            acAuctionRecordMapper.updateByExampleSelective(record,recordExample);

            AcOrderExample orderExample = new AcOrderExample();
            AcOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andCarIdEqualTo(carId);
            acOrderMapper.deleteByExample(orderExample);

            return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);

    }

    /**
     * 拍卖端用户list
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getCompanyUserList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        AcUserExample example = new AcUserExample();
        AcUserExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(-1);
        if (StringUtils.isNotBlank(param.getFiled("name"))) {
            criteria.andNameLike(SqlUtils.getLikeSql(param.getFiled("name")));
        }
        if (StringUtils.isNotBlank(param.getFiled("phone"))) {
            criteria.andPhoneEqualTo(Long.valueOf(param.getFiled("phone")));
        }
        example.setOrderByClause("create_time desc");
        List<AcUser> acUsers = acUserMapper.selectByExample(example);
        PageInfo<AcUser> pageInfo = new PageInfo<>(acUsers);

        return JsonResult.OK(pageInfo);

    }

    /**
     * 修改用户状态
     *
     * @param id
     * @param status
     * @param token
     * @return
     */
    @Override
    public JsonResult changeStatusUser(long id, int status, String token) {
        SysUser sysUser = this.getSysUserByToken(token);
        AcUser acUser = new AcUser();
        acUser.setId(id);
        acUser.setStatus(status);
        acUser.setCreateUser(sysUser.getUsername());
        int i = acUserMapper.updateByPrimaryKeySelective(acUser);
        if (i > 0) {
            acUser = acUserMapper.selectByPrimaryKey(id);
            String acUserToken = jedisClient.hget("AC_USER_PHONE", acUser.getPhone() + "");
            if (StringUtils.isNotBlank(acUserToken)) {
                jedisClient.hset("AC_USER_TOKEN", acUserToken, JsonUtils.objectToJson(acUser));
            }
            return JsonResult.OK();
        }
        return null;
    }

    /**
     * 帐号删除
     *
     * @param id
     * @param token
     * @return
     */
    @Override
    public JsonResult companyUserDel(long id, String token) {
        SysUser sysUser = this.getSysUserByToken(token);


        AcUser acUser = new AcUser();
        acUser.setId(id);
        acUser.setStatus(-1);
        acUser.setCreateUser(sysUser.getUsername());
        int i = acUserMapper.updateByPrimaryKeySelective(acUser);
        if (i > 0) {
            acUser = acUserMapper.selectByPrimaryKey(id);
            String acUserToken = jedisClient.hget("AC_USER_PHONE", acUser.getPhone() + "");
            if (StringUtils.isNotBlank(acUserToken)) {
                jedisClient.hdel("AC_USER_PHONE", acUser.getPhone() + "");
                jedisClient.hdel("AC_USER_TOKEN", acUserToken);
            }
            return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);


    }

    /**
     * 充值保证金
     *
     * @param id
     * @param plus
     * @param token
     * @return
     */
    @Override
    public JsonResult companyBzjAdd(long id, long plus, String token) {

        SysUser sysUser = this.getSysUserByToken(token);

        AcUser acUser = acUserMapper.selectByPrimaryKey(id);
        long bzj = Long.valueOf(acUser.getBzj()) + plus;
        acUser.setBzj(String.valueOf(bzj));

        int i = acUserMapper.updateByPrimaryKeySelective(acUser);
        if (i > 0) {
            String acUserToken = jedisClient.hget("AC_USER_PHONE", acUser.getPhone() + "");
            if (StringUtils.isNotBlank(acUserToken)) {
                jedisClient.hset("AC_USER_TOKEN", acUserToken, JsonUtils.objectToJson(acUser));
            }
            AcBzjRecord record = new AcBzjRecord();
            record.setPlus(plus);
            record.setUserId(id);
            record.setCreateTime(new Date());
            record.setCreateUser(sysUser.getUsername());
            acBzjRecordMapper.insertSelective(record);
            return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 查询正在拍的车辆
     *
     * @return
     */
    @Override
    public JsonResult auctionCarList() {

        AcAuctionRecordExample example = new AcAuctionRecordExample();
        AcAuctionRecordExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<AcAuctionRecord> acAuctionRecords = acAuctionRecordMapper.selectByExample(example);


        JSONArray list = new JSONArray();

        int num = Integer.parseInt(CH_NUM);
        for (int i = 0; i < num; i++) {
            String key = "CH" + i;
            JSONObject obj = new JSONObject();
            obj.put("name", "通道" + i);
            obj.put("key", key);

            for (AcAuctionRecord record : acAuctionRecords) {
                if (record.getChKey().equals(key)) {
                    Long carId = record.getCarId();
                    String car_info = jedisClient.hget("CAR_INFO", carId + "");
                    CarInfoDto carInfoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
                    obj.put("carInfo", carInfoDto);
                }
            }
            list.add(obj);
        }
        return JsonResult.OK(list);

    }

    /**
     * 修改保留价
     * @param carId
     * @param price
     * @return
     */
    @Override
    public JsonResult setCarSavePrice(long carId, String price) {
        CkCarbase ckCarbase = new CkCarbase();
        ckCarbase.setId(carId);
        ckCarbase.setSavePrice(price);
        int i = carbaseMapper.updateByPrimaryKeySelective(ckCarbase);
        if (i > 0) return JsonResult.OK();


        return JsonResult.Error(OperateEnum.FAILE);

    }

    private SysUser getSysUserByToken(String token) {
        String userStr = jedisClient.get("WEB_LOGIN:" + token);
        SysUser sysUser = JsonUtils.jsonToPojo(userStr, SysUser.class);
        return sysUser;
    }

    private AcUser getAcUserByToken(String token) {
        String ac_user_token = jedisClient.hget("AC_USER_TOKEN", token);
        if (StringUtils.isBlank(ac_user_token)) return null;
        return JsonUtils.jsonToPojo(ac_user_token, AcUser.class);
    }


    /**
     * carInfo
     * 车辆检测信息和车辆基本信息
     *
     * @param carId
     * @return
     */
    private Map<String, Object> getCarInfoandDetailDto(long carId,String ch) {

        CarInfoDto infoDto = new CarInfoDto();
        CarDetailDto detailDto = getCarDetailDto(carId);

        infoDto.setCarId(carId);
        infoDto.setModelName(detailDto.getModelName());
        infoDto.setPfbz(detailDto.getOther().getPfbz());
        infoDto.setPj(detailDto.getOther().getPj());
        infoDto.setZq45(detailDto.getBaseImgArry().get(0).getImg());
        infoDto.setCdrq(detailDto.getDjz().getCdrq());
        infoDto.setZcd(detailDto.getDjz().getZcd());
        infoDto.setNumber(detailDto.getXsz().getNumber().substring(0, 2));
        infoDto.setBxlc(detailDto.getVerify().getBxlc());
        infoDto.setAuctionCount(detailDto.getAuctionCount());
        infoDto.setChKey(ch);
        infoDto.setSavePrice(detailDto.getSavePrice());

        Map<String, Object> map = new HashMap<>();
        map.put("info", infoDto);
        map.put("detail", detailDto);
        return map;
    }

    /**
     * 获取车辆检测详情
     * @param carId
     * @return
     */
    private CarDetailDto getCarDetailDto(long carId){

        CarDetailDto detailDto = new CarDetailDto();
        detailDto.setCarId(carId);

        //ckcarbase
        CkCarbase ckCarbase = carbaseMapper.selectByPrimaryKey(carId);
        //车型全称
        detailDto.setModelName(ckCarbase.getModelName());
        //检测报告编号
        detailDto.setCheckNum("YPRN"+TimeUtils.getFormatDateTime(ckCarbase.getCreateTime(),"yyyyMMdd") + carId);
        //检测报告时间
        detailDto.setCheckDate(TimeUtils.getFormatDateTime3(ckCarbase.getCreateTime()));
        //拍卖次数
        detailDto.setAuctionCount(ckCarbase.getAuctionCount());
        //保留价
        detailDto.setSavePrice(ckCarbase.getSavePrice());


        CkCarmodelExample ex0 = new CkCarmodelExample();
        CkCarmodelExample.Criteria cr0 = ex0.createCriteria();
        cr0.andCarIdEqualTo(carId);
        List<CkCarmodel> ckCarmodels = ckCarmodelMapper.selectByExample(ex0);
        if (ckCarmodels.size() > 0) {
            CkCarmodel ckCarmodel = ckCarmodels.get(0);
            //驱动方式1两驱2四驱
            int qdfs = ckCarmodel.getQdfs();
            switch (qdfs) {
                case 1:
                    detailDto.setQdfs("两驱");
                    break;
                case 2:
                    detailDto.setQdfs("四驱");
                    break;
                default:
                    detailDto.setQdfs("不详");
            }
            //变速箱1手动2自动3CVT
            int bsx = ckCarmodel.getBsx();
            switch (bsx) {
                case 1:
                    detailDto.setBsx("手动");
                    break;
                case 2:
                    detailDto.setBsx("自动");
                    break;
                case 3:
                    detailDto.setBsx("");
                    break;
                default:
                    detailDto.setBsx("不详");
            }
        }

        CkOtherExample ex1 = new CkOtherExample();
        CkOtherExample.Criteria cr1 = ex1.createCriteria();
        cr1.andCarIdEqualTo(carId);
        List<CkOther> ckOthers = ckOtherMapper.selectByExample(ex1);
        if (ckOthers.size() > 0) {
            CkOther ckOther = ckOthers.get(0);
            OtherDto otherDto = new OtherDto();
            //排放标准 1 国2及以下 2 “国3” 3 “国4” 4 “国5” 5 不详
            int pfbz = ckOther.getPfbz();
            switch (pfbz){
                case 1:
                    otherDto.setPfbz("国2及以下");
                    break;
                case 2:
                    otherDto.setPfbz("国3");
                    break;
                case 3:
                    otherDto.setPfbz("国4");
                    break;
                case 4:
                    otherDto.setPfbz("国5");
                    break;
                case 5:
                    otherDto.setPfbz("不详");
                    break;
                default:
                    otherDto.setPfbz("不详");
            }
            //评级 1A2B3C4D
            int pj = ckOther.getPj();
            switch (pj){
                case 1:
                    otherDto.setPj("A");
                    otherDto.setPjDes1("较好");
                    otherDto.setPjDes2("全车除前后保险杠外无修复痕迹");
                    break;
                case 2:
                    otherDto.setPj("B");
                    otherDto.setPjDes1("良好");
                    otherDto.setPjDes2("全车结构件无损伤，加强件无严重损伤，允许覆盖件和加强件有修复");
                    break;
                case 3:
                    otherDto.setPj("C");
                    otherDto.setPjDes1("一般");
                    otherDto.setPjDes2("全车结构件无重大损伤，允许覆盖件和加强件有修复");
                    break;
                case 4:
                    otherDto.setPj("D");
                    otherDto.setPjDes1("较差");
                    otherDto.setPjDes2("全车结构件发生一处或多处变形类损伤");
                    break;
                default:
                    otherDto.setPj("不详");
                    otherDto.setPjDes1("不详");
                    otherDto.setPjDes2("不详");
            }
            //违章
            int wzF = ckOther.getWzF();
            String wzQ = ckOther.getWzQ();
            if(wzF==0){
                otherDto.setWz("无");
            }else{
                otherDto.setWz(wzF+"分"+ (wzQ==null?"0":wzQ) + "元");
            }
            //其他提示
            otherDto.setOther(ckOther.getOther()==null?"无":ckOther.getOther());
            detailDto.setOther(otherDto);
        }

        CkBaseimgExample ex2 = new CkBaseimgExample();
        CkBaseimgExample.Criteria c2 = ex2.createCriteria();
        c2.andCarIdEqualTo(carId);
        List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(ex2);
        if (ckBaseimgs.size() > 0) {
            CkBaseimg ckBaseimg = ckBaseimgs.get(0);
            //基本照片
            List<ImgDesc> list = new ArrayList<>();
            ImgDesc imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getZq45());
            imgDesc.setDesc("左前45°");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getFdjc());
            imgDesc.setDesc("发动机舱");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getFdjcz());
            imgDesc.setDesc("发动机舱左");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getFdjcy());
            imgDesc.setDesc("发动机舱右");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getLtxh());
            imgDesc.setDesc("轮胎型号");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getQpzy());
            imgDesc.setDesc("前排座椅");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getYbp());
            imgDesc.setDesc("仪表盘");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getHpzy());
            imgDesc.setDesc("后排座椅");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getZkt());
            imgDesc.setDesc("中控台");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getHbx());
            imgDesc.setDesc("后备箱");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getYh45());
            imgDesc.setDesc("右后45°");
            list.add(imgDesc);
            imgDesc = new ImgDesc();
            imgDesc.setImg(ckBaseimg.getYs());
            imgDesc.setDesc("钥匙");
            list.add(imgDesc);
            detailDto.setBaseImgArry(list);

        }

        CkDjzExample ex3 = new CkDjzExample();
        CkDjzExample.Criteria c3 = ex3.createCriteria();
        c3.andCarIdEqualTo(carId);
        List<CkDjz> ckDjzs = djzMapper.selectByExample(ex3);
        if (ckDjzs.size() > 0) {
            CkDjz ckDjz = ckDjzs.get(0);
            DjzDto djz = new DjzDto();
            //初登日期
            djz.setCdrq(ckDjz.getCdrq()==null?"不详":ckDjz.getCdrq());
            //注册地
            djz.setZcd(ckDjz.getZcd()==null?"不详":ckDjz.getZcd());
            //出厂日期
            djz.setCcrq(ckDjz.getCcrq()==null?"不详":ckDjz.getCcrq());
            //排量
            djz.setPl(ckDjz.getPl()==null?"不详":ckDjz.getPl());
            //核定载客数
            djz.setHdzks(ckDjz.getHdzks()==null?"不详":ckDjz.getHdzks());
            //轮胎规格
            djz.setLtgg(ckDjz.getLtgg()==null?"不详":ckDjz.getLtgg());
            //过户次数
            djz.setGhcs(ckDjz.getGhcs()==null?"不详":ckDjz.getGhcs());
            //最后一次过户时间
            djz.setZhghsj(ckDjz.getZhghsj()==null?"不详":ckDjz.getZhghsj());
            //最后转入地
            djz.setYzrd(ckDjz.getYzrd()==null?"不详":ckDjz.getYzrd());

            //燃烧种类 1汽油2柴油3纯电动4混合动力5天然气
            int rszl = ckDjz.getRszl();
            switch (rszl) {
                case 1:
                    djz.setRszl("汽油");
                    break;
                case 2:
                    djz.setRszl("柴油");
                    break;
                case 3:
                    djz.setRszl("纯电动");
                    break;
                case 4:
                    djz.setRszl("混合动力");
                    break;
                case 5:
                    djz.setRszl("天然气");
                    break;
                default:djz.setRszl("不详");
            }
            //车身颜色 1黑2蓝3白4红5银6金7绿8灰9紫10黄11橙12粉13其他颜色
            int color= ckDjz.getColor();
            switch (color) {
                case 1:
                    djz.setColor("黑");
                    break;
                case 2:
                    djz.setColor("蓝");
                    break;
                case 3:
                    djz.setColor("白");
                    break;
                case 4:
                    djz.setColor("红");
                    break;
                case 5:
                    djz.setColor("银");
                    break;
                case 6:
                    djz.setColor("金");
                    break;
                case 7:
                    djz.setColor("绿");
                    break;
                case 8:
                    djz.setColor("灰");
                    break;
                case 9:
                    djz.setColor("紫");
                    break;
                case 10:
                    djz.setColor("黄");
                    break;
                case 11:
                    djz.setColor("橙");
                    break;
                case 12:
                    djz.setColor("粉");
                    break;
                case 13:
                    djz.setColor("其他颜色");
                    break;
                default:
                    djz.setColor("不详");

            }
            //原使用方 1个人2单位3出租车4汽车租赁公司5汽车销售（服务）公司',
            djz.setYsyf(getSYF(ckDjz.getYsyf()));
            //现使用方 1个人2单位3出租车4汽车租赁公司5汽车销售（服务）公司',
            djz.setXsyf(getSYF(ckDjz.getXsyf()));
            //是否进口 1非进口2海关罚没3境外自带4海关进口5海关监管
            int jk = ckDjz.getJk();
            switch (jk) {
                case 1: djz.setJk("非进口"); break;
                case 2: djz.setJk("海关罚没"); break;
                case 3: djz.setJk("境外自带"); break;
                case 4: djz.setJk("海关进口"); break;
                case 5: djz.setJk("海关监管"); break;
                default: djz.setJk("不详");
            }
            //0未见1见
            djz.setWj(ckDjz.getWj()==0?"未见":"有");
            detailDto.setDjz(djz);
        }

        CkXszExample ex4 = new CkXszExample();
        CkXszExample.Criteria c4 = ex4.createCriteria();
        c4.andCarIdEqualTo(carId);
        List<CkXsz> ckXszs = ckXszMapper.selectByExample(ex4);
        if (ckXszs.size() > 0) {
            CkXsz ckXsz = ckXszs.get(0);
            XszDto xsz = new XszDto();
            //0未见1见
            xsz.setWj(ckXsz.getWj()==0?"未见":"有");
            //牌照号码
            xsz.setNumber(ckXsz.getNumber().substring(0, 2));
            //车辆类型 1微型车2小型车3中型车4大型车
            int lx = ckXsz.getLx();
            switch (lx) {
                case 1: xsz.setLx("微型车"); break;
                case 2: xsz.setLx("小型车"); break;
                case 3: xsz.setLx("中型车"); break;
                case 4: xsz.setLx("大型车"); break;
                default:xsz.setLx("不详");
            }

            //使用性质 1非营运2运营3营转非4租赁5教练
            int xz = ckXsz.getXz();
            switch (xz) {
                case 1:xsz.setXz("非营运");break;
                case 2:xsz.setXz("运营");break;
                case 3:xsz.setXz("营转非");break;
                case 4:xsz.setXz("租赁");break;
                case 5:xsz.setXz("教练");break;
                default:xsz.setXz("不详");
            }
            //品牌型号
            xsz.setPpxh(ckXsz.getPpxh());
            //发动机号
            xsz.setFdjh(ckXsz.getFdjh().substring(0, 7));
            //年检号
            xsz.setNjh(ckXsz.getNjh());
            detailDto.setXsz(xsz);
        }

        CkVerifyExample ex5 = new CkVerifyExample();
        CkVerifyExample.Criteria c5 = ex5.createCriteria();
        c5.andCarIdEqualTo(carId);
        List<CkVerify> ckVerifies = ckVerifyMapper.selectByExample(ex5);
        if (ckVerifies.size() > 0) {
            CkVerify ckVerify = ckVerifies.get(0);
            VerIfyDto verify = new VerIfyDto();
            //表显里程
            verify.setBxlc(ckVerify.getBxlc());
            //1实车铭牌破损2实车铭牌未3铭牌日期与登记证不一致
            String text = "";
            String djz = ckVerify.getDjz();
            if (djz.contains("1")) {
                text += "铭牌破损";
            }
            if (djz.contains("2")) {
                text += "铭牌未见";
            }
            if (djz.contains("3")) {
                text += "铭牌日期与登记证不一致";
            }
            if(StringUtils.isBlank(text)){
                verify.setDjz("有");
            }else{
                verify.setDjz(text);
            }

            //行驶证和实车照片1天窗不一致2车窗覆盖件不一致3中网不一致4颜色不一致(贴纸)5轮毂不一致6前照灯总成不一致
            text = "";
            String xsz = ckVerify.getXsz();
            if (xsz.contains("1")) {
                text += "天窗不一致";
            }
            if (xsz.contains("2")) {
                text += "车窗覆盖件不一致";
            }
            if (xsz.contains("3")) {
                text += "中网不一致";
            }
            if (xsz.contains("4")) {
                text += "颜色不一致(贴纸)";
            }
            if (xsz.contains("5")) {
                text += "轮毂不一致";
            }
            if (xsz.contains("6")) {
                text += "前照灯总成不一致";
            }
            if(StringUtils.isBlank(text)){
                verify.setXsz("实车与行驶证照片相符");
            }else{
                verify.setXsz(text);
            }
            detailDto.setVerify(verify);

        }

        CkQtzExample ex6 = new CkQtzExample();
        CkQtzExample.Criteria cr6 = ex6.createCriteria();
        cr6.andCarIdEqualTo(carId);
        List<CkQtz> ckQtzs = ckQtzMapper.selectByExample(ex6);
        if (ckQtzs.size() > 0) {
            CkQtz ckQtz = ckQtzs.get(0);
            QtzDto qtz = new QtzDto();
            //交强险到期日
            qtz.setJqxrq(ckQtz.getJqxrq());
            //车船税
            qtz.setCcx(ckQtz.getCcx());
            //购置税 1购置税政（征税）2购置税政（免税）3无购置税政
            int gzs = ckQtz.getGzs();
            switch (gzs) {
                case 1: qtz.setGzs("购置税政（征税）"); break;
                case 2: qtz.setGzs("购置税政（免税）"); break;
                case 3: qtz.setGzs("无购置税政"); break;
                default:qtz.setGzs("不详");
            }
            //备用钥匙 0有1无
            qtz.setByys(ckQtz.getByys()==0?"有":"无");
            //过户票
            qtz.setGhp(ckQtz.getGhp()==0?"有":"无");
            //交强险所在地
            qtz.setJqxd(ckQtz.getJqxd());
            detailDto.setQtz(qtz);
        }

        CkPzExample ex7 = new CkPzExample();
        CkPzExample.Criteria cr7 = ex7.createCriteria();
        cr7.andCarIdEqualTo(carId);
        List<CkPz> ckPzs = ckPzMapper.selectByExample(ex7);
        if (ckPzs.size() > 0) {
            CkPz ckPz = ckPzs.get(0);
            PzDto dto = new PzDto();

            //abs
            dto.setAbs(ckPz.getAbs()==0?"无":"有");
            dto.setAbsBug(getGZ(ckPz.getAbsBug()));
            //气囊0无1一个2两个3三个4四个
            int qn = ckPz.getQn();
            switch (qn) {
                case 0:
                    dto.setQn("无");
                    dto.setQnBug("");
                    break;
                case 1:
                    dto.setQn("一个");
                    dto.setQnBug(getGZ(ckPz.getQnBug()));
                    break;
                case 2:
                    dto.setQn("两个");
                    dto.setQnBug(getGZ(ckPz.getQnBug()));
                    break;
                case 3:
                    dto.setQn("三个");
                    dto.setQnBug(getGZ(ckPz.getQnBug()));
                    break;
                case 4:
                    dto.setQn("四个");
                    dto.setQnBug(getGZ(ckPz.getQnBug()));
                    break;
                default:
                    dto.setQn("不详");
                    dto.setQnBug("");

            }
            dto.setZxzl(ckPz.getZxzl()==0?"无":"有");
            dto.setZxzlBug(getGZ(ckPz.getZxzlBug()));

            //车窗玻璃1四门电动2手动3两门电动
            int ccbl = ckPz.getCcbl();
            switch (ccbl) {
                case 1: dto.setCcbl("四门电动"); break;
                case 2: dto.setCcbl("手动"); break;
                case 3: dto.setCcbl("两门电动"); break;
                default: dto.setCcbl("不详");
            }
            dto.setCcblBug(getGZ(ckPz.getCcblBug()));

            //天窗0无1有2全景3加装
            int tc = ckPz.getTc();
            switch (tc) {
                case 0: dto.setTc("无"); break;
                case 1: dto.setTc("有"); break;
                case 2: dto.setTc("全景"); break;
                case 3: dto.setTc("加装"); break;
                default: dto.setTc("不详");
            }
            dto.setTcBug(getGZ(ckPz.getTcBug()));

            //车外后视镜1电折叠	2电动调节	3手动调节
            int cwhsj = ckPz.getCwhsj();
            switch (cwhsj) {
                case 1: dto.setCwhsj("电折叠"); break;
                case 2: dto.setCwhsj("电动调节"); break;
                case 3: dto.setCwhsj("手动调节"); break;
                default: dto.setCwhsj("不详");
            }
            dto.setCwhsjBug(getGZ(ckPz.getCwhsjBug()));

            //座椅材质1织布2真皮3改装真皮4混合材质
            int zycz = ckPz.getZycz();
            switch (zycz) {
                case 1: dto.setZycz("织布"); break;
                case 2: dto.setZycz("真皮"); break;
                case 3: dto.setZycz("改装真皮"); break;
                case 4: dto.setZycz("混合材质"); break;
                default: dto.setZycz("不详");
            }
            //座椅调节方式1手动2电动3记忆
            int zytjfs = ckPz.getZytjfs();
            switch (zytjfs) {
                case 1: dto.setZytjfs("手动"); break;
                case 2: dto.setZytjfs("电动"); break;
                case 3: dto.setZytjfs("记忆"); break;
                default: dto.setZytjfs("不详");
            }
            //座椅功能1电加热2通风3按摩0无
            int zygn = ckPz.getZygn();
            switch (zygn) {
                case 0: dto.setZygn("无"); break;
                case 1: dto.setZygn("电加热"); break;
                case 2: dto.setZygn("通风"); break;
                case 3: dto.setZygn("按摩"); break;
                default: dto.setZygn("不详");
            }
            dto.setZyBug(getGZ(ckPz.getZyBug()));

            //空调0无1手动2自动3前后
            int kt = ckPz.getKt();
            switch (kt) {
                case 0: dto.setKt("无"); break;
                case 1: dto.setKt("手动"); break;
                case 2: dto.setKt("自动"); break;
                case 3: dto.setKt("前后"); break;
                default: dto.setKt("不详");
            }
            dto.setKtBug(getGZ(ckPz.getKtBug()));

            //影音设备0无1收音机2CD3加装CD4前屏DVD5多屏DVD6加装单屏DVD7加装多屏DVD
            int yysb = ckPz.getYysb();
            switch (yysb) {
                case 0: dto.setYysb("无"); break;
                case 1: dto.setYysb("收音机"); break;
                case 2: dto.setYysb("CD"); break;
                case 3: dto.setYysb("加装CD"); break;
                case 4: dto.setYysb("前屏DVD"); break;
                case 5: dto.setYysb("多屏DVD"); break;
                case 6: dto.setYysb("加装单屏DVD"); break;
                case 7: dto.setYysb("加装多屏DVD"); break;
                default: dto.setYysb("不详");
            }
            dto.setYysbBug(getGZ(ckPz.getYysbBug()));
            //导航
            dto.setDh(ckPz.getDh()==0?"无":"有");
            dto.setDhBug(getGZ(ckPz.getDhBug()));
            //定速巡航 0无	1有	2加装
            int dsxh = ckPz.getDsxh();
            switch (dsxh) {
                case 0: dto.setDsxh("无"); break;
                case 1: dto.setDsxh("有"); break;
                case 2: dto.setDsxh("加装"); break;
                default: dto.setDsxh("不详");
            }
            dto.setDsxhBug(getGZ(ckPz.getDsxhBug()));

            //倒车雷达 0无	1有	2加装	3前后
            int dcld = ckPz.getDcld();
            switch (dcld) {
                case 0: dto.setDcld("无"); break;
                case 1: dto.setDcld("有"); break;
                case 2: dto.setDcld("加装"); break;
                case 3: dto.setDcld("前后"); break;
                default: dto.setDcld("不详");
            }
            dto.setDcldBug(getGZ(ckPz.getDsxhBug()));

            //倒车影像 0无	1有	2全景	3加装
            int dcyx = ckPz.getDcyx();
            switch (dcyx) {
                case 0: dto.setDcyx("无"); break;
                case 1: dto.setDcyx("有"); break;
                case 2: dto.setDcyx("全景"); break;
                case 3: dto.setDcyx("加装"); break;
                default: dto.setDcyx("不详");
            }
            dto.setDcyxBug(getGZ(ckPz.getDcyxBug()));

            //轮毂 1钢	2铝合金
            dto.setLg(ckPz.getLg()==1?"钢":"铝合金");
            dto.setLgBug(getGZ(ckPz.getLgBug()));

            //起动机缺陷类型1故障2卡滞3异响4漏油5沉重
            dto.setQdjBug(getGZ(ckPz.getQdjBug()));

            dto.setGzdBug(ckPz.getGzdBug());

            dto.setOther(ckPz.getOther()==null?"无":ckPz.getOther());
            dto.setOtherBug(getGZ(ckPz.getOtherBug()));

            detailDto.setPz(dto);
        }

        CkDlExample ex8 = new CkDlExample();
        CkDlExample.Criteria cr8 = ex8.createCriteria();
        cr8.andCarIdEqualTo(carId);
        List<CkDl> ckDls = ckDlMapper.selectByExample(ex8);
        if (ckDls.size() > 0) {
            CkDl ckDl = ckDls.get(0);
            DlDto dto = new DlDto();
            //发动机性能 -1正常 1异响 2漏油 3水温高 4运转不平稳
            int fdjXn = ckDl.getFdjXn();
            switch (fdjXn) {
                case -1: dto.setFdjXn("正常"); break;
                case 1: dto.setFdjXn("异响"); break;
                case 2: dto.setFdjXn("漏油"); break;
                case 3: dto.setFdjXn("水温高"); break;
                case 4: dto.setFdjXn("运转不平稳"); break;
                default: dto.setFdjXn("不详");
            }
            //发动机尾气 -1正常 1冒蓝烟 2冒黑烟 3冒白烟  4改装
            int fdjWq = ckDl.getFdjWq();
            switch (fdjWq) {
                case -1: dto.setFdjWq("正常"); break;
                case 1: dto.setFdjWq("冒蓝烟"); break;
                case 2: dto.setFdjWq("冒黑烟"); break;
                case 3: dto.setFdjWq("冒白烟"); break;
                case 4: dto.setFdjWq("改装"); break;
                default: dto.setFdjWq("不详");
            }
            //变速器 -1正常 1闯档 2换档有冲击
            int bsq = ckDl.getBsq();
            switch (bsq) {
                case -1: dto.setBsq("正常"); break;
                case 1: dto.setBsq("闯档"); break;
                case 2: dto.setBsq("换档有冲击"); break;
                default: dto.setBsq("不详");
            }
            detailDto.setDl(dto);
        }


        CkCksgExample ex9 = new CkCksgExample();
        CkCksgExample.Criteria cr9 = ex9.createCriteria();
        cr9.andCarIdEqualTo(carId);
        List<CkCksg> ckCksgs = ckCksgMapper.selectByExample(ex9);
        List<ImgDesc> sg = new ArrayList<>();
        for (CkCksg ckCksg : ckCksgs) {
            ImgDesc imgDesc = new ImgDesc();
            imgDesc.setDesc(ckCksg.getDes());
            imgDesc.setImg(ckCksg.getImg());
            sg.add(imgDesc);
        }
        detailDto.setSg(sg);


        CkCkpsExample ex10 = new CkCkpsExample();
        CkCkpsExample.Criteria cr10 = ex10.createCriteria();
        cr10.andCarIdEqualTo(carId);
        List<CkCkps> ckCkps = ckCkpsMapper.selectByExample(ex10);
        List<ImgDesc> ps = new ArrayList<>();
        for (CkCkps ckCkp : ckCkps) {
            ImgDesc imgDesc = new ImgDesc();
            imgDesc.setDesc(ckCkp.getDes());
            imgDesc.setImg(ckCkp.getImg());
            sg.add(imgDesc);
        }
        detailDto.setPs(ps);


        CkCkhsExample ex11 = new CkCkhsExample();
        CkCkhsExample.Criteria cr11 = ex11.createCriteria();
        cr11.andCarIdEqualTo(carId);
        List<CkCkhs> ckCkhs = ckCkhsMapper.selectByExample(ex11);
        List<ImgDesc> hs = new ArrayList<>();
        for (CkCkhs ckCkh : ckCkhs) {
            ImgDesc imgDesc = new ImgDesc();
            imgDesc.setDesc(ckCkh.getDes());
            imgDesc.setImg(ckCkh.getImg());
            hs.add(imgDesc);
        }
        detailDto.setHs(hs);

        CkCkwgqxExample ex12 = new CkCkwgqxExample();
        CkCkwgqxExample.Criteria cr12 = ex12.createCriteria();
        cr12.andCarIdEqualTo(carId);
        List<CkCkwgqx> ckCkwgqxes = ckCkwgqxMapper.selectByExample(ex12);
        List<ImgDesc> wgqx = new ArrayList<>();
        for (CkCkwgqx ckCkwgqx : ckCkwgqxes) {
            ImgDesc imgDesc = new ImgDesc();
            imgDesc.setDesc(ckCkwgqx.getDes());
            imgDesc.setImg(ckCkwgqx.getImg());
            wgqx.add(imgDesc);
        }
        detailDto.setWgqx(wgqx);

        CkCknsqxExample ex13 = new CkCknsqxExample();
        CkCknsqxExample.Criteria cr13 = ex13.createCriteria();
        cr13.andCarIdEqualTo(carId);
        List<CkCknsqx> ckCknsqxes = ckCknsqxMapper.selectByExample(ex13);
        List<ImgDesc> nsqx = new ArrayList<>();
        for (CkCknsqx ckCknsqx : ckCknsqxes) {
            ImgDesc imgDesc = new ImgDesc();
            imgDesc.setDesc(ckCknsqx.getDes());
            imgDesc.setImg(ckCknsqx.getImg());
            nsqx.add(imgDesc);
        }
        detailDto.setNsqx(nsqx);

        return detailDto;
    }

    /**
     * 使用方转换
     * @param tag
     * @return
     */
    private String getSYF(int tag){
        String text = "";
        switch (tag) {
            case 1:text = "个人";break;
            case 2:text = "单位";break;
            case 3:text = "出租车";break;
            case 4:text = "汽车租赁公司";break;
            case 5:text = "汽车销售（服务）公司";break;
            default:text = "不详";
        }
        return text;
    }

    /**
     * 缺陷类型转换
     * 缺陷类型1故障2卡滞3异响4漏油5沉重
     * @param tag
     * @return
     */
    private String getGZ(int tag){
        String text = "";
        switch (tag){
            case -1:text = "正常";break;
            case 1:text = "故障";break;
            case 2:text = "卡滞";break;
            case 3:text = "异响";break;
            case 4:text = "漏油";break;
            case 5:text = "沉重";break;
            default:text = "";
        }
        return text;
    }
}
