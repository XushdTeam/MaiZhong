package com.maizhong.mapper;

import com.maizhong.pojo.TbBusiness;
import com.maizhong.pojo.TbBusinessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBusinessMapper {
    long countByExample(TbBusinessExample example);

    int deleteByExample(TbBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbBusiness record);

    int insertSelective(TbBusiness record);

    List<TbBusiness> selectByExample(TbBusinessExample example);

    TbBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbBusiness record, @Param("example") TbBusinessExample example);

    int updateByExample(@Param("record") TbBusiness record, @Param("example") TbBusinessExample example);

    int updateByPrimaryKeySelective(TbBusiness record);

    int updateByPrimaryKey(TbBusiness record);
}