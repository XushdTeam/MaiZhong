package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcSaleback;
import com.maizhong.auction.pojo.AcSalebackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcSalebackMapper {
    long countByExample(AcSalebackExample example);

    int deleteByExample(AcSalebackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcSaleback record);

    int insertSelective(AcSaleback record);

    List<AcSaleback> selectByExample(AcSalebackExample example);

    AcSaleback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcSaleback record, @Param("example") AcSalebackExample example);

    int updateByExample(@Param("record") AcSaleback record, @Param("example") AcSalebackExample example);

    int updateByPrimaryKeySelective(AcSaleback record);

    int updateByPrimaryKey(AcSaleback record);
}