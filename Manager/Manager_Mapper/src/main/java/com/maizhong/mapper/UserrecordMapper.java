package com.maizhong.mapper;

import com.maizhong.pojo.Userrecord;
import com.maizhong.pojo.UserrecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserrecordMapper {
    long countByExample(UserrecordExample example);

    int deleteByExample(UserrecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Userrecord record);

    int insertSelective(Userrecord record);

    List<Userrecord> selectByExample(UserrecordExample example);

    Userrecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Userrecord record, @Param("example") UserrecordExample example);

    int updateByExample(@Param("record") Userrecord record, @Param("example") UserrecordExample example);

    int updateByPrimaryKeySelective(Userrecord record);

    int updateByPrimaryKey(Userrecord record);
}