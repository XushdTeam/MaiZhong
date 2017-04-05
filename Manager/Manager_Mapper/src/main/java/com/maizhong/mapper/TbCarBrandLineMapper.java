package com.maizhong.mapper;

import com.maizhong.pojo.TbCarBrandLine;
import com.maizhong.pojo.TbCarBrandLineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCarBrandLineMapper {
    long countByExample(TbCarBrandLineExample example);

    int deleteByExample(TbCarBrandLineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarBrandLine record);

    int insertSelective(TbCarBrandLine record);

    List<TbCarBrandLine> selectByExample(TbCarBrandLineExample example);

    TbCarBrandLine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarBrandLine record, @Param("example") TbCarBrandLineExample example);

    int updateByExample(@Param("record") TbCarBrandLine record, @Param("example") TbCarBrandLineExample example);

    int updateByPrimaryKeySelective(TbCarBrandLine record);

    int updateByPrimaryKey(TbCarBrandLine record);

   /*List<String> getSeriesByFactory(@Param("factoryName") String factoyName,@Param("brandName") String brandName);*/
}