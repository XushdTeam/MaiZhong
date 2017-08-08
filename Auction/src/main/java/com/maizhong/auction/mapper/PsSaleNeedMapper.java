package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.PsSaleNeed;
import com.maizhong.auction.pojo.PsSaleNeedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsSaleNeedMapper {
    long countByExample(PsSaleNeedExample example);

    int deleteByExample(PsSaleNeedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PsSaleNeed record);

    int insertSelective(PsSaleNeed record);

    List<PsSaleNeed> selectByExample(PsSaleNeedExample example);

    PsSaleNeed selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PsSaleNeed record, @Param("example") PsSaleNeedExample example);

    int updateByExample(@Param("record") PsSaleNeed record, @Param("example") PsSaleNeedExample example);

    int updateByPrimaryKeySelective(PsSaleNeed record);

    int updateByPrimaryKey(PsSaleNeed record);
}