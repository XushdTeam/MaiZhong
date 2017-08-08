package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarBaseDto;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.CheckService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private CkBaseimgMapper ckBaseimgMapper;
    @Autowired
    private CkPzMapper ckPzMapper;
    @Autowired
    private CkDlMapper ckDlMapper;

    @Autowired
    private CkCkwgqxMapper ckCkwgqxMapper;
    @Autowired
    private CkCknsqxMapper ckCknsqxMapper;
    @Autowired
    private CkCksgMapper ckCksgMapper;
    @Autowired
    private CkCkpsMapper ckCkpsMapper;
    @Autowired
    private CkCkhsMapper ckCkhsMapper;
    @Autowired
    private CkVerifyMapper ckVerifyMapper;
    @Autowired
    private CkOtherMapper ckOtherMapper;
    @Autowired
    private CkCarmodelMapper carmodelMapper;
    @Autowired
    private PsSaleNeedMapper psSaleNeedMapper;

    @Autowired
    private JedisClient jedisClient;


//    @Resource(name = "transactionManager")
//    private DataSourceTransactionManager transactionManager;


    @Override
    public JsonResult checkLogin(String account, String pass) {

        if (StringUtils.isBlank(account)) {
            return JsonResult.Error("帐号为空");
        }
        if (StringUtils.isBlank(pass)) {
            return JsonResult.Error("密码为空");
        }
        CkUserExample example = new CkUserExample();
        CkUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(Long.valueOf(account));
        List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
        if (ckUsers.size() == 0) {
            return JsonResult.Error("用户不存在");
        } else {
            CkUser ckUser = ckUsers.get(0);
            if (!StringUtils.equals(pass, ckUser.getPassword())) {
                return JsonResult.Error("密码错误");
            } else {
                //判断用户以前是否登陆过
                String redisToken = jedisClient.hget("CHECK_ACCOUNT_TOKEN", account);
                if (StringUtils.isBlank(redisToken)) {
                    redisToken = IDUtils.getUUID();
                    jedisClient.hset("CHECK_TOKEN_ACCOUNT", account, redisToken);
                }
                jedisClient.hset("CHECK_ACCOUNT_TOKEN", redisToken, account);
                jedisClient.hset("CHECK_ACCOUNT_USER", redisToken, JsonUtils.objectToJson(ckUser));
                ckUser.setPassword(null);
                return JsonResult.build(200, redisToken, ckUser);
            }
        }
    }

    @Override
    public JsonResult changePwd(String pass, String token) {
        String account = jedisClient.hget("CHECK_ACCOUNT_TOKEN", token);
        if (StringUtils.isBlank(account)) {
            return JsonResult.Error("帐号不存在");
        } else {
            CkUser ckUser = new CkUser();
            ckUser.setPassword(pass);
            CkUserExample example = new CkUserExample();
            CkUserExample.Criteria criteria = example.createCriteria();
            criteria.andUserPhoneEqualTo(Long.valueOf(account));
            int i = ckUserMapper.updateByExampleSelective(ckUser, example);
            if (i > 0) {
                return JsonResult.OK();
            } else {
                return JsonResult.build(OperateEnum.SERVER_ERROR);
            }
        }

    }

    @Override
    public JsonResult feedback(String content, String token) {

        String redisUser = jedisClient.hget("CHECK_ACCOUNT_USER", token);
        CkUser ckUser = JsonUtils.jsonToPojo(redisUser, CkUser.class);

        CkFeedback feedback = new CkFeedback();
        feedback.setFeedback(content);
        feedback.setUserName(ckUser.getUserName());
        feedback.setUserPhone(ckUser.getUserPhone());
        feedback.setUpdateTime(new Date());

        int insert = ckFeedbackMapper.insert(feedback);
        if (insert > 0) {
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
            if (ckNewse.getType() == 0) {
                news1.add(ckNewse);
            } else {
                news2.add(ckNewse);
            }
        }
        object.put("news1", news1);
        object.put("news2", news2);

        return JsonResult.OK(object);

    }

    @Override
    public JsonResult getNewsDetail(long id) {
        CkNews ckNews = ckNewsMapper.selectByPrimaryKey(id);
        return JsonResult.OK(ckNews);

    }

    @Override
    public JsonResult newCarbase(String token, long ordernum) {
        CkUser user = this.getUserByToken(token);
        CkCarbase carbase = new CkCarbase();
        carbase.setStatus(0);
        carbase.setUserName(user.getUserName());
        carbase.setUserPhone(user.getUserPhone());
        carbase.setCreateTime(new Date());
        carbase.setOrderNum(ordernum);
        int i = ckCarbaseMapper.insertSelective(carbase);
        if (i > 0) {
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
        List<CarBaseDto> list = new ArrayList<>();
        for (CkCarbase ckCarbase : ckCarbases) {
            CarBaseDto dto = new CarBaseDto();
            dto.setId(ckCarbase.getId());
            //左前45
            CkBaseimgExample ckBaseimgExample = new CkBaseimgExample();
            CkBaseimgExample.Criteria criteria1 = ckBaseimgExample.createCriteria();
            criteria1.andCarIdEqualTo(ckCarbase.getId());
            List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(ckBaseimgExample);
            if (ckBaseimgs.size() > 0) {
                dto.setImg(ckBaseimgs.get(0).getZq45());
            }
            //车牌号
            CkXszExample xszExample = new CkXszExample();
            CkXszExample.Criteria xszExampleCriteria = xszExample.createCriteria();
            xszExampleCriteria.andCarIdEqualTo(ckCarbase.getId());
            List<CkXsz> ckXszs = ckXszMapper.selectByExample(xszExample);
            if(ckXszs.size()>0){
                dto.setCarNum(ckXszs.get(0).getNumber());
            }else{
                dto.setCarNum("未录入");
            }
            dto.setModelName(StringUtils.isBlank(ckCarbase.getModelName())?"未适配":ckCarbase.getModelName());
            //model信息

            dto.setCreateTime(TimeUtils.getFormatDateTime3(ckCarbase.getCreateTime()));
            dto.setStatus(ckCarbase.getStatus());
            list.add(dto);
        }
        return JsonResult.OK(list);

    }

    @Override
    public JsonResult saveXSZ(CkXsz xsz) {
        if (xsz.getCarId() == null) return JsonResult.Error(OperateEnum.FAILE);
        if (xsz.getId() == -1) {
            //新增
            xsz.setId(null);
            int i = ckXszMapper.insertSelective(xsz);
            if (i > 0) {

                return JsonResult.OK(xsz.getId());
            }
        } else {
            //更新
            int i = ckXszMapper.updateByPrimaryKeySelective(xsz);
            if (i > 0) {
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult saveDJZ(CkDjz djz) {
        if (djz.getCarId() == null) return JsonResult.Error(OperateEnum.FAILE);
        if (djz.getId() == -1) {
            //新增
            djz.setId(null);
            int i = ckDjzMapper.insertSelective(djz);
            if (i > 0) {
                return JsonResult.OK(djz.getId());
            }
        } else {
            //更新
            int i = ckDjzMapper.updateByPrimaryKeySelective(djz);
            if (i > 0) {
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult saveQTZ(CkQtz qtz) {
        if (qtz.getCarId() == null) return JsonResult.Error(OperateEnum.FAILE);
        if (qtz.getId() == -1) {
            //新增
            qtz.setId(null);
            int i = ckQtzMapper.insertSelective(qtz);
            if (i > 0) {
                return JsonResult.OK(qtz.getId());
            }
        } else {
            //修改
            int i = ckQtzMapper.updateByPrimaryKeySelective(qtz);
            if (i > 0) {
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult saveCZXX(CkCzinfo czinfo) {
        if (czinfo.getCarId() == null) return JsonResult.Error(OperateEnum.FAILE);
        if (czinfo.getId() == -1) {
            czinfo.setId(null);
            int i = ckCzinfoMapper.insertSelective(czinfo);
            if (i > 0) {
                return JsonResult.OK(czinfo.getId());
            }
        } else {
            int i = ckCzinfoMapper.updateByPrimaryKeySelective(czinfo);
            if (i > 0) {
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);

    }

    /**
     * 获取手续信息
     * @param carId
     * @return
     */
    @Override
    public JsonResult getCarStep1(long carId) {

        JSONObject object = new JSONObject();
        //xsz
        CkXszExample xszExample = new CkXszExample();
        CkXszExample.Criteria xszExampleCriteria = xszExample.createCriteria();
        xszExampleCriteria.andCarIdEqualTo(carId);
        List<CkXsz> ckXszs = ckXszMapper.selectByExample(xszExample);
        if(ckXszs.size()==0)ckXszs.add(new CkXsz());
        object.put("xsz", ckXszs.get(0));
        //djz
        CkDjzExample djzExample = new CkDjzExample();
        CkDjzExample.Criteria djzExampleCriteria = djzExample.createCriteria();
        djzExampleCriteria.andCarIdEqualTo(carId);
        List<CkDjz> ckDjzs = ckDjzMapper.selectByExample(djzExample);
        if(ckDjzs.size()==0)ckDjzs.add(new CkDjz());
        object.put("djz", ckDjzs.get(0));
        //tqz
        CkQtzExample qtzExample = new CkQtzExample();
        CkQtzExample.Criteria qtzExampleCriteria = qtzExample.createCriteria();
        qtzExampleCriteria.andCarIdEqualTo(carId);
        List<CkQtz> ckQtzs = ckQtzMapper.selectByExample(qtzExample);
        if(ckQtzs.size()==0)ckQtzs.add(new CkQtz());
        object.put("qtz", ckQtzs.get(0));
        //czxx
        CkCzinfoExample ckCzinfoExample = new CkCzinfoExample();
        CkCzinfoExample.Criteria ckCzinfoExampleCriteria = ckCzinfoExample.createCriteria();
        ckCzinfoExampleCriteria.andCarIdEqualTo(carId);
        List<CkCzinfo> ckCzinfos = ckCzinfoMapper.selectByExample(ckCzinfoExample);
        if(ckCzinfos.size()==0)ckCzinfos.add(new CkCzinfo());
        object.put("czxx", ckCzinfos.get(0));

        return JsonResult.OK(object);
    }

    @Override
    public JsonResult saveCarBaseImg(CkBaseimg ckBaseimg) {
        if (ckBaseimg.getCarId() == null) return JsonResult.Error(OperateEnum.FAILE);
        if (ckBaseimg.getId() == -1) {
            ckBaseimg.setId(null);
            int i = ckBaseimgMapper.insertSelective(ckBaseimg);
            if (i > 0) {
                return JsonResult.OK(ckBaseimg.getId());
            }
        } else {
            int i = ckBaseimgMapper.updateByPrimaryKeySelective(ckBaseimg);
            if (i > 0) {
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult getCarBaseImg(long carId) {

        CkBaseimgExample example = new CkBaseimgExample();
        CkBaseimgExample.Criteria criteria = example.createCriteria();
        criteria.andCarIdEqualTo(carId);
        List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(example);
        if (ckBaseimgs.size() == 0) {
            CkBaseimg ckBaseimg = new CkBaseimg();
            ckBaseimg.setId(-1L);
            ckBaseimg.setCarId(carId);
            ckBaseimgs.add(ckBaseimg);
        }
        return JsonResult.OK(ckBaseimgs.get(0));
    }

    /**
     * 车辆删除
     * @param carId
     * @return
     */
    @Override
    @Transactional
    public JsonResult checkCarDel(long carId) {

        //ck_carbase
        int i = ckCarbaseMapper.deleteByPrimaryKey(carId);
        //ck_xsz
        CkXszExample xszExample = new CkXszExample();
        CkXszExample.Criteria xszCriteria = xszExample.createCriteria();
        xszCriteria.andCarIdEqualTo(carId);
        ckXszMapper.deleteByExample(xszExample);
        //ck_djz
        CkDjzExample djzExample = new CkDjzExample();
        CkDjzExample.Criteria djzExampleCriteria = djzExample.createCriteria();
        djzExampleCriteria.andCarIdEqualTo(carId);
        ckDjzMapper.deleteByExample(djzExample);
        //ck_qtz
        CkQtzExample qtzExample = new CkQtzExample();
        CkQtzExample.Criteria qtzExampleCriteria = qtzExample.createCriteria();
        qtzExampleCriteria.andCarIdEqualTo(carId);
        ckQtzMapper.deleteByExample(qtzExample);
        //ck_czinfo
        CkCzinfoExample czinfoExample = new CkCzinfoExample();
        CkCzinfoExample.Criteria czinfoExampleCriteria = czinfoExample.createCriteria();
        czinfoExampleCriteria.andCarIdEqualTo(carId);
        ckCzinfoMapper.deleteByExample(czinfoExample);
        //ck_baseimg
        CkBaseimgExample ckBaseimgExample = new CkBaseimgExample();
        CkBaseimgExample.Criteria ckBaseimgExampleCriteria = ckBaseimgExample.createCriteria();
        ckBaseimgExampleCriteria.andCarIdEqualTo(carId);
        ckBaseimgMapper.deleteByExample(ckBaseimgExample);

        if(i>0)return JsonResult.OK();
        return JsonResult.Error(OperateEnum.SERVER_ERROR);


    }

    /**
     * 保存车辆配置信息
     * @param ckPz
     * @return
     */
    @Override
    public JsonResult savePZ(CkPz ckPz) {
        if (ckPz.getCarId() == null) return JsonResult.Error(OperateEnum.FAILE);
        if (ckPz.getId() == -1) {
            ckPz.setId(null);
            int i = ckPzMapper.insertSelective(ckPz);
            if (i > 0) {
                return JsonResult.OK(ckPz.getId());
            }
        } else {
            int i = ckPzMapper.updateByPrimaryKeySelective(ckPz);
            if (i > 0) {
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);

    }

    /**
     * 保存或更新车辆的动力检测信息
     * @param ckDl
     * @return
     */
    @Override
    public JsonResult saveDL(CkDl ckDl) {
        if (ckDl.getCarId() == null) return JsonResult.Error(OperateEnum.FAILE);
        if (ckDl.getId() == -1) {
            ckDl.setId(null);
            int i = ckDlMapper.insertSelective(ckDl);
            if (i > 0) {
                return JsonResult.OK(ckDl.getId());
            }
        } else {
            int i = ckDlMapper.updateByPrimaryKeySelective(ckDl);
            if (i > 0) {
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    /**
     * 获取配置动力检测信息
     * @param carId
     * @return
     */
    @Override
    public JsonResult getCarStep4(long carId) {

        JSONObject jsonObject = new JSONObject();

        CkPzExample ckPzExample = new CkPzExample();
        CkPzExample.Criteria ckPzExampleCriteria = ckPzExample.createCriteria();
        ckPzExampleCriteria.andCarIdEqualTo(carId);
        List<CkPz> ckPzs = ckPzMapper.selectByExample(ckPzExample);
        if(ckPzs.size()==0)ckPzs.add(new CkPz());
        jsonObject.put("pz",ckPzs.get(0));

        CkDlExample ckDlExample = new CkDlExample();
        CkDlExample.Criteria ckDlExampleCriteria = ckDlExample.createCriteria();
        ckDlExampleCriteria.andCarIdEqualTo(carId);
        List<CkDl> ckDls = ckDlMapper.selectByExample(ckDlExample);
        if(ckDls.size()==0)ckDls.add(new CkDl());
        jsonObject.put("dl",ckDls.get(0));


        return JsonResult.OK(jsonObject);
    }

    /**
     * 外观缺陷保存
     * @param list
     * @param carId
     * @return
     */
    @Override
    @Transactional
    public JsonResult saveWgqx(List<CkCkwgqx> list, long carId) {

        //清楚当前车辆的所有外观缺陷
        CkCkwgqxExample example = new CkCkwgqxExample();
        CkCkwgqxExample.Criteria criteria = example.createCriteria();
        criteria.andCarIdEqualTo(carId);
        ckCkwgqxMapper.deleteByExample(example);
        for (CkCkwgqx ckCkwgqx : list) {
            ckCkwgqx.setCarId(carId);
            ckCkwgqx.setId(null);
            ckCkwgqxMapper.insertSelective(ckCkwgqx);
        }
        List<CkCkwgqx> ckCkwgqxes = ckCkwgqxMapper.selectByExample(example);
        return JsonResult.OK(ckCkwgqxes);
    }

    /**
     * 内饰缺陷保存
     * @param list
     * @param carId
     * @return
     */
    @Override
    @Transactional
    public JsonResult saveNsqx(List<CkCknsqx> list, long carId) {

        CkCknsqxExample example = new CkCknsqxExample();
        CkCknsqxExample.Criteria criteria = example.createCriteria();
        criteria.andCarIdEqualTo(carId);
        ckCknsqxMapper.deleteByExample(example);
        for (CkCknsqx ckCknsqx : list) {
            ckCknsqx.setCarId(carId);
            ckCknsqx.setId(null);
            ckCknsqxMapper.insertSelective(ckCknsqx);
        }

        List<CkCknsqx> ckCknsqxes = ckCknsqxMapper.selectByExample(example);
        return JsonResult.OK(ckCknsqxes);

    }

    /**
     * 保存事故信息
     * @param list
     * @param carId
     * @return
     */
    @Override
    @Transactional
    public JsonResult saveSg(List<CkCksg> list, long carId) {

        CkCksgExample example = new CkCksgExample();
        CkCksgExample.Criteria criteria = example.createCriteria();
        criteria.andCarIdEqualTo(carId);
        ckCksgMapper.deleteByExample(example);

        for (CkCksg ckCksg : list) {
            ckCksg.setCarId(carId);
            ckCksg.setId(null);
            ckCksgMapper.insertSelective(ckCksg);
        }
        List<CkCksg> ckCksgs = ckCksgMapper.selectByExample(example);
        return JsonResult.OK(ckCksgs);
    }

    /**
     * 保存泡水信息
     * @param list
     * @param carId
     * @return
     */
    @Override
    @Transactional
    public JsonResult savePs(List<CkCkps> list, long carId) {
        CkCkpsExample example = new CkCkpsExample();
        CkCkpsExample.Criteria criteria = example.createCriteria();
        criteria.andCarIdEqualTo(carId);
        ckCkpsMapper.deleteByExample(example);
        for (CkCkps ckCkps : list) {
            ckCkps.setCarId(carId);
            ckCkps.setId(null);
            ckCkpsMapper.insertSelective(ckCkps);
        }
        List<CkCkps> ckCkps = ckCkpsMapper.selectByExample(example);
        return JsonResult.OK(ckCkps);
    }

    /**
     * 保存火烧信息
     * @param list
     * @param carId
     * @return
     */
    @Override
    public JsonResult saveHs(List<CkCkhs> list, long carId) {

        CkCkhsExample example = new CkCkhsExample();
        CkCkhsExample.Criteria criteria = example.createCriteria();
        criteria.andCarIdEqualTo(carId);
        ckCkhsMapper.deleteByExample(example);
        for (CkCkhs ckCkhs : list) {
            ckCkhs.setCarId(carId);
            ckCkhs.setId(null);
            ckCkhsMapper.insertSelective(ckCkhs);
        }
        List<CkCkhs> ckCkhs = ckCkhsMapper.selectByExample(example);
        return JsonResult.OK(ckCkhs);

    }

    @Override
    public JsonResult getCarStep3(long carId) {
        JSONObject object = new JSONObject();
        //外观
        CkCkwgqxExample example1 = new CkCkwgqxExample();
        CkCkwgqxExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andCarIdEqualTo(carId);
        List<CkCkwgqx> ckCkwgqxes = ckCkwgqxMapper.selectByExample(example1);
        object.put("wgqx",ckCkwgqxes);
        //内饰
        CkCknsqxExample example2 = new CkCknsqxExample();
        CkCknsqxExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andCarIdEqualTo(carId);
        ckCknsqxMapper.selectByExample(example2);
        List<CkCknsqx> ckCknsqxes = ckCknsqxMapper.selectByExample(example2);
        object.put("nsqx",ckCknsqxes);
        //事故
        CkCksgExample example3 = new CkCksgExample();
        CkCksgExample.Criteria criteria3 = example3.createCriteria();
        criteria3.andCarIdEqualTo(carId);
        List<CkCksg> ckCksgs = ckCksgMapper.selectByExample(example3);
        object.put("sg",ckCksgs);
        //泡水
        CkCkpsExample example4 = new CkCkpsExample();
        CkCkpsExample.Criteria criteria4 = example4.createCriteria();
        criteria4.andCarIdEqualTo(carId);
        List<CkCkps> ckCkps = ckCkpsMapper.selectByExample(example4);
        object.put("ps",ckCkps);
        //火烧
        CkCkhsExample example5 = new CkCkhsExample();
        CkCkhsExample.Criteria criteria5 = example5.createCriteria();
        criteria5.andCarIdEqualTo(carId);
        List<CkCkhs> ckCkhs = ckCkhsMapper.selectByExample(example5);
        object.put("hs",ckCkhs);
        return JsonResult.OK(object);
    }

    @Override
    public JsonResult checkCarVerify(CkVerify verify) {
        if(verify.getCarId()==null)return JsonResult.Error(OperateEnum.FAILE);
        if (verify.getId() == -1) {
            verify.setId(null);
            int i = ckVerifyMapper.insertSelective(verify);
            if (i > 0) {
                //修改主表状态
                CkCarbase carbase = new CkCarbase();
                carbase.setId(verify.getCarId());
                carbase.setStatus(1);
                carbase.setStartPrice(verify.getStartPrice());
                ckCarbaseMapper.updateByPrimaryKeySelective(carbase);
                return JsonResult.OK(verify.getId());
            }
        } else {
            int i = ckVerifyMapper.updateByPrimaryKeySelective(verify);
            if (i > 0) {
                CkCarbase carbase = new CkCarbase();
                carbase.setId(verify.getCarId());
                carbase.setStartPrice(verify.getStartPrice());
                ckCarbaseMapper.updateByPrimaryKeySelective(carbase);
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);

    }

    @Override
    public JsonResult checkCarOther(CkOther other) {
        if(other.getCarId()==null)return JsonResult.Error(OperateEnum.FAILE);
        if(other.getId()==-1){
            other.setId(null);
            int i = ckOtherMapper.insertSelective(other);
            if(i>0){
                return JsonResult.OK(other.getId());
            }
        }else{
            int i = ckOtherMapper.updateByPrimaryKeySelective(other);
            if(i>0){
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult checkCarModel(CkCarmodel carmodel) {
        if(carmodel.getCarId()==null)return JsonResult.Error(OperateEnum.FAILE);
        if(carmodel.getId()==-1){
            carmodel.setId(null);
            int i = carmodelMapper.insertSelective(carmodel);
            if(i>0){
                if(StringUtils.isNotBlank(carmodel.getModelName())){
                    CkCarbase ckCarbase = new CkCarbase();
                    ckCarbase.setId(carmodel.getCarId());
                    ckCarbase.setModelId(carmodel.getModelId());
                    ckCarbase.setModelName(carmodel.getModelName());

                    ckCarbaseMapper.updateByPrimaryKeySelective(ckCarbase);
                }
                return JsonResult.OK(carmodel.getId());
            }
        }else{
            int i = carmodelMapper.updateByPrimaryKeySelective(carmodel);
            if(i>0){
                if(StringUtils.isNotBlank(carmodel.getModelName())){
                    CkCarbase ckCarbase = new CkCarbase();
                    ckCarbase.setId(carmodel.getCarId());
                    ckCarbase.setModelId(carmodel.getModelId());
                    ckCarbase.setModelName(carmodel.getModelName());
                    ckCarbaseMapper.updateByPrimaryKeySelective(ckCarbase);
                }
                return JsonResult.OK();
            }
        }
        return JsonResult.Error(OperateEnum.SERVER_ERROR);

    }

    @Override
    public JsonResult getCarStep5(long carId) {

        JSONObject jsonObject = new JSONObject();

        CkCarmodelExample carmodelExample = new CkCarmodelExample();
        CkCarmodelExample.Criteria carmodelExampleCriteria = carmodelExample.createCriteria();
        carmodelExampleCriteria.andCarIdEqualTo(carId);
        List<CkCarmodel> ckCarmodels = carmodelMapper.selectByExample(carmodelExample);
        if(ckCarmodels.size()==0)ckCarmodels.add(new CkCarmodel());
        jsonObject.put("model",ckCarmodels.get(0));

        CkVerifyExample verifyExample = new CkVerifyExample();
        CkVerifyExample.Criteria verifyExampleCriteria = verifyExample.createCriteria();
        verifyExampleCriteria.andCarIdEqualTo(carId);
        List<CkVerify> ckVerifies = ckVerifyMapper.selectByExample(verifyExample);
        if(ckVerifies.size()==0)ckVerifies.add(new CkVerify());
        jsonObject.put("verify",ckVerifies.get(0));

        CkOtherExample otherExample = new CkOtherExample();
        CkOtherExample.Criteria otherExampleCriteria = otherExample.createCriteria();
        otherExampleCriteria.andCarIdEqualTo(carId);
        List<CkOther> ckOthers = ckOtherMapper.selectByExample(otherExample);
        if(ckOthers.size()==0)ckOthers.add(new CkOther());
        jsonObject.put("other",ckOthers.get(0));


        //要核对的信息
        JSONObject objectHD = new JSONObject();
        //行驶证
        CkXszExample xszExample = new CkXszExample();
        CkXszExample.Criteria xszExampleCriteria = xszExample.createCriteria();
        xszExampleCriteria.andCarIdEqualTo(carId);
        List<CkXsz> ckXszs = ckXszMapper.selectByExample(xszExample);
        if(ckXszs.size()==0)ckXszs.add(new CkXsz());
        objectHD.put("number", ckXszs.get(0).getNumber());
        objectHD.put("pic1", ckXszs.get(0).getPic1());
        objectHD.put("cjh", ckXszs.get(0).getCjh());
        //djz
        CkDjzExample djzExample = new CkDjzExample();
        CkDjzExample.Criteria djzExampleCriteria = djzExample.createCriteria();
        djzExampleCriteria.andCarIdEqualTo(carId);
        List<CkDjz> ckDjzs = ckDjzMapper.selectByExample(djzExample);
        if(ckDjzs.size()==0)ckDjzs.add(new CkDjz());
        objectHD.put("ltgg", ckDjzs.get(0).getLtgg());
        objectHD.put("ccrq", ckDjzs.get(0).getCcrq());

        CkBaseimgExample ckBaseimgExample = new CkBaseimgExample();
        CkBaseimgExample.Criteria criteria = ckBaseimgExample.createCriteria();
        criteria.andCarIdEqualTo(carId);
        List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(ckBaseimgExample);
        if(ckBaseimgs.size()==0)ckBaseimgs.add(new CkBaseimg());
        objectHD.put("cphImg",ckBaseimgs.get(0).getCph());
        objectHD.put("zq45Img",ckBaseimgs.get(0).getZq45());
        objectHD.put("cjhImg",ckBaseimgs.get(0).getCjh());
        objectHD.put("fdcjhImg",ckBaseimgs.get(0).getFdcjh());
        objectHD.put("ybpImg",ckBaseimgs.get(0).getYbp());
        objectHD.put("mpImg",ckBaseimgs.get(0).getMp());
        objectHD.put("ltxhImg",ckBaseimgs.get(0).getLtxh());

        jsonObject.put("HD",objectHD);
        return JsonResult.OK(jsonObject);

    }

    /**
     * 提交审核
     * @param carId
     * @return
     */
    @Override
    public JsonResult checkCarExamine(long carId) {

        CkCarbase carbase = ckCarbaseMapper.selectByPrimaryKey(carId);
        if(carbase.getStatus()==1||carbase.getStatus()==9){
            carbase.setStatus(2);
            carbase.setCreateTime(new Date());
            int i = ckCarbaseMapper.updateByPrimaryKeySelective(carbase);
            if(i>0)return JsonResult.OK();
        }else{
            return JsonResult.Error("状态有误");
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取驳回原因
     * @param id
     * @return
     */
    @Override
    public JsonResult getRejectReason(long id) {


        CkCarbase ckCarbase = ckCarbaseMapper.selectByPrimaryKey(id);

        return JsonResult.OK(ckCarbase);

    }

    /**
     * 获取我的任务
     * @param token
     * @return
     */
    @Override
    public JsonResult getMyTask(String token) {

        CkUser ckUser = this.getUserByToken(token);

        PsSaleNeedExample example = new PsSaleNeedExample();
        example.createCriteria().andCheckUserEqualTo(ckUser.getId());
        List<PsSaleNeed> psSaleNeeds = psSaleNeedMapper.selectByExample(example);

        return JsonResult.OK(psSaleNeeds);
    }


    private CkUser getUserByToken(String token) {
        String redisUser = jedisClient.hget("CHECK_ACCOUNT_USER", token);
        CkUser ckUser = JsonUtils.jsonToPojo(redisUser, CkUser.class);
        return ckUser;
    }


}
