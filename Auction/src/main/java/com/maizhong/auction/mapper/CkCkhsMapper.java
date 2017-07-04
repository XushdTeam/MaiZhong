package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCkhs;
import com.maizhong.auction.pojo.CkCkhsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCkhsMapper {
    long countByExample(CkCkhsExample example);

    int deleteByExample(CkCkhsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCkhs record);

    int insertSelective(CkCkhs record);

    List<CkCkhs> selectByExample(CkCkhsExample example);

    CkCkhs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCkhs record, @Param("example") CkCkhsExample example);

    int updateByExample(@Param("record") CkCkhs record, @Param("example") CkCkhsExample example);

    int updateByPrimaryKeySelective(CkCkhs record);

    int updateByPrimaryKey(CkCkhs record);
}