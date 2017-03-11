package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.mapper.RestInterfaceMapper;
import com.maizhong.pojo.RestInterface;
import com.maizhong.pojo.RestInterfaceExample;
import com.maizhong.rest.service.IndexService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xushd on 2017/3/3.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Value("${ACCOUNT}")
    private String ACCOUNT;

    @Value("${PASSWORD}")
    private String PASSWORD;

    @Value("${ADVERT}")
    private String ADVERT;

    @Autowired
    private RestInterfaceMapper interfaceMapper;

    @Override
    public JsonResult login(String username, String password) {
        if(!StringUtils.equals(ACCOUNT,username)){
            return JsonResult.build(AuthEnum.USER_NO_EXIT);
        }else if(!StringUtils.equals(PASSWORD,password)){
            return JsonResult.build(AuthEnum.USER_ERROR_PASSWORD);
        }else{
            Map<String,Object> user = new HashMap();
            user.put("username",ACCOUNT);
            user.put("password",PASSWORD);
            user.put("advert",ADVERT);
            return JsonResult.OK(user);
        }
    }

    @Override
    public JsonResult getBaseInfo() {
        Map<String,Object> baseInfo = new HashMap<>();
        baseInfo.put("interfaceCount",0);
        baseInfo.put("version","1.0.0");
        return JsonResult.OK(baseInfo);
    }

    @Override
    public JsonResult getInterfaceList(PageSearchParam pageSearchParam) {

        PageHelper.startPage(pageSearchParam.getPageIndex(), pageSearchParam.getPageSize());
        RestInterfaceExample example = new RestInterfaceExample();
        RestInterfaceExample.Criteria criteria = example.createCriteria();
        if(pageSearchParam.getFiled("interfaceName")!= null){
            criteria.andInterfaceNameLike(SqlUtils.getLikeSql(pageSearchParam.getFiled("interfaceName")));
        }
        if(pageSearchParam.getFiled("interfaceUrl")!= null){
            criteria.andInterfaceUrlEqualTo(pageSearchParam.getFiled("interfaceUrl"));
        }
        List<RestInterface> list = interfaceMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        PageResult result = new PageResult(pageInfo);
        return JsonResult.OK(result);
    }
}
