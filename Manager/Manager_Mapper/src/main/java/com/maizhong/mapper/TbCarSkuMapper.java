package com.maizhong.mapper;

import com.maizhong.pojo.TbCarSku;
import com.maizhong.pojo.TbCarSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCarSkuMapper {
    long countByExample(TbCarSkuExample example);

    int deleteByExample(TbCarSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarSku record);

    int insertSelective(TbCarSku record);

    List<TbCarSku> selectByExample(TbCarSkuExample example);

    TbCarSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarSku record, @Param("example") TbCarSkuExample example);

    int updateByExample(@Param("record") TbCarSku record, @Param("example") TbCarSkuExample example);

    int updateByPrimaryKeySelective(TbCarSku record);

    int updateByPrimaryKey(TbCarSku record);
}