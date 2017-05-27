package com.maizhong.mapper;

import com.maizhong.pojo.Rate;
import com.maizhong.pojo.RateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RateMapper {
    long countByExample(RateExample example);

    int deleteByExample(RateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rate record);

    int insertSelective(Rate record);

    List<Rate> selectByExample(RateExample example);

    Rate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Rate record, @Param("example") RateExample example);

    int updateByExample(@Param("record") Rate record, @Param("example") RateExample example);

    int updateByPrimaryKeySelective(Rate record);

    int updateByPrimaryKey(Rate record);
}