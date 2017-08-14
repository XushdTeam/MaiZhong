package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcFreeze;
import com.maizhong.auction.pojo.AcFreezeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcFreezeMapper {
    long countByExample(AcFreezeExample example);

    int deleteByExample(AcFreezeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcFreeze record);

    int insertSelective(AcFreeze record);

    List<AcFreeze> selectByExample(AcFreezeExample example);

    AcFreeze selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcFreeze record, @Param("example") AcFreezeExample example);

    int updateByExample(@Param("record") AcFreeze record, @Param("example") AcFreezeExample example);

    int updateByPrimaryKeySelective(AcFreeze record);

    int updateByPrimaryKey(AcFreeze record);
}