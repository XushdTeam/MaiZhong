package com.tools.mapper;

import com.tools.pojo.CarBrand;
import com.tools.pojo.CarBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarBrandMapper {
    long countByExample(CarBrandExample example);

    int deleteByExample(CarBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarBrand record);

    int insertSelective(CarBrand record);

    List<CarBrand> selectByExample(CarBrandExample example);

    CarBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarBrand record, @Param("example") CarBrandExample example);

    int updateByExample(@Param("record") CarBrand record, @Param("example") CarBrandExample example);

    int updateByPrimaryKeySelective(CarBrand record);

    int updateByPrimaryKey(CarBrand record);
}