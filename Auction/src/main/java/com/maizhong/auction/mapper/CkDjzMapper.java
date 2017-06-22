package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkDjz;
import com.maizhong.auction.pojo.CkDjzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkDjzMapper {
    long countByExample(CkDjzExample example);

    int deleteByExample(CkDjzExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkDjz record);

    int insertSelective(CkDjz record);

    List<CkDjz> selectByExample(CkDjzExample example);

    CkDjz selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkDjz record, @Param("example") CkDjzExample example);

    int updateByExample(@Param("record") CkDjz record, @Param("example") CkDjzExample example);

    int updateByPrimaryKeySelective(CkDjz record);

    int updateByPrimaryKey(CkDjz record);
}