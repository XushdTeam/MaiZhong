package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.PsUser;
import com.maizhong.auction.pojo.PsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PsUserMapper {
    long countByExample(PsUserExample example);

    int deleteByExample(PsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PsUser record);

    int insertSelective(PsUser record);

    List<PsUser> selectByExample(PsUserExample example);

    PsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PsUser record, @Param("example") PsUserExample example);

    int updateByExample(@Param("record") PsUser record, @Param("example") PsUserExample example);

    int updateByPrimaryKeySelective(PsUser record);

    int updateByPrimaryKey(PsUser record);
}