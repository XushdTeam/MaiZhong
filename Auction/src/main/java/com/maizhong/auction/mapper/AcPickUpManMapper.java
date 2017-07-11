package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcPickUpMan;
import com.maizhong.auction.pojo.AcPickUpManExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcPickUpManMapper {
    long countByExample(AcPickUpManExample example);

    int deleteByExample(AcPickUpManExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcPickUpMan record);

    int insertSelective(AcPickUpMan record);

    List<AcPickUpMan> selectByExample(AcPickUpManExample example);

    AcPickUpMan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcPickUpMan record, @Param("example") AcPickUpManExample example);

    int updateByExample(@Param("record") AcPickUpMan record, @Param("example") AcPickUpManExample example);

    int updateByPrimaryKeySelective(AcPickUpMan record);

    int updateByPrimaryKey(AcPickUpMan record);
}