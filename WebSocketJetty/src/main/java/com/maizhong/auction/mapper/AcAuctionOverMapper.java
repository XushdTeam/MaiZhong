package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcAuctionOver;
import com.maizhong.auction.pojo.AcAuctionOverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcAuctionOverMapper {
    long countByExample(AcAuctionOverExample example);

    int deleteByExample(AcAuctionOverExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcAuctionOver record);

    int insertSelective(AcAuctionOver record);

    List<AcAuctionOver> selectByExample(AcAuctionOverExample example);

    AcAuctionOver selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcAuctionOver record, @Param("example") AcAuctionOverExample example);

    int updateByExample(@Param("record") AcAuctionOver record, @Param("example") AcAuctionOverExample example);

    int updateByPrimaryKeySelective(AcAuctionOver record);

    int updateByPrimaryKey(AcAuctionOver record);
}