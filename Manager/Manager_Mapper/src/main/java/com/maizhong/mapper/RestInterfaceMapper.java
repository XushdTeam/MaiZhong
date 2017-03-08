package com.maizhong.mapper;

import com.maizhong.pojo.RestInterface;
import com.maizhong.pojo.RestInterfaceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RestInterfaceMapper {
    long countByExample(RestInterfaceExample example);

    int deleteByExample(RestInterfaceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RestInterface record);

    int insertSelective(RestInterface record);

    List<RestInterface> selectByExample(RestInterfaceExample example);

    RestInterface selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RestInterface record, @Param("example") RestInterfaceExample example);

    int updateByExample(@Param("record") RestInterface record, @Param("example") RestInterfaceExample example);

    int updateByPrimaryKeySelective(RestInterface record);

    int updateByPrimaryKey(RestInterface record);
}