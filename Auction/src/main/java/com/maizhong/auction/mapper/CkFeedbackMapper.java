package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkFeedback;
import com.maizhong.auction.pojo.CkFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkFeedbackMapper {
    long countByExample(CkFeedbackExample example);

    int deleteByExample(CkFeedbackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkFeedback record);

    int insertSelective(CkFeedback record);

    List<CkFeedback> selectByExample(CkFeedbackExample example);

    CkFeedback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkFeedback record, @Param("example") CkFeedbackExample example);

    int updateByExample(@Param("record") CkFeedback record, @Param("example") CkFeedbackExample example);

    int updateByPrimaryKeySelective(CkFeedback record);

    int updateByPrimaryKey(CkFeedback record);
}