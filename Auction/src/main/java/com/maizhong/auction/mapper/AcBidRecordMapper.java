package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcBidRecord;
import com.maizhong.auction.pojo.AcBidRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcBidRecordMapper {
    long countByExample(AcBidRecordExample example);

    int deleteByExample(AcBidRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcBidRecord record);

    int insertSelective(AcBidRecord record);

    List<AcBidRecord> selectByExample(AcBidRecordExample example);

    AcBidRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcBidRecord record, @Param("example") AcBidRecordExample example);

    int updateByExample(@Param("record") AcBidRecord record, @Param("example") AcBidRecordExample example);

    int updateByPrimaryKeySelective(AcBidRecord record);

    int updateByPrimaryKey(AcBidRecord record);

    List<AcBidRecord> selectByExampleWithGroupBy(AcBidRecordExample example);

    List<AcBidRecord> selectRecord(Long userId);
}