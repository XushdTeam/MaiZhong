package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.CheckService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xushd on 2017/6/14.
 */
@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CkUserMapper ckUserMapper;
    @Autowired
    private CkFeedbackMapper ckFeedbackMapper;
    @Autowired
    private CkNewsMapper ckNewsMapper;
    @Autowired
    private CkHelpMapper ckHelpMapper;
    @Autowired
    private CkCarbaseMapper ckCarbaseMapper;
    @Autowired
    private CkXszMapper ckXszMapper;
    @Autowired
    private CkDjzMapper ckDjzMapper;
    @Autowired
    private CkQtzMapper ckQtzMapper;
    @Autowired
    private CkCzinfoMapper ckCzinfoMapper;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public JsonResult checkLogin(String account, String pass) {

        if(StringUtils.isBlank(account)){
            return JsonResult.Error("帐号为空");
        }
        if(StringUtils.isBlank(pass)){
            return JsonResult.Error("密码为空");
        }
        CkUserExample example = new CkUserExample();
        CkUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(Long.valueOf(account));
        List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
        if(ckUsers.size()==0){
            return JsonResult.Error("用户不存在");
        } else {
            CkUser ckUser = ckUsers.get(0);
            if(!StringUtils.equals(pass,ckUser.getPassword())){
                return JsonResult.Error("密码错误");
            }else{
                //判断用户以前是否登陆过
                String redisToken = jedisClient.hget("CHECK_ACCOUNT_TOKEN",account);
                if(StringUtils.isBlank(redisToken)){
                    redisToken = IDUtils.getUUID();
                    jedisClient.hset("CHECK_TOKEN_ACCOUNT",account,redisToken);
                }
                jedisClient.hset("CHECK_ACCOUNT_TOKEN",redisToken,account);
                jedisClient.hset("CHECK_ACCOUNT_USER",redisToken,JsonUtils.objectToJson(ckUser));
                ckUser.setPassword(null);
                return JsonResult.build(200,redisToken,ckUser);
            }
        }
    }

    @Override
    public JsonResult changePwd(String pass, String token) {
        String account = jedisClient.hget("CHECK_ACCOUNT_TOKEN",token);
        if(StringUtils.isBlank(account)){
            return JsonResult.Error("帐号不存在");
        }else{
            CkUser ckUser = new CkUser();
            ckUser.setPassword(pass);
            CkUserExample example = new CkUserExample();
            CkUserExample.Criteria criteria = example.createCriteria();
            criteria.andUserPhoneEqualTo(Long.valueOf(account));
            int i = ckUserMapper.updateByExampleSelective(ckUser, example);
            if(i>0){
                return JsonResult.OK();
            }else{
                return JsonResult.build(OperateEnum.SERVER_ERROR);
            }
        }

    }

    @Override
    public JsonResult feedback(String content, String token) {

        String redisUser = jedisClient.hget("CHECK_ACCOUNT_USER",token);
        CkUser ckUser = JsonUtils.jsonToPojo(redisUser, CkUser.class);

        CkFeedback feedback = new CkFeedback();
        feedback.setFeedback(content);
        feedback.setUserName(ckUser.getUserName());
        feedback.setUserPhone(ckUser.getUserPhone());
        feedback.setUpdateTime(new Date());

        int insert = ckFeedbackMapper.insert(feedback);
        if(insert>0){
            return JsonResult.OK();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult getHelp() {
        CkHelpExample example = new CkHelpExample();
        List<CkHelp> ckHelps = ckHelpMapper.selectByExample(example);
        for (CkHelp ckHelp : ckHelps) {
            ckHelp.setHelpContent(null);
        }

        return JsonResult.OK(ckHelps);
    }

    @Override
    public JsonResult getHelpDetail(long id) {
        CkHelp ckHelp = ckHelpMapper.selectByPrimaryKey(id);
        return JsonResult.OK(ckHelp);
    }

    @Override
    public JsonResult getNewsList() {

        CkNewsExample example = new CkNewsExample();
        example.setOrderByClause("update_time desc");
        List<CkNews> ckNewses = ckNewsMapper.selectByExample(example);

        JSONObject object = new JSONObject();
        //新闻
        List<CkNews> news1 = new ArrayList<>();
        //公告
        List<CkNews> news2 = new ArrayList<>();
        for (CkNews ckNewse : ckNewses) {
            if(ckNewse.getType()==0){
                news1.add(ckNewse);
            }else{
                news2.add(ckNewse);
            }
        }
        object.put("news1",news1);
        object.put("news2",news2);

        return JsonResult.OK(object);

    }

    @Override
    public JsonResult getNewsDetail(long id) {
        CkNews ckNews = ckNewsMapper.selectByPrimaryKey(id);
        return JsonResult.OK(ckNews);

    }

    @Override
    public JsonResult newCarbase(String token) {
        CkUser user = this.getUserByToken(token);
        CkCarbase carbase = new CkCarbase();
        carbase.setStatus(0);
        carbase.setUserName(user.getUserName());
        carbase.setUserPhone(user.getUserPhone());
        carbase.setCreateTime(new Date());
        int i = ckCarbaseMapper.insertSelective(carbase);
        if(i>0){
            return JsonResult.OK(carbase);
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult checkCarList(String token) {
        CkUser user = this.getUserByToken(token);
        CkCarbaseExample example = new CkCarbaseExample();
        example.setOrderByClause(" id DESC ");
        CkCarbaseExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(user.getUserPhone());

        List<CkCarbase> ckCarbases = ckCarbaseMapper.selectByExample(example);
        return JsonResult.OK(ckCarbases);

    }

    @Override
    public JsonResult saveXSZ(CkXsz xsz) {
        if(xsz.getCarId()==null)return JsonResult.Error(OperateEnum.FAILE);
        if(xsz.getId()==-1){
            //新增
            xsz.setId(null);
            int i = ckXszMapper.insertSelective(xsz);
            if(i>0){
                return JsonResult.OK(xsz.getId());
            }
        }else{
            //更新
            int i = ckXszMapper.updateByPrimaryKeySelective(xsz);
            if(i>0){
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult saveDJZ(CkDjz djz) {
        if(djz.getCarId()==null)return JsonResult.Error(OperateEnum.FAILE);
        if(djz.getId()==-1){
            //新增
            djz.setId(null);
            int i = ckDjzMapper.insertSelective(djz);
            if(i>0){
                return JsonResult.OK(djz.getId());
            }
        }else{
            //更新
            int i = ckDjzMapper.updateByPrimaryKeySelective(djz);
            if(i>0){
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult saveQTZ(CkQtz qtz) {
        if(qtz.getCarId()==null)return JsonResult.Error(OperateEnum.FAILE);
        if(qtz.getId()==-1){
            //新增
            qtz.setId(null);
            int i = ckQtzMapper.insertSelective(qtz);
            if(i>0){
                return JsonResult.OK(qtz.getId());
            }
        }else{
            //修改
            int i =ckQtzMapper.updateByPrimaryKeySelective(qtz);
            if(i>0){
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult saveCZXX(CkCzinfo czinfo) {
        if(czinfo.getCarId()==null)return JsonResult.Error(OperateEnum.FAILE);
        if(czinfo.getId()==-1){
            czinfo.setId(null);
            int i = ckCzinfoMapper.insertSelective(czinfo);
            if(i>0){
                return JsonResult.OK(czinfo.getId());
            }
        }else{
            int i = ckCzinfoMapper.updateByPrimaryKeySelective(czinfo);
            if(i>0){
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);

    }


    private CkUser getUserByToken(String token){
        String redisUser = jedisClient.hget("CHECK_ACCOUNT_USER",token);
        CkUser ckUser = JsonUtils.jsonToPojo(redisUser, CkUser.class);
        return ckUser;
    }


}
