package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkPz;
import com.maizhong.auction.pojo.CkPzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkPzMapper {
    long countByExample(CkPzExample example);

    int deleteByExample(CkPzExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkPz record);

    int insertSelective(CkPz record);

    List<CkPz> selectByExample(CkPzExample example);

    CkPz selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkPz record, @Param("example") CkPzExample example);

    int updateByExample(@Param("record") CkPz record, @Param("example") CkPzExample example);

    int updateByPrimaryKeySelective(CkPz record);

    int updateByPrimaryKey(CkPz record);
}