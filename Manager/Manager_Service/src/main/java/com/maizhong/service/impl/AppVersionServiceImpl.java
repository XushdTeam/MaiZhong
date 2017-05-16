package com.maizhong.service.impl;

import com.alibaba.druid.VERSION;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.service.AppHelpService;
import com.maizhong.service.AppVersionService;
import com.maizhong.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private TbBusinessMapper tbBusinessMapper;
    @Autowired
    private RichtextMapper richtextMapper;
    @Autowired
    private ProvinceMapper provinceMapper;


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
        String versionNumber = "V0.0.1";
        List<Version> versionList = versionMapper.selectByExample(null);
        if (versionList != null && versionList.size() > 0) {
            Version version = versionList.get(versionList.size() - 1);
            JSONObject object = new JSONObject();
            String app_version = version.getVersionNumber();
            int i = app_version.lastIndexOf(".");
            versionNumber = app_version.substring(0, i);
            object.put("versionNumber", versionNumber);
            object.put("versionDetail", app_version);
            jedisClient.set("APP_VERSION", JsonUtils.objectToJson(object));
        }
        getBusinessAddress(versionNumber);//更新店铺地址
        getBrand(versionNumber);//品牌信息
        getAgreement(versionNumber);//获取交易协议
        getprovince(versionNumber);//获取省份

        return OperateEnum.SUCCESS;
    }


    public void getBusinessAddress(String version) {
        //获取店铺地址
        List<District> districts = districtMapper.selectByExample(null);//区县 16
        long totalNumber = tbBusinessMapper.countByExample(null);
        TbBusinessExample example = new TbBusinessExample();
        JSONArray array = new JSONArray();
        for (District district : districts) {
            JSONObject object = new JSONObject();
            object.put("district", district.getName());
            object.put("id", district.getId());
            object.put("totalNumber", totalNumber);
            example.clear();
            TbBusinessExample.Criteria criteria = example.createCriteria();
            criteria.andDelflagEqualTo(0);
            criteria.andDistrictIdEqualTo(Long.valueOf(district.getId()));
            List<TbBusiness> tbBusinesses = tbBusinessMapper.selectByExample(example);
            if (tbBusinesses == null || tbBusinesses.size() == 0) {
                continue;
            } else {
                object.put("count", tbBusinesses.size());
            }
            JSONArray array1 = new JSONArray();
            for (TbBusiness tbBusiness : tbBusinesses) {
                JSONObject object1 = new JSONObject();
                object1.put("address", tbBusiness.getAddress());
                object1.put("img", tbBusiness.getLogo());
                object1.put("name", tbBusiness.getBusinessName());
                object1.put("id", tbBusiness.getId());
                object1.put("location", tbBusiness.getLocation());
                object1.put("districtId", tbBusiness.getDistrictId());
                array1.add(object1);
            }
            object.put("shop", array1);
            array.add(object);
        }
        fileUploadService.uploadFile(JsonUtils.objectToJson(array), "test/" + version + "/", "businessAddress.json");
        jedisClient.set("BUSINESS_ADDRESS", JsonUtils.objectToJson(array));
    }


    /**
     * 根据首字母获取品牌信息
     */
    public void getBrand(String version) {
        char[] str = new char[26];
        for (int i = 0; i < 26; i++) {
            str[i] = (char) (65 + i);
        }
        JSONArray array = new JSONArray();

        BrandExample example = new BrandExample();
        for (int i = 0; i < 26; i++) {
            example.clear();
            BrandExample.Criteria criteria = example.createCriteria();
            criteria.andInitialEqualTo(String.valueOf(str[i]));
            example.setOrderByClause("brand_id ASC");
            List<Brand> brands = brandMapper.selectByExample(example);
            if (brands == null || brands.size() == 0) {
                continue;
            }
            JSONObject object1 = new JSONObject();
            object1.put("id", 0);
            object1.put("name", "");
            object1.put("img", "");
            object1.put("initial", String.valueOf(str[i]));
            object1.put("isHot", 0);
            array.add(object1);
            for (Brand brand : brands) {
                JSONObject object = new JSONObject();
                object.put("id", brand.getBrandId());
                object.put("name", brand.getBrandName());
                object.put("img", brand.getLargeLogo());
                object.put("initial", brand.getInitial());
                object.put("isHot", brand.getIsHot());
                array.add(object);
            }
        }
        try {
            jedisClient.set("APP_BRAND", JsonUtils.objectToJson(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileUploadService.uploadFile(JsonUtils.objectToJson(array), "test/" + version + "/", "appBrand.json");
    }

    /**
     * 获取交易协议
     *
     * @param version
     */
    public void getAgreement(String version) {
        RichtextExample example = new RichtextExample();
        RichtextExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(1L);
        List<Richtext> richtexts = richtextMapper.selectByExampleWithBLOBs(example);
        String content = richtexts.get(richtexts.size() - 1).getContent();
        fileUploadService.uploadFile(content, "test/" + version + "/", "agreement.json");
    }


    public void getprovince(String version) {

        char[] str = new char[26];
        for (int i = 0; i < 26; i++) {
            str[i] = (char) (65 + i);
        }
        List<Province> provinceList = new ArrayList<>();

        ProvinceExample example = new ProvinceExample();
        for (int i = 0; i < 26; i++) {
            example.clear();
            ProvinceExample.Criteria criteria = example.createCriteria();
            criteria.andInitialEqualTo(String.valueOf(str[i]));
            example.setOrderByClause("prov_id ASC");
            List<Province> provinces = provinceMapper.selectByExample(example);
            if (provinces == null || provinces.size() == 0) {
                continue;
            }
            Province province1 = new Province();
            province1.setInitial(String.valueOf(str[i]));
            province1.setProvId(0);
            province1.setProvName(null);
            provinceList.add(province1);
            for (Province province : provinces) {
                provinceList.add(province);
            }
        }
        try {
            jedisClient.set("APP_PROVINCE", JsonUtils.objectToJson(provinceList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileUploadService.uploadFile(JsonUtils.objectToJson(provinceList),"rest/"+version+"/","province.json");

    }

}
