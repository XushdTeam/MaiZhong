package com.maizhong.mapper;

import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCarBrandMapper {
    long countByExample(TbCarBrandExample example);

    int deleteByExample(TbCarBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarBrand record);

    int insertSelective(TbCarBrand record);

    List<TbCarBrand> selectByExample(TbCarBrandExample example);

    TbCarBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarBrand record, @Param("example") TbCarBrandExample example);

    int updateByExample(@Param("record") TbCarBrand record, @Param("example") TbCarBrandExample example);

    int updateByPrimaryKeySelective(TbCarBrand record);

    int updateByPrimaryKey(TbCarBrand record);
}