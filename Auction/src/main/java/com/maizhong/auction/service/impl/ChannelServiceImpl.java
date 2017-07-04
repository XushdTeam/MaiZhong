package com.maizhong.auction.service.impl;

import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Xushd on 2017/6/10.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private JedisClient jedisClient;
    @Override
    public void createChannel(String ch) {

    }

    @Override
    public String getMessage(String ch) {

        String channel = jedisClient.hget("CHANNEL", ch);

        return channel;
    }
}
