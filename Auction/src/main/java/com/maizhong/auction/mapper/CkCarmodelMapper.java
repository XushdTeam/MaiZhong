package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.CkCarmodel;
import com.maizhong.auction.pojo.CkCarmodelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkCarmodelMapper {
    long countByExample(CkCarmodelExample example);

    int deleteByExample(CkCarmodelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CkCarmodel record);

    int insertSelective(CkCarmodel record);

    List<CkCarmodel> selectByExample(CkCarmodelExample example);

    CkCarmodel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CkCarmodel record, @Param("example") CkCarmodelExample example);

    int updateByExample(@Param("record") CkCarmodel record, @Param("example") CkCarmodelExample example);

    int updateByPrimaryKeySelective(CkCarmodel record);

    int updateByPrimaryKey(CkCarmodel record);
}