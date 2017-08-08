package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.AcFeedback;
import com.maizhong.auction.pojo.AcFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcFeedbackMapper {
    long countByExample(AcFeedbackExample example);

    int deleteByExample(AcFeedbackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcFeedback record);

    int insertSelective(AcFeedback record);

    List<AcFeedback> selectByExample(AcFeedbackExample example);

    AcFeedback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcFeedback record, @Param("example") AcFeedbackExample example);

    int updateByExample(@Param("record") AcFeedback record, @Param("example") AcFeedbackExample example);

    int updateByPrimaryKeySelective(AcFeedback record);

    int updateByPrimaryKey(AcFeedback record);
}