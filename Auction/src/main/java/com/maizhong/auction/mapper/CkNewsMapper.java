package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkNews;
import com.maizhong.auction.pojo.CkNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkNewsMapper {
    long countByExample(CkNewsExample example);

    int deleteByExample(CkNewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkNews record);

    int insertSelective(CkNews record);

    List<CkNews> selectByExample(CkNewsExample example);

    CkNews selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkNews record, @Param("example") CkNewsExample example);

    int updateByExample(@Param("record") CkNews record, @Param("example") CkNewsExample example);

    int updateByPrimaryKeySelective(CkNews record);

    int updateByPrimaryKey(CkNews record);
}