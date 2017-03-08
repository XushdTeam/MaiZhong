package com.maizhong.mapper;

import com.maizhong.pojo.TbCarType;
import com.maizhong.pojo.TbCarTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCarTypeMapper {
    long countByExample(TbCarTypeExample example);

    int deleteByExample(TbCarTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarType record);

    int insertSelective(TbCarType record);

    List<TbCarType> selectByExample(TbCarTypeExample example);

    TbCarType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarType record, @Param("example") TbCarTypeExample example);

    int updateByExample(@Param("record") TbCarType record, @Param("example") TbCarTypeExample example);

    int updateByPrimaryKeySelective(TbCarType record);

    int updateByPrimaryKey(TbCarType record);
}