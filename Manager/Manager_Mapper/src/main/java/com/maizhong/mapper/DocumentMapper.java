package com.maizhong.mapper;

import com.maizhong.pojo.Document;
import com.maizhong.pojo.DocumentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocumentMapper {
    long countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Document record);

    int insertSelective(Document record);

    List<Document> selectByExampleWithBLOBs(DocumentExample example);

    List<Document> selectByExample(DocumentExample example);

    Document selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKeyWithBLOBs(Document record);

    int updateByPrimaryKey(Document record);
}