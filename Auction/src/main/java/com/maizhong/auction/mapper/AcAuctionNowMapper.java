package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcAuctionNow;
import com.maizhong.auction.pojo.AcAuctionNowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcAuctionNowMapper {
    long countByExample(AcAuctionNowExample example);

    int deleteByExample(AcAuctionNowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcAuctionNow record);

    int insertSelective(AcAuctionNow record);

    List<AcAuctionNow> selectByExample(AcAuctionNowExample example);

    AcAuctionNow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcAuctionNow record, @Param("example") AcAuctionNowExample example);

    int updateByExample(@Param("record") AcAuctionNow record, @Param("example") AcAuctionNowExample example);

    int updateByPrimaryKeySelective(AcAuctionNow record);

    int updateByPrimaryKey(AcAuctionNow record);
}