package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.TpHistory;
import com.maizhong.auction.pojo.TpHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpHistoryMapper {
    long countByExample(TpHistoryExample example);

    int deleteByExample(TpHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TpHistory record);

    int insertSelective(TpHistory record);

    List<TpHistory> selectByExample(TpHistoryExample example);

    TpHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TpHistory record, @Param("example") TpHistoryExample example);

    int updateByExample(@Param("record") TpHistory record, @Param("example") TpHistoryExample example);

    int updateByPrimaryKeySelective(TpHistory record);

    int updateByPrimaryKey(TpHistory record);
}