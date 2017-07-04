package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkVerify;
import com.maizhong.auction.pojo.CkVerifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkVerifyMapper {
    long countByExample(CkVerifyExample example);

    int deleteByExample(CkVerifyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkVerify record);

    int insertSelective(CkVerify record);

    List<CkVerify> selectByExample(CkVerifyExample example);

    CkVerify selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkVerify record, @Param("example") CkVerifyExample example);

    int updateByExample(@Param("record") CkVerify record, @Param("example") CkVerifyExample example);

    int updateByPrimaryKeySelective(CkVerify record);

    int updateByPrimaryKey(CkVerify record);
}