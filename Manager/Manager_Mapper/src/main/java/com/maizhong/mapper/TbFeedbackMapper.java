package com.maizhong.mapper;

import com.maizhong.pojo.TbFeedback;
import com.maizhong.pojo.TbFeedbackExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbFeedbackMapper {
    long countByExample(TbFeedbackExample example);

    int deleteByExample(TbFeedbackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbFeedback record);

    int insertSelective(TbFeedback record);

    List<TbFeedback> selectByExample(TbFeedbackExample example);

    TbFeedback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbFeedback record, @Param("example") TbFeedbackExample example);

    int updateByExample(@Param("record") TbFeedback record, @Param("example") TbFeedbackExample example);

    int updateByPrimaryKeySelective(TbFeedback record);

    int updateByPrimaryKey(TbFeedback record);
}