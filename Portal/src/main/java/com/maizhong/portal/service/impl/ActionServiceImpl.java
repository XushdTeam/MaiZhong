package com.maizhong.portal.service.impl;

import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.portal.service.ActionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xushd on 2017/3/21.
 */
@Service
public class ActionServiceImpl implements ActionService {

    @Value("${REST_URL}")
    private String REST_URL;

    @Value("${PHONE_LINK}")
    private String PHONE_LINK;

    @Value("${PHONE_LINK_CAR}")
    private String PHONE_LINK_CAR;


    @Override
    public void doPhoneLink(String phone,String type) {
        Map<String,String> param = new HashMap<>();
        param.put("phone",phone);
        param.put("type",type);
        HttpClientUtil.doPost(REST_URL+PHONE_LINK,param);
    }

    @Override
    public void doPhoneLinkDetail(String phone, String type, String carId) {
        Map<String,String> param = new HashMap<>();
        param.put("phone",phone);
        param.put("type",type);
        param.put("carId",carId);
        HttpClientUtil.doPost(REST_URL+PHONE_LINK_CAR,param);
    }
}
