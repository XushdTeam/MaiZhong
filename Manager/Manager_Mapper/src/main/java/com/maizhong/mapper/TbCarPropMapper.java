package com.maizhong.mapper;

import com.maizhong.pojo.TbCarProp;
import com.maizhong.pojo.TbCarPropExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCarPropMapper {
    long countByExample(TbCarPropExample example);

    int deleteByExample(TbCarPropExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarProp record);

    int insertSelective(TbCarProp record);

    List<TbCarProp> selectByExample(TbCarPropExample example);

    TbCarProp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarProp record, @Param("example") TbCarPropExample example);

    int updateByExample(@Param("record") TbCarProp record, @Param("example") TbCarPropExample example);

    int updateByPrimaryKeySelective(TbCarProp record);

    int updateByPrimaryKey(TbCarProp record);
}