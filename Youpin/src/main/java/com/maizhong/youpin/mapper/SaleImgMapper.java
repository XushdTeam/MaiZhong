package com.maizhong.youpin.mapper;

import com.maizhong.youpin.pojo.SaleImg;
import com.maizhong.youpin.pojo.SaleImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleImgMapper {
    long countByExample(SaleImgExample example);

    int deleteByExample(SaleImgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SaleImg record);

    int insertSelective(SaleImg record);

    List<SaleImg> selectByExample(SaleImgExample example);

    SaleImg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SaleImg record, @Param("example") SaleImgExample example);

    int updateByExample(@Param("record") SaleImg record, @Param("example") SaleImgExample example);

    int updateByPrimaryKeySelective(SaleImg record);

    int updateByPrimaryKey(SaleImg record);
}