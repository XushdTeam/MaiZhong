package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.TpNow;
import com.maizhong.auction.pojo.TpNowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpNowMapper {
    long countByExample(TpNowExample example);

    int deleteByExample(TpNowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TpNow record);

    int insertSelective(TpNow record);

    List<TpNow> selectByExample(TpNowExample example);

    TpNow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TpNow record, @Param("example") TpNowExample example);

    int updateByExample(@Param("record") TpNow record, @Param("example") TpNowExample example);

    int updateByPrimaryKeySelective(TpNow record);

    int updateByPrimaryKey(TpNow record);
}