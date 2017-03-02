package com.maizhong.mapper;

import com.maizhong.pojo.TbUserRoleExample;
import com.maizhong.pojo.TbUserRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserRoleMapper {
    long countByExample(TbUserRoleExample example);

    int deleteByExample(TbUserRoleExample example);

    int deleteByPrimaryKey(TbUserRoleKey key);

    int insert(TbUserRoleKey record);

    int insertSelective(TbUserRoleKey record);

    List<TbUserRoleKey> selectByExample(TbUserRoleExample example);

    int updateByExampleSelective(@Param("record") TbUserRoleKey record, @Param("example") TbUserRoleExample example);

    int updateByExample(@Param("record") TbUserRoleKey record, @Param("example") TbUserRoleExample example);
}