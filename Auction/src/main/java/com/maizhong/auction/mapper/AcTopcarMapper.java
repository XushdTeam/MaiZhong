package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcTopcar;
import com.maizhong.auction.pojo.AcTopcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcTopcarMapper {
    long countByExample(AcTopcarExample example);

    int deleteByExample(AcTopcarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcTopcar record);

    int insertSelective(AcTopcar record);

    List<AcTopcar> selectByExample(AcTopcarExample example);

    AcTopcar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcTopcar record, @Param("example") AcTopcarExample example);

    int updateByExample(@Param("record") AcTopcar record, @Param("example") AcTopcarExample example);

    int updateByPrimaryKeySelective(AcTopcar record);

    int updateByPrimaryKey(AcTopcar record);
}