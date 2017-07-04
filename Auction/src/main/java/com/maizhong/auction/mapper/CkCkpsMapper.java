package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCkps;
import com.maizhong.auction.pojo.CkCkpsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCkpsMapper {
    long countByExample(CkCkpsExample example);

    int deleteByExample(CkCkpsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCkps record);

    int insertSelective(CkCkps record);

    List<CkCkps> selectByExample(CkCkpsExample example);

    CkCkps selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCkps record, @Param("example") CkCkpsExample example);

    int updateByExample(@Param("record") CkCkps record, @Param("example") CkCkpsExample example);

    int updateByPrimaryKeySelective(CkCkps record);

    int updateByPrimaryKey(CkCkps record);
}