package com.maizhong.mapper;

import com.maizhong.pojo.JoinUs;
import com.maizhong.pojo.JoinUsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoinUsMapper {
    long countByExample(JoinUsExample example);

    int deleteByExample(JoinUsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JoinUs record);

    int insertSelective(JoinUs record);

    List<JoinUs> selectByExampleWithBLOBs(JoinUsExample example);

    List<JoinUs> selectByExample(JoinUsExample example);

    JoinUs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JoinUs record, @Param("example") JoinUsExample example);

    int updateByExampleWithBLOBs(@Param("record") JoinUs record, @Param("example") JoinUsExample example);

    int updateByExample(@Param("record") JoinUs record, @Param("example") JoinUsExample example);

    int updateByPrimaryKeySelective(JoinUs record);

    int updateByPrimaryKeyWithBLOBs(JoinUs record);

    int updateByPrimaryKey(JoinUs record);
}