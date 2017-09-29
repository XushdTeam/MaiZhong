package com.tools.mapper;

import com.tools.pojo.CarFactory;
import com.tools.pojo.CarFactoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarFactoryMapper {
    long countByExample(CarFactoryExample example);

    int deleteByExample(CarFactoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarFactory record);

    int insertSelective(CarFactory record);

    List<CarFactory> selectByExample(CarFactoryExample example);

    CarFactory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarFactory record, @Param("example") CarFactoryExample example);

    int updateByExample(@Param("record") CarFactory record, @Param("example") CarFactoryExample example);

    int updateByPrimaryKeySelective(CarFactory record);

    int updateByPrimaryKey(CarFactory record);
}