package com.maizhong.mapper.ext;

import com.maizhong.pojo.TbCarExample;
import com.maizhong.pojo.vo.TbCarVo;

import java.util.List;

/**
 * Created by yangF on 2017/3/9.
 */
public interface TbCarMapperExt {
    public List<TbCarVo> findListNotContainsDesc(TbCarExample tbCarExample);
}
