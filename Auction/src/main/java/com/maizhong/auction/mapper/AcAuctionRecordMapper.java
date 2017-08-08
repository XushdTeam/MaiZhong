package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcAuctionRecord;
import com.maizhong.auction.pojo.AcAuctionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcAuctionRecordMapper {
    long countByExample(AcAuctionRecordExample example);

    int deleteByExample(AcAuctionRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcAuctionRecord record);

    int insertSelective(AcAuctionRecord record);

    List<AcAuctionRecord> selectByExample(AcAuctionRecordExample example);

    AcAuctionRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcAuctionRecord record, @Param("example") AcAuctionRecordExample example);

    int updateByExample(@Param("record") AcAuctionRecord record, @Param("example") AcAuctionRecordExample example);

    int updateByPrimaryKeySelective(AcAuctionRecord record);

    int updateByPrimaryKey(AcAuctionRecord record);
}