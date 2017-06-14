package com.maizhong.auction.service.impl;

import com.maizhong.auction.dto.PriceDto;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.auction.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Xushd on 2017/6/12.
 */
@Service
public class AuctionServiceImpl implements AuctionService {


    @Autowired
    private JedisClient jedisClient;

    @Override
    public synchronized boolean auction(PriceDto priceDto) {

        String redisPrice = jedisClient.hget("CHANNEL","CH1");
        PriceDto priceDto1 = JsonUtils.jsonToPojo(redisPrice, PriceDto.class);
        if(priceDto.getNowPrice()>priceDto1.getNowPrice()){
            jedisClient.hset("CHANNEL","CH1",JsonUtils.objectToJson(priceDto));
            return true;
        }

        return false;
    }

    @Override
    public synchronized JsonResult addprice(String ch, Long price) {
        String redisPrice = jedisClient.hget("CHANNEL",ch);
        PriceDto priceDto = JsonUtils.jsonToPojo(redisPrice, PriceDto.class);
        if(price>priceDto.getNowPrice()){
            priceDto.setNowPrice(price);
            priceDto.setUpdateTime(new Date());
            priceDto.setThreadNum("1");
            jedisClient.hset("CHANNEL",ch,JsonUtils.objectToJson(priceDto));
            return JsonResult.OK();

        }else{

            return JsonResult.Error("当前价格已超过你的出价");
        }

    }
}
