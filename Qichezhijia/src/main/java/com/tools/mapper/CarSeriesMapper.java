package com.tools.mapper;

import com.tools.pojo.CarSeries;
import com.tools.pojo.CarSeriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarSeriesMapper {
    long countByExample(CarSeriesExample example);

    int deleteByExample(CarSeriesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarSeries record);

    int insertSelective(CarSeries record);

    List<CarSeries> selectByExample(CarSeriesExample example);

    CarSeries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarSeries record, @Param("example") CarSeriesExample example);

    int updateByExample(@Param("record") CarSeries record, @Param("example") CarSeriesExample example);

    int updateByPrimaryKeySelective(CarSeries record);

    int updateByPrimaryKey(CarSeries record);
}