package com.maizhong.mapper;

import com.maizhong.pojo.Help;
import com.maizhong.pojo.HelpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HelpMapper {
    long countByExample(HelpExample example);

    int deleteByExample(HelpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Help record);

    int insertSelective(Help record);

    List<Help> selectByExampleWithBLOBs(HelpExample example);

    List<Help> selectByExample(HelpExample example);

    Help selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Help record, @Param("example") HelpExample example);

    int updateByExampleWithBLOBs(@Param("record") Help record, @Param("example") HelpExample example);

    int updateByExample(@Param("record") Help record, @Param("example") HelpExample example);

    int updateByPrimaryKeySelective(Help record);

    int updateByPrimaryKeyWithBLOBs(Help record);

    int updateByPrimaryKey(Help record);
}