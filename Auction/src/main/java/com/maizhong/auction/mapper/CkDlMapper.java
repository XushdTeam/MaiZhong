package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkDl;
import com.maizhong.auction.pojo.CkDlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkDlMapper {
    long countByExample(CkDlExample example);

    int deleteByExample(CkDlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkDl record);

    int insertSelective(CkDl record);

    List<CkDl> selectByExample(CkDlExample example);

    CkDl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkDl record, @Param("example") CkDlExample example);

    int updateByExample(@Param("record") CkDl record, @Param("example") CkDlExample example);

    int updateByPrimaryKeySelective(CkDl record);

    int updateByPrimaryKey(CkDl record);
}