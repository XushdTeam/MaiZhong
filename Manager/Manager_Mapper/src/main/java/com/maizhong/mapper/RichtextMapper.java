package com.maizhong.mapper;

import com.maizhong.pojo.Richtext;
import com.maizhong.pojo.RichtextExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RichtextMapper {
    long countByExample(RichtextExample example);

    int deleteByExample(RichtextExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Richtext record);

    int insertSelective(Richtext record);

    List<Richtext> selectByExampleWithBLOBs(RichtextExample example);

    List<Richtext> selectByExample(RichtextExample example);

    Richtext selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Richtext record, @Param("example") RichtextExample example);

    int updateByExampleWithBLOBs(@Param("record") Richtext record, @Param("example") RichtextExample example);

    int updateByExample(@Param("record") Richtext record, @Param("example") RichtextExample example);

    int updateByPrimaryKeySelective(Richtext record);

    int updateByPrimaryKeyWithBLOBs(Richtext record);

    int updateByPrimaryKey(Richtext record);
}