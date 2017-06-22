package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCzinfo;
import com.maizhong.auction.pojo.CkCzinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCzinfoMapper {
    long countByExample(CkCzinfoExample example);

    int deleteByExample(CkCzinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCzinfo record);

    int insertSelective(CkCzinfo record);

    List<CkCzinfo> selectByExample(CkCzinfoExample example);

    CkCzinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCzinfo record, @Param("example") CkCzinfoExample example);

    int updateByExample(@Param("record") CkCzinfo record, @Param("example") CkCzinfoExample example);

    int updateByPrimaryKeySelective(CkCzinfo record);

    int updateByPrimaryKey(CkCzinfo record);
}