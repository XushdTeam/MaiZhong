package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCksg;
import com.maizhong.auction.pojo.CkCksgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCksgMapper {
    long countByExample(CkCksgExample example);

    int deleteByExample(CkCksgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCksg record);

    int insertSelective(CkCksg record);

    List<CkCksg> selectByExample(CkCksgExample example);

    CkCksg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCksg record, @Param("example") CkCksgExample example);

    int updateByExample(@Param("record") CkCksg record, @Param("example") CkCksgExample example);

    int updateByPrimaryKeySelective(CkCksg record);

    int updateByPrimaryKey(CkCksg record);
}