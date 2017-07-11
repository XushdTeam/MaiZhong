package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.TpAuctionover;
import com.maizhong.auction.pojo.TpAuctionoverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpAuctionoverMapper {
    long countByExample(TpAuctionoverExample example);

    int deleteByExample(TpAuctionoverExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TpAuctionover record);

    int insertSelective(TpAuctionover record);

    List<TpAuctionover> selectByExample(TpAuctionoverExample example);

    TpAuctionover selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TpAuctionover record, @Param("example") TpAuctionoverExample example);

    int updateByExample(@Param("record") TpAuctionover record, @Param("example") TpAuctionoverExample example);

    int updateByPrimaryKeySelective(TpAuctionover record);

    int updateByPrimaryKey(TpAuctionover record);
}