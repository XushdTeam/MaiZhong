package com.maizhong.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.HelpMapper;
import com.maizhong.pojo.Help;
import com.maizhong.pojo.HelpExample;
import com.maizhong.pojo.TbCarType;
import com.maizhong.service.AppHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-05-03
 * Time: 13:37
 */
@Service
public class AppHelpServiceImpl implements AppHelpService {

    @Autowired
    private HelpMapper helpMapper;
    @Value("${APP_HELP_TITLE}")
    private String APP_HELP_TITLE;
    @Value("${APP_HELP_CONTENT}")
    private String APP_HELP_CONTENT;
    @Autowired
    private JedisClient jedisClient;

    /**
     * 获取帮助列表
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getHelpList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        HelpExample example = new HelpExample();
        HelpExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        if (param.getFiled("title") != null) {
            criteria.andTitleLike(SqlUtils.getLikeSql(param.getFiled("title")));
        }
        example.setOrderByClause("id ASC");
        List<Help> helps = helpMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(helps);
        return new PageResult(pageInfo);
    }

    /**
     * 根据Id获取帮助对象
     *
     * @param aLong
     * @return
     */
    @Override
    public Help getHelpById(Long aLong) {
        Help help = helpMapper.selectByPrimaryKey(aLong);
        return help;
    }

    /**
     * 添加帮助
     *
     * @param help
     * @return
     */
    @Override
    public OperateEnum insertHelp(Help help) {
        help.setTime(new Date());
        help.setStatus(1);
        help.setDelflag(0);
        int res = helpMapper.insert(help);
        if (res > 0) {
            try {
                updateHelpRedis();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 帮助删除
     *
     * @param id
     * @return
     */
    @Override
    public OperateEnum deleteHelpById(long id) {
        Help help = helpMapper.selectByPrimaryKey(id);
        if (help == null) {
            return OperateEnum.FAILE;
        }
        help.setDelflag(1);
        help.setTime(new Date());
        int res = helpMapper.updateByPrimaryKeySelective(help);
        if (res > 0) {
            try {
                updateHelpRedis();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 帮助更新
     *
     * @param help
     * @return
     */
    @Override
    public OperateEnum updateHelp(Help help) {
       helpMapper.updateByPrimaryKeySelective(help);
        try {
            updateHelpRedis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OperateEnum.SUCCESS;
    }

    /**
     * 缓存更新
     *
     * @return
     */
    @Override
    public OperateEnum updateHelpRedis() {
        try {
            jedisClient.del(APP_HELP_TITLE);
            jedisClient.del(APP_HELP_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            HelpExample example=new HelpExample();
            HelpExample.Criteria criteria = example.createCriteria();
            criteria.andDelflagEqualTo(0);
            criteria.andStatusEqualTo(1);
            List<Help> helps = helpMapper.selectByExample(example);
            JSONArray array=new JSONArray();

            //存入标题
            for (Help help:helps){
                JSONObject object=new JSONObject();
                object.put("id",help.getId());
                object.put("title",help.getTitle());
                array.add(object);
            }
            //存入内容和标题
            for (Help help:helps){
                JSONObject object=new JSONObject();
                object.put("id",help.getId());
                object.put("title",help.getTitle());
                object.put("content",help.getContent());
                jedisClient.hset(APP_HELP_CONTENT, help.getId()+"",JsonUtils.objectToJson(object));
            }
            jedisClient.set(APP_HELP_TITLE, JsonUtils.objectToJson(array));
        } catch (Exception e) {
            e.printStackTrace();
            return OperateEnum.FAILE;
        }
        return OperateEnum.SUCCESS;
    }
}
