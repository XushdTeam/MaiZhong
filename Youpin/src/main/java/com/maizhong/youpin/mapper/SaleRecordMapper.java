package com.maizhong.youpin.mapper;

import com.maizhong.youpin.pojo.SaleRecord;
import com.maizhong.youpin.pojo.SaleRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleRecordMapper {
    long countByExample(SaleRecordExample example);

    int deleteByExample(SaleRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SaleRecord record);

    int insertSelective(SaleRecord record);

    List<SaleRecord> selectByExample(SaleRecordExample example);

    SaleRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SaleRecord record, @Param("example") SaleRecordExample example);

    int updateByExample(@Param("record") SaleRecord record, @Param("example") SaleRecordExample example);

    int updateByPrimaryKeySelective(SaleRecord record);

    int updateByPrimaryKey(SaleRecord record);
}