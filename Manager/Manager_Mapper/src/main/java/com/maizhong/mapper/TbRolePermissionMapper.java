package com.maizhong.mapper;

import com.maizhong.pojo.TbRolePermissionExample;
import com.maizhong.pojo.TbRolePermissionKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRolePermissionMapper {
    long countByExample(TbRolePermissionExample example);

    int deleteByExample(TbRolePermissionExample example);

    int deleteByPrimaryKey(TbRolePermissionKey key);

    int insert(TbRolePermissionKey record);

    int insertSelective(TbRolePermissionKey record);

    List<TbRolePermissionKey> selectByExample(TbRolePermissionExample example);

    int updateByExampleSelective(@Param("record") TbRolePermissionKey record, @Param("example") TbRolePermissionExample example);

    int updateByExample(@Param("record") TbRolePermissionKey record, @Param("example") TbRolePermissionExample example);
}