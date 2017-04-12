package com.maizhong.portal.service;

/**
 * Created by Xushd on 2017/3/21.
 */
public interface ActionService {
    void doPhoneLink(String phone,String type);

    void doPhoneLinkDetail(String phone, String type, String carId);
}
