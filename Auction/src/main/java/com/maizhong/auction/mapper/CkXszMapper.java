package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkXsz;
import com.maizhong.auction.pojo.CkXszExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkXszMapper {
    long countByExample(CkXszExample example);

    int deleteByExample(CkXszExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkXsz record);

    int insertSelective(CkXsz record);

    List<CkXsz> selectByExample(CkXszExample example);

    CkXsz selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkXsz record, @Param("example") CkXszExample example);

    int updateByExample(@Param("record") CkXsz record, @Param("example") CkXszExample example);

    int updateByPrimaryKeySelective(CkXsz record);

    int updateByPrimaryKey(CkXsz record);
}