package com.maizhong.mapper;

import com.maizhong.pojo.TbBusinessUser;
import com.maizhong.pojo.TbBusinessUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBusinessUserMapper {
    long countByExample(TbBusinessUserExample example);

    int deleteByExample(TbBusinessUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbBusinessUser record);

    int insertSelective(TbBusinessUser record);

    List<TbBusinessUser> selectByExample(TbBusinessUserExample example);

    TbBusinessUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbBusinessUser record, @Param("example") TbBusinessUserExample example);

    int updateByExample(@Param("record") TbBusinessUser record, @Param("example") TbBusinessUserExample example);

    int updateByPrimaryKeySelective(TbBusinessUser record);

    int updateByPrimaryKey(TbBusinessUser record);
}