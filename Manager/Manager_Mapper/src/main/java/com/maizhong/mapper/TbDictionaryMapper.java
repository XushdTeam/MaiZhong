package com.maizhong.mapper;

import com.maizhong.pojo.TbDictionary;
import com.maizhong.pojo.TbDictionaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbDictionaryMapper {
    long countByExample(TbDictionaryExample example);

    int deleteByExample(TbDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbDictionary record);

    int insertSelective(TbDictionary record);

    List<TbDictionary> selectByExample(TbDictionaryExample example);

    TbDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbDictionary record, @Param("example") TbDictionaryExample example);

    int updateByExample(@Param("record") TbDictionary record, @Param("example") TbDictionaryExample example);

    int updateByPrimaryKeySelective(TbDictionary record);

    int updateByPrimaryKey(TbDictionary record);
}