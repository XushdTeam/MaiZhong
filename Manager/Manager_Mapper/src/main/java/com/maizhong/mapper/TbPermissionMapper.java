package com.maizhong.mapper;

import com.maizhong.pojo.TbPermission;
import com.maizhong.pojo.TbPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper {

    long countByExample(TbPermissionExample example);

    int deleteByExample(TbPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbPermission record);

    int insertSelective(TbPermission record);

    List<TbPermission> selectByExample(TbPermissionExample example);

    TbPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbPermission record, @Param("example") TbPermissionExample example);

    int updateByExample(@Param("record") TbPermission record, @Param("example") TbPermissionExample example);

    int updateByPrimaryKeySelective(TbPermission record);

    int updateByPrimaryKey(TbPermission record);

    List<TbPermission> getPermissionByRoleId(Long id);

    List<TbPermission> getPermissionByRoleIdAll(@Param("roleId") Long roleId, @Param("parentId") Long parentId);
}