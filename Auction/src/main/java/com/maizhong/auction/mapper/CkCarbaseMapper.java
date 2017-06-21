package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCarbase;
import com.maizhong.auction.pojo.CkCarbaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCarbaseMapper {
    long countByExample(CkCarbaseExample example);

    int deleteByExample(CkCarbaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCarbase record);

    int insertSelective(CkCarbase record);

    List<CkCarbase> selectByExample(CkCarbaseExample example);

    CkCarbase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCarbase record, @Param("example") CkCarbaseExample example);

    int updateByExample(@Param("record") CkCarbase record, @Param("example") CkCarbaseExample example);

    int updateByPrimaryKeySelective(CkCarbase record);

    int updateByPrimaryKey(CkCarbase record);
}