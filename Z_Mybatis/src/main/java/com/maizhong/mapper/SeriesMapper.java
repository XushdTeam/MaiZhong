package com.maizhong.mapper;

import com.maizhong.pojo.Series;
import com.maizhong.pojo.SeriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeriesMapper {
    long countByExample(SeriesExample example);

    int deleteByExample(SeriesExample example);

    int deleteByPrimaryKey(Integer seriesId);

    int insert(Series record);

    int insertSelective(Series record);

    List<Series> selectByExample(SeriesExample example);

    Series selectByPrimaryKey(Integer seriesId);

    int updateByExampleSelective(@Param("record") Series record, @Param("example") SeriesExample example);

    int updateByExample(@Param("record") Series record, @Param("example") SeriesExample example);

    int updateByPrimaryKeySelective(Series record);

    int updateByPrimaryKey(Series record);
}