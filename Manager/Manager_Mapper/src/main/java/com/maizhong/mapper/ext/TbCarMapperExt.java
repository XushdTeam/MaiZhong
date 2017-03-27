package com.maizhong.mapper.ext;

import com.maizhong.pojo.TbCarExample;
import com.maizhong.pojo.vo.TbCarBaseVo;
import com.maizhong.pojo.vo.TbCarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by yangF on 2017/3/9.
 */
public interface TbCarMapperExt {
    public List<TbCarVo> findListNotContainsDesc(TbCarExample tbCarExample);
    public List<TbCarBaseVo> findByCarYearAndCarSeres(@Param("carSeries") String carSeries,@Param("carYear") String carYear);
    public List<TbCarVo> findDocsForSolrStore();
}
