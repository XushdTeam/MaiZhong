package com.maizhong.auction.service.impl;

import com.maizhong.auction.dto.PriceDto;
import com.maizhong.auction.service.ChannelService;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.auction.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Xushd on 2017/6/10.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private JedisClient jedisClient;
    @Override
    public void createChannel(String ch) {

        PriceDto priceDto = new PriceDto(1000L,"system",new Date());

        jedisClient.hset("CHANNEL", ch, JsonUtils.objectToJson(priceDto));
    }

    @Override
    public String getMessage(String ch) {

        String channel = jedisClient.hget("CHANNEL", ch);

        return channel;
    }
}
