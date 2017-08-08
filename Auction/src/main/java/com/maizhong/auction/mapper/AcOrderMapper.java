package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcOrder;
import com.maizhong.auction.pojo.AcOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcOrderMapper {
    long countByExample(AcOrderExample example);

    int deleteByExample(AcOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcOrder record);

    int insertSelective(AcOrder record);

    List<AcOrder> selectByExample(AcOrderExample example);

    AcOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcOrder record, @Param("example") AcOrderExample example);

    int updateByExample(@Param("record") AcOrder record, @Param("example") AcOrderExample example);

    int updateByPrimaryKeySelective(AcOrder record);

    int updateByPrimaryKey(AcOrder record);
}