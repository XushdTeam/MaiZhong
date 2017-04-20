package com.maizhong.mapper;

import com.maizhong.pojo.Line;
import com.maizhong.pojo.LineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LineMapper {
    long countByExample(LineExample example);

    int deleteByExample(LineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Line record);

    int insertSelective(Line record);

    List<Line> selectByExample(LineExample example);

    Line selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Line record, @Param("example") LineExample example);

    int updateByExample(@Param("record") Line record, @Param("example") LineExample example);

    int updateByPrimaryKeySelective(Line record);

    int updateByPrimaryKey(Line record);
}