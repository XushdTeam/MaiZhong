package com.maizhong.mapper;

import com.maizhong.pojo.Gzrecord;
import com.maizhong.pojo.GzrecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzrecordMapper {
    long countByExample(GzrecordExample example);

    int deleteByExample(GzrecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Gzrecord record);

    int insertSelective(Gzrecord record);

    List<Gzrecord> selectByExample(GzrecordExample example);

    Gzrecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Gzrecord record, @Param("example") GzrecordExample example);

    int updateByExample(@Param("record") Gzrecord record, @Param("example") GzrecordExample example);

    int updateByPrimaryKeySelective(Gzrecord record);

    int updateByPrimaryKey(Gzrecord record);
}