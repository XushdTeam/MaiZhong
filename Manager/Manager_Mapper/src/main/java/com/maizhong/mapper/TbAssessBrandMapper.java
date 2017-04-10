package com.maizhong.mapper;

import com.maizhong.pojo.TbAssessBrand;
import com.maizhong.pojo.TbAssessBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAssessBrandMapper {
    long countByExample(TbAssessBrandExample example);

    int deleteByExample(TbAssessBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAssessBrand record);

    int insertSelective(TbAssessBrand record);

    List<TbAssessBrand> selectByExample(TbAssessBrandExample example);

    TbAssessBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAssessBrand record, @Param("example") TbAssessBrandExample example);

    int updateByExample(@Param("record") TbAssessBrand record, @Param("example") TbAssessBrandExample example);

    int updateByPrimaryKeySelective(TbAssessBrand record);

    int updateByPrimaryKey(TbAssessBrand record);
}