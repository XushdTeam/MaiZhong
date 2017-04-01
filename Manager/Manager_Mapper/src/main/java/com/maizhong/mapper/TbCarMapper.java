package com.maizhong.mapper;

import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TbCarMapper {
    long countByExample(TbCarExample example);

    int deleteByExample(TbCarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCar record);

    int insertSelective(TbCar record);

    List<TbCar> selectByExampleWithBLOBs(TbCarExample example);

    List<TbCar> selectByExample(TbCarExample example);

    TbCar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCar record, @Param("example") TbCarExample example);

    int updateByExampleWithBLOBs(@Param("record") TbCar record, @Param("example") TbCarExample example);

    int updateByExample(@Param("record") TbCar record, @Param("example") TbCarExample example);

    int updateByPrimaryKeySelective(TbCar record);

    int updateByPrimaryKeyWithBLOBs(TbCar record);

    int updateByPrimaryKey(TbCar record);
    long totalCarNumber(@Param("businessId") Long businessId);
    long totalBrandNumber(@Param("businessId") Long businessId);
    long totalSeriesNumber(@Param("businessId") Long businessId);
    long shopCarNumber(@Param("businessId") Long businessId);
    long shopBrandNumber(@Param("businessId") Long businessId);
    long shopSeriesNumber(@Param("businessId") Long businessId);
    long weekNumber(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("businessId") Long businessId);
}