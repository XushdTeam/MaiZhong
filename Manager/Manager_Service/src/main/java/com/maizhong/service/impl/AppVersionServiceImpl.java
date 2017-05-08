package com.maizhong.service.impl;

import com.alibaba.druid.VERSION;
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
import com.maizhong.mapper.VersionMapper;
import com.maizhong.pojo.Help;
import com.maizhong.pojo.HelpExample;
import com.maizhong.pojo.Version;
import com.maizhong.pojo.VersionExample;
import com.maizhong.service.AppHelpService;
import com.maizhong.service.AppVersionService;
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
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private VersionMapper versionMapper;
    @Autowired
    private JedisClient jedisClient;

    /**
     * 获取版本号列表
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getVersionList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        List<Version> versionList = versionMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(versionList);
        return new PageResult(pageInfo);
    }

    /**
     * 根据Id获取版本号
     *
     * @param aLong
     * @return
     */
    @Override
    public Version getVersionById(Long aLong) {
        Version version = versionMapper.selectByPrimaryKey(aLong);
        return version;
    }

    /**
     * 添加版本号
     *
     * @param version
     * @return
     */
    @Override
    public OperateEnum insertVersion(Version version) {
        version.setUpdateTime(new Date());
        int res = versionMapper.insert(version);
        if (res > 0) {
            try {
                updateVersionRedis();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 版本号删除
     *
     * @param id
     * @return
     */
    @Override
    public OperateEnum deleteVersionById(long id) {
        try {
            versionMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OperateEnum.SUCCESS;
    }

    /**
     * 版本号更新
     *
     * @param version
     * @return
     */
    @Override
    public OperateEnum updateVersion(Version version) {
       versionMapper.updateByPrimaryKeySelective(version);
        try {
            updateVersionRedis();
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
    public OperateEnum updateVersionRedis() {
        try {
            jedisClient.del("APP_VERSION");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Version> versionList = versionMapper.selectByExample(null);
        if (versionList!=null&&versionList.size()>0){
            Version version = versionList.get(versionList.size() - 1);
            jedisClient.set("APP_VERSION",JsonUtils.objectToJson(version));
        }
        return OperateEnum.SUCCESS;
    }
}
