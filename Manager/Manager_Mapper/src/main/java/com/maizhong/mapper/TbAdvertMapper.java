package com.maizhong.mapper;

import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbAdvertExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAdvertMapper {
    long countByExample(TbAdvertExample example);

    int deleteByExample(TbAdvertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdvert record);

    int insertSelective(TbAdvert record);

    List<TbAdvert> selectByExampleWithBLOBs(TbAdvertExample example);

    List<TbAdvert> selectByExample(TbAdvertExample example);

    TbAdvert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdvert record, @Param("example") TbAdvertExample example);

    int updateByExampleWithBLOBs(@Param("record") TbAdvert record, @Param("example") TbAdvertExample example);

    int updateByExample(@Param("record") TbAdvert record, @Param("example") TbAdvertExample example);

    int updateByPrimaryKeySelective(TbAdvert record);

    int updateByPrimaryKeyWithBLOBs(TbAdvert record);

    int updateByPrimaryKey(TbAdvert record);

    List<TbAdvert> getAdvertPublish(Long typeId);
}