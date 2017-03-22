package com.maizhong.mapper;

import com.maizhong.pojo.TbConsult;
import com.maizhong.pojo.TbConsultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbConsultMapper {
    long countByExample(TbConsultExample example);

    int deleteByExample(TbConsultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbConsult record);

    int insertSelective(TbConsult record);

    List<TbConsult> selectByExample(TbConsultExample example);

    TbConsult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbConsult record, @Param("example") TbConsultExample example);

    int updateByExample(@Param("record") TbConsult record, @Param("example") TbConsultExample example);

    int updateByPrimaryKeySelective(TbConsult record);

    int updateByPrimaryKey(TbConsult record);
}