package com.maizhong.mapper;

import com.maizhong.pojo.Version;
import com.maizhong.pojo.VersionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VersionMapper {
    long countByExample(VersionExample example);

    int deleteByExample(VersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Version record);

    int insertSelective(Version record);

    List<Version> selectByExample(VersionExample example);

    Version selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByExample(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);
}