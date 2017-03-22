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

    @Override
    public void doPhoneLink(String phone) {
        Map<String,String> param = new HashMap<>();
        param.put("phone",phone);
        HttpClientUtil.doPost(REST_URL+PHONE_LINK,param);
    }
}
