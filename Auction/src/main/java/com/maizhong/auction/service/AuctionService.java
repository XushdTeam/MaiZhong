package com.maizhong.auction.service;

import com.maizhong.auction.dto.PriceDto;
import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/6/12.
 */
public interface AuctionService {
    boolean auction(PriceDto priceDto);

    JsonResult addprice(String ch, Long price);
}
