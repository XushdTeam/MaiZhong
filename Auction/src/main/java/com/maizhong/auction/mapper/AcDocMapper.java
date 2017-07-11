package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcDoc;
import com.maizhong.auction.pojo.AcDocExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcDocMapper {
    long countByExample(AcDocExample example);

    int deleteByExample(AcDocExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcDoc record);

    int insertSelective(AcDoc record);

    List<AcDoc> selectByExample(AcDocExample example);

    AcDoc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcDoc record, @Param("example") AcDocExample example);

    int updateByExample(@Param("record") AcDoc record, @Param("example") AcDocExample example);

    int updateByPrimaryKeySelective(AcDoc record);

    int updateByPrimaryKey(AcDoc record);
}