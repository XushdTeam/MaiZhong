package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCknsqx;
import com.maizhong.auction.pojo.CkCknsqxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCknsqxMapper {
    long countByExample(CkCknsqxExample example);

    int deleteByExample(CkCknsqxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCknsqx record);

    int insertSelective(CkCknsqx record);

    List<CkCknsqx> selectByExample(CkCknsqxExample example);

    CkCknsqx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCknsqx record, @Param("example") CkCknsqxExample example);

    int updateByExample(@Param("record") CkCknsqx record, @Param("example") CkCknsqxExample example);

    int updateByPrimaryKeySelective(CkCknsqx record);

    int updateByPrimaryKey(CkCknsqx record);
}