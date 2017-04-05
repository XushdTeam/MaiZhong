package com.maizhong.mapper;

import com.maizhong.pojo.TbCarFactory;
import com.maizhong.pojo.TbCarFactoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCarFactoryMapper {
    long countByExample(TbCarFactoryExample example);

    int deleteByExample(TbCarFactoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarFactory record);

    int insertSelective(TbCarFactory record);

    List<TbCarFactory> selectByExample(TbCarFactoryExample example);

    TbCarFactory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarFactory record, @Param("example") TbCarFactoryExample example);

    int updateByExample(@Param("record") TbCarFactory record, @Param("example") TbCarFactoryExample example);

    int updateByPrimaryKeySelective(TbCarFactory record);

    int updateByPrimaryKey(TbCarFactory record);

   /* List<String> getFactoryByBrand(@Param("brandName") String brandName);*/
}