package com.maizhong.mapper;

import com.maizhong.pojo.Province;
import com.maizhong.pojo.ProvinceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvinceMapper {
    long countByExample(ProvinceExample example);

    int deleteByExample(ProvinceExample example);

    int deleteByPrimaryKey(Integer provId);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(Integer provId);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}