package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCkwgqx;
import com.maizhong.auction.pojo.CkCkwgqxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCkwgqxMapper {
    long countByExample(CkCkwgqxExample example);

    int deleteByExample(CkCkwgqxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCkwgqx record);

    int insertSelective(CkCkwgqx record);

    List<CkCkwgqx> selectByExample(CkCkwgqxExample example);

    CkCkwgqx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCkwgqx record, @Param("example") CkCkwgqxExample example);

    int updateByExample(@Param("record") CkCkwgqx record, @Param("example") CkCkwgqxExample example);

    int updateByPrimaryKeySelective(CkCkwgqx record);

    int updateByPrimaryKey(CkCkwgqx record);
}