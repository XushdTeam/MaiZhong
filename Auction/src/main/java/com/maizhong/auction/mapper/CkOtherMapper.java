package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkOther;
import com.maizhong.auction.pojo.CkOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkOtherMapper {
    long countByExample(CkOtherExample example);

    int deleteByExample(CkOtherExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkOther record);

    int insertSelective(CkOther record);

    List<CkOther> selectByExample(CkOtherExample example);

    CkOther selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkOther record, @Param("example") CkOtherExample example);

    int updateByExample(@Param("record") CkOther record, @Param("example") CkOtherExample example);

    int updateByPrimaryKeySelective(CkOther record);

    int updateByPrimaryKey(CkOther record);
}