package com.maizhong.auction.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.mapper.CkUserMapper;
import com.maizhong.auction.mapper.SysCompanyMapper;
import com.maizhong.auction.mapper.SysUserMapper;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.SystemService;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    private JedisClient jedisClient;

    @Override
    public JsonResult getSysAccountList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(),param.getPageSize());

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);

        if(StringUtils.isNotBlank(param.getFiled("username"))){
            criteria.andUsernameLike(SqlUtils.getLikeSql(param.getFiled("username")));
        }
        if(StringUtils.isNotBlank(param.getFiled("phoneNum"))){
            criteria.andPhoneNumEqualTo(Long.valueOf(param.getFiled("phoneNum")));
        }

        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(sysUsers);

        return JsonResult.OK(pageInfo);
    }

    /**
     * 系统用户保存
     * @param user
     * @param token
     * @return
     */
    @Override
    public JsonResult saveSysAccount(SysUser user, String token) {
        SysUser sysUser = this.getSysUserByToken(token);



        if (user.getId()==-1){
            //新增
            SysUserExample example = new SysUserExample();
            SysUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneNumEqualTo(user.getPhoneNum()).andDelflagEqualTo(0);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
            if(sysUsers.size()>0)return JsonResult.Error("手机号重复");

            user.setId(null);
            user.setCreateTime(new Date());
            user.setPassword(IDUtils.sha256("123456"));
            user.setStatus(1);
            user.setDelflag(0);
            int i = sysUserMapper.insertSelective(user);
            if(i>0)return JsonResult.OK(OperateEnum.SUCCESS);
        }else{
            //更新
            SysUserExample example = new SysUserExample();
            SysUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneNumEqualTo(user.getPhoneNum()).andDelflagEqualTo(0).andIdNotEqualTo(user.getId());
            List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
            if(sysUsers.size()>0)return JsonResult.Error("手机号重复");

            int i = sysUserMapper.updateByPrimaryKeySelective(user);
            if(i>0)return JsonResult.OK(OperateEnum.SUCCESS);
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 用户状态修改
     * @param id
     * @param status
     * @return
     */
    @Override
    public JsonResult statusSysAccount(long id, int status) {

        SysUser user = new SysUser();
        user.setId(id);
        user.setStatus(status==1?0:1);
        int i = sysUserMapper.updateByPrimaryKeySelective(user);
        if(i>0)return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 用户删除
     * @param id
     * @return
     */
    @Override
    public JsonResult delSysAccount(long id) {

        SysUser user = new SysUser();
        user.setId(id);
        user.setDelflag(1);
        int i = sysUserMapper.updateByPrimaryKeySelective(user);
        if(i>0)return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取检测端用户
     * @param param
     * @return
     */
    @Override
    public JsonResult getCheckAccountList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(),param.getPageSize());

        CkUserExample example = new CkUserExample();
        CkUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);

        if(StringUtils.isNotBlank(param.getFiled("username"))){
            criteria.andUserNameLike(SqlUtils.getLikeSql(param.getFiled("username")));
        }
        if(StringUtils.isNotBlank(param.getFiled("phoneNum"))){
            criteria.andUserPhoneEqualTo(Long.valueOf(param.getFiled("phoneNum")));
        }
        if(StringUtils.isNotBlank(param.getFiled("companyId"))){
            criteria.andComanyIdEqualTo(Long.valueOf(param.getFiled("companyId")));
        }

        SysCompanyExample companyExample = new SysCompanyExample();
        SysCompanyExample.Criteria companyExampleCriteria = companyExample.createCriteria();
        companyExampleCriteria.andStatusEqualTo(1).andDelflagEqualTo(0);
        List<SysCompany> sysCompanies = sysCompanyMapper.selectByExample(companyExample);


        List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
        for (CkUser ckUser : ckUsers) {
            for (SysCompany company : sysCompanies) {
                if(company.getId().equals(ckUser.getComanyId())){
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
     * @param user
     * @param token
     * @return
     */
    @Override
    public JsonResult saveCheckAccount(CkUser user, String token) {
        CkUserExample example = new CkUserExample();
        CkUserExample.Criteria criteria = example.createCriteria();
        if(user.getId()==-1){

            criteria.andUserPhoneEqualTo(user.getUserPhone());
            List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
            if(ckUsers.size()>0)return JsonResult.Error("手机号重复");
            //新增
            user.setId(null);
            user.setDelflag(0);
            user.setStatus(1);
            user.setPassword(IDUtils.sha256("123456"));
            user.setUpdateTime(new Date());
            int i = ckUserMapper.insertSelective(user);
            if(i>0)return JsonResult.OK();

        }else{
            //更新
            criteria.andUserPhoneEqualTo(user.getUserPhone()).andIdNotEqualTo(user.getId());
            List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
            if(ckUsers.size()>0)return JsonResult.Error("手机号重复");
            int i = ckUserMapper.updateByPrimaryKeySelective(user);
            if(i>0)return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 检测端用户状态修改
     * @param id
     * @param status
     * @return
     */
    @Override
    public JsonResult statusCheckAccount(long id, int status) {

        CkUser user = new CkUser();
        user.setId(id);
        user.setStatus(status==1?0:1);
        int i = ckUserMapper.updateByPrimaryKeySelective(user);
        if(i>0)return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 检测端用户删除
     * @param id
     * @return
     */
    @Override
    public JsonResult delSCheckAccount(long id) {
        CkUser user = new CkUser();
        user.setId(id);
        user.setDelflag(1);
        int i = ckUserMapper.updateByPrimaryKeySelective(user);
        if(i>0)return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取商户列表
     * @param param
     * @return
     */
    @Override
    public JsonResult getCompanyList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(),param.getPageSize());

        SysCompanyExample example = new SysCompanyExample();
        SysCompanyExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        if(StringUtils.isNotBlank(param.getFiled("name"))){
            criteria.andNameLike(SqlUtils.getLikeSql(param.getFiled("name")));
        }

        List<SysCompany> sysCompanies = sysCompanyMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(sysCompanies);

        return JsonResult.OK(pageInfo);
    }

    /**
     * 保存修改商户信息
     * @param company
     * @param token
     * @return
     */
    @Override
    public JsonResult saveCompany(SysCompany company, String token) {

        if (company.getId()==-1){
            //新增
            company.setId(null);
            company.setStatus(1);
            company.setDelflag(0);
            company.setCreateTime(new Date());
            int i = sysCompanyMapper.insertSelective(company);
            if(i>0)return JsonResult.OK();



        }else{
            //修改
            int i = sysCompanyMapper.updateByPrimaryKeySelective(company);
            if(i>0)return JsonResult.OK();
        }

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 修改商户状态
     * @param id
     * @param status
     * @return
     */
    @Override
    @Transactional
    public JsonResult statusCompany(long id, int status) {
        SysCompany company = new SysCompany();
        company.setId(id);
        company.setStatus(status==1?0:1);
        int i = sysCompanyMapper.updateByPrimaryKeySelective(company);
        if(i>0){
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
        if(i>0){
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

    private SysUser getSysUserByToken(String token){
        String userStr = jedisClient.get("WEB_LOGIN:" + token);
        SysUser sysUser = JsonUtils.jsonToPojo(userStr, SysUser.class);
        return sysUser;
    }
}
