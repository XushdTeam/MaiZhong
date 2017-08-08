package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcBzjRecord;
import com.maizhong.auction.pojo.AcBzjRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcBzjRecordMapper {
    long countByExample(AcBzjRecordExample example);

    int deleteByExample(AcBzjRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcBzjRecord record);

    int insertSelective(AcBzjRecord record);

    List<AcBzjRecord> selectByExample(AcBzjRecordExample example);

    AcBzjRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcBzjRecord record, @Param("example") AcBzjRecordExample example);

    int updateByExample(@Param("record") AcBzjRecord record, @Param("example") AcBzjRecordExample example);

    int updateByPrimaryKeySelective(AcBzjRecord record);

    int updateByPrimaryKey(AcBzjRecord record);
}