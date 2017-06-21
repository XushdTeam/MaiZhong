package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkHelp;
import com.maizhong.auction.pojo.CkHelpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkHelpMapper {
    long countByExample(CkHelpExample example);

    int deleteByExample(CkHelpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkHelp record);

    int insertSelective(CkHelp record);

    List<CkHelp> selectByExample(CkHelpExample example);

    CkHelp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkHelp record, @Param("example") CkHelpExample example);

    int updateByExample(@Param("record") CkHelp record, @Param("example") CkHelpExample example);

    int updateByPrimaryKeySelective(CkHelp record);

    int updateByPrimaryKey(CkHelp record);
}