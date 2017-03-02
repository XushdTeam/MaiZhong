package com.maizhong.mapper;

import com.maizhong.pojo.TbLog;
import com.maizhong.pojo.TbLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbLogMapper {
    long countByExample(TbLogExample example);

    int deleteByExample(TbLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbLog record);

    int insertSelective(TbLog record);

    List<TbLog> selectByExampleWithBLOBs(TbLogExample example);

    List<TbLog> selectByExample(TbLogExample example);

    TbLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbLog record, @Param("example") TbLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TbLog record, @Param("example") TbLogExample example);

    int updateByExample(@Param("record") TbLog record, @Param("example") TbLogExample example);

    int updateByPrimaryKeySelective(TbLog record);

    int updateByPrimaryKeyWithBLOBs(TbLog record);

    int updateByPrimaryKey(TbLog record);
}