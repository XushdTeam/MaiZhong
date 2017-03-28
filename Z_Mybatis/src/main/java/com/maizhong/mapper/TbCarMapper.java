package com.maizhong.mapper;

import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}