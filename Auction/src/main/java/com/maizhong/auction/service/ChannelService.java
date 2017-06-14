package com.maizhong.auction.service;

import com.maizhong.auction.dto.RedisMessage;

/**
 * Created by Xushd on 2017/6/10.
 */
public interface ChannelService {
    void createChannel(String ch);

    String getMessage(String ch);
}
