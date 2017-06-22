package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkQtz;
import com.maizhong.auction.pojo.CkQtzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkQtzMapper {
    long countByExample(CkQtzExample example);

    int deleteByExample(CkQtzExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkQtz record);

    int insertSelective(CkQtz record);

    List<CkQtz> selectByExample(CkQtzExample example);

    CkQtz selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkQtz record, @Param("example") CkQtzExample example);

    int updateByExample(@Param("record") CkQtz record, @Param("example") CkQtzExample example);

    int updateByPrimaryKeySelective(CkQtz record);

    int updateByPrimaryKey(CkQtz record);
}