package com.maizhong.auction.service.impl;

import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.AuctionHistoryDTO;
import com.maizhong.auction.dto.CarAcutionDTO;
import com.maizhong.auction.mapper.TpHistoryMapper;
import com.maizhong.auction.mapper.TpNowMapper;
import com.maizhong.auction.pojo.TpHistory;
import com.maizhong.auction.pojo.TpNow;
import com.maizhong.auction.pojo.TpNowExample;
import com.maizhong.auction.service.AcutionService;
import com.maizhong.auction.service.ChannelService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xushd on 2017/6/28.
 */
@Service
public class AcutionServiceImpl implements AcutionService {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private TpNowMapper tpNowMapper;

    @Autowired
    private TpHistoryMapper tpHistoryMapper;

    @Autowired
    private ChannelService channelService;

    @Override
    public JsonResult getCarNow() {

        TpNowExample example = new TpNowExample();
        example.setOrderByClause("over_time desc");
        List<TpNow> tpNows = tpNowMapper.selectByExample(example);
        List<CarAcutionDTO> list = new ArrayList<>();
        for (TpNow tpNow : tpNows) {
            String ch = tpNow.getCh();
            String redieCH = jedisClient.get("CHANNEL:" + ch);
            if((StringUtils.isNotBlank(redieCH)&&!StringUtils.equals("over",redieCH))){
                CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(redieCH, CarAcutionDTO.class);
                carAcutionDTO.setChannel(ch);
                list.add(carAcutionDTO);
            }
        }
        return JsonResult.build(200, TimeUtils.getCurrentTime()+"",list);
    }

    @Override
    public synchronized JsonResult addPrice(String ch, long carId, long plus, long price) {

        String redieCH = jedisClient.get("CHANNEL:" + ch);
        if((StringUtils.isNotBlank(redieCH)&&!StringUtils.equals("over",redieCH))){
            CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(redieCH, CarAcutionDTO.class);
            if(TimeUtils.compare(carAcutionDTO.getOverTime())){
                //
                if(Long.valueOf(carAcutionDTO.getNowPrice())>=(price+plus)){
                    return JsonResult.Error("出价过低");
                }else{
                    carAcutionDTO.setNowPrice(price+plus+"");
                    jedisClient.set("CHANNEL:" + ch,JsonUtils.objectToJson(carAcutionDTO));

                    AuctionHistoryDTO historyDTO = new AuctionHistoryDTO();
                    historyDTO.setCarId(carAcutionDTO.getCarId());
                    historyDTO.setPrice(price+plus+"");
                    historyDTO.setPuls((int) plus);
                    historyDTO.setAuctionDate(new Date());
                    historyDTO.setUserId(1);
                    historyDTO.setBussinessName("北京车商");
                    historyDTO.setCh(ch);
                    channelService.addSocketQueue(historyDTO);

                    return JsonResult.OK();
                }


            }else {
                return JsonResult.Error("拍卖结束");
            }

        }else{
            return JsonResult.Error("拍卖结束");
        }

    }


}
