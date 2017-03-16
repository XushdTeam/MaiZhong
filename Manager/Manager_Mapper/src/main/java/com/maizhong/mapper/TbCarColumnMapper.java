package com.maizhong.mapper;

import com.maizhong.common.dto.CarColumnJoinCar;
import com.maizhong.pojo.TbCarColumn;
import com.maizhong.pojo.TbCarColumnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbCarColumnMapper {
    long countByExample(TbCarColumnExample example);

    int deleteByExample(TbCarColumnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCarColumn record);

    int insertSelective(TbCarColumn record);

    List<TbCarColumn> selectByExample(TbCarColumnExample example);

    TbCarColumn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCarColumn record, @Param("example") TbCarColumnExample example);

    int updateByExample(@Param("record") TbCarColumn record, @Param("example") TbCarColumnExample example);

    int updateByPrimaryKeySelective(TbCarColumn record);

    int updateByPrimaryKey(TbCarColumn record);

    List<CarColumnJoinCar> getListByColumn(@Param("columnId")Long columnId);
}