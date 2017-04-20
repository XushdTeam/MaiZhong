package com.maizhong.mapper;

import com.maizhong.pojo.Params;
import com.maizhong.pojo.ParamsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParamsMapper {
    long countByExample(ParamsExample example);

    int deleteByExample(ParamsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Params record);

    int insertSelective(Params record);

    List<Params> selectByExample(ParamsExample example);

    Params selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Params record, @Param("example") ParamsExample example);

    int updateByExample(@Param("record") Params record, @Param("example") ParamsExample example);

    int updateByPrimaryKeySelective(Params record);

    int updateByPrimaryKey(Params record);
}