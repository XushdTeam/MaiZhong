package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkBaseimg;
import com.maizhong.auction.pojo.CkBaseimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkBaseimgMapper {
    long countByExample(CkBaseimgExample example);

    int deleteByExample(CkBaseimgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkBaseimg record);

    int insertSelective(CkBaseimg record);

    List<CkBaseimg> selectByExample(CkBaseimgExample example);

    CkBaseimg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkBaseimg record, @Param("example") CkBaseimgExample example);

    int updateByExample(@Param("record") CkBaseimg record, @Param("example") CkBaseimgExample example);

    int updateByPrimaryKeySelective(CkBaseimg record);

    int updateByPrimaryKey(CkBaseimg record);
}