package com.maizhong.mapper.ext;

import com.maizhong.common.dto.CarBaseDTO;
import com.maizhong.pojo.TbCarExample;
import com.maizhong.pojo.vo.TbCarBaseVo;
import com.maizhong.pojo.vo.TbCarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Wang on 2017/3/31.
 */
public interface TbCarBaseMapperExt {
    int insertSelective(CarBaseDTO carBaseDTO);
}
