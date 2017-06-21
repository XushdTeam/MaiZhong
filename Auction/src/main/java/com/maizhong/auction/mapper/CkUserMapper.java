package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkUser;
import com.maizhong.auction.pojo.CkUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkUserMapper {
    long countByExample(CkUserExample example);

    int deleteByExample(CkUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkUser record);

    int insertSelective(CkUser record);

    List<CkUser> selectByExample(CkUserExample example);

    CkUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkUser record, @Param("example") CkUserExample example);

    int updateByExample(@Param("record") CkUser record, @Param("example") CkUserExample example);

    int updateByPrimaryKeySelective(CkUser record);

    int updateByPrimaryKey(CkUser record);
}