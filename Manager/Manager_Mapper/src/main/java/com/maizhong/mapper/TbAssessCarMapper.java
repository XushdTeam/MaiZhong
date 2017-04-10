package com.maizhong.mapper;

import com.maizhong.pojo.TbAssessCar;
import com.maizhong.pojo.TbAssessCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAssessCarMapper {
    long countByExample(TbAssessCarExample example);

    int deleteByExample(TbAssessCarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAssessCar record);

    int insertSelective(TbAssessCar record);

    List<TbAssessCar> selectByExample(TbAssessCarExample example);

    TbAssessCar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAssessCar record, @Param("example") TbAssessCarExample example);

    int updateByExample(@Param("record") TbAssessCar record, @Param("example") TbAssessCarExample example);

    int updateByPrimaryKeySelective(TbAssessCar record);

    int updateByPrimaryKey(TbAssessCar record);
}