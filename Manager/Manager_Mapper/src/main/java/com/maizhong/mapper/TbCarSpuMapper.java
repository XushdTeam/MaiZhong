package com.maizhong.mapper;

import com.maizhong.pojo.TbCarSpu;
import com.maizhong.pojo.TbCarSpuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCarSpuMapper {
    long countByExample(TbCarSpuExample example);

    int deleteByExample(TbCarSpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarSpu record);

    int insertSelective(TbCarSpu record);

    List<TbCarSpu> selectByExampleWithBLOBs(TbCarSpuExample example);

    List<TbCarSpu> selectByExample(TbCarSpuExample example);

    TbCarSpu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarSpu record, @Param("example") TbCarSpuExample example);

    int updateByExampleWithBLOBs(@Param("record") TbCarSpu record, @Param("example") TbCarSpuExample example);

    int updateByExample(@Param("record") TbCarSpu record, @Param("example") TbCarSpuExample example);

    int updateByPrimaryKeySelective(TbCarSpu record);

    int updateByPrimaryKeyWithBLOBs(TbCarSpu record);

    int updateByPrimaryKey(TbCarSpu record);
}