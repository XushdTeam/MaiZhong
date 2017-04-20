package com.maizhong.mapper;

import com.maizhong.pojo.LineSite;
import com.maizhong.pojo.LineSiteExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LineSiteMapper {
    long countByExample(LineSiteExample example);

    int deleteByExample(LineSiteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LineSite record);

    int insertSelective(LineSite record);

    List<LineSite> selectByExample(LineSiteExample example);

    LineSite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LineSite record, @Param("example") LineSiteExample example);

    int updateByExample(@Param("record") LineSite record, @Param("example") LineSiteExample example);

    int updateByPrimaryKeySelective(LineSite record);

    int updateByPrimaryKey(LineSite record);
}