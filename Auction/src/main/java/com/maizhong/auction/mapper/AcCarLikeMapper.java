package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcCarLikeExample;
import com.maizhong.auction.pojo.AcCarLikeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcCarLikeMapper {
    long countByExample(AcCarLikeExample example);

    int deleteByExample(AcCarLikeExample example);

    int deleteByPrimaryKey(AcCarLikeKey key);

    int insert(AcCarLikeKey record);

    int insertSelective(AcCarLikeKey record);

    List<AcCarLikeKey> selectByExample(AcCarLikeExample example);

    int updateByExampleSelective(@Param("record") AcCarLikeKey record, @Param("example") AcCarLikeExample example);

    int updateByExample(@Param("record") AcCarLikeKey record, @Param("example") AcCarLikeExample example);
}