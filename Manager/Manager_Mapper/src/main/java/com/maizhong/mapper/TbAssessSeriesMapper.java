package com.maizhong.mapper;

import com.maizhong.pojo.TbAssessSeries;
import com.maizhong.pojo.TbAssessSeriesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAssessSeriesMapper {
    long countByExample(TbAssessSeriesExample example);

    int deleteByExample(TbAssessSeriesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAssessSeries record);

    int insertSelective(TbAssessSeries record);

    List<TbAssessSeries> selectByExample(TbAssessSeriesExample example);

    TbAssessSeries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAssessSeries record, @Param("example") TbAssessSeriesExample example);

    int updateByExample(@Param("record") TbAssessSeries record, @Param("example") TbAssessSeriesExample example);

    int updateByPrimaryKeySelective(TbAssessSeries record);

    int updateByPrimaryKey(TbAssessSeries record);
}