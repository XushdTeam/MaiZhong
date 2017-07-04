package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.SysUserMenu;
import com.maizhong.auction.pojo.SysUserMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMenuMapper {
    long countByExample(SysUserMenuExample example);

    int deleteByExample(SysUserMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserMenu record);

    int insertSelective(SysUserMenu record);

    List<SysUserMenu> selectByExample(SysUserMenuExample example);

    SysUserMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserMenu record, @Param("example") SysUserMenuExample example);

    int updateByExample(@Param("record") SysUserMenu record, @Param("example") SysUserMenuExample example);

    int updateByPrimaryKeySelective(SysUserMenu record);

    int updateByPrimaryKey(SysUserMenu record);
}