package com.maizhong.rest.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandLine;
import com.maizhong.pojo.TbCarType;
import com.maizhong.pojo.TbDictionary;
import com.maizhong.pojo.vo.SearchResult;

import java.util.List;
import java.util.Map;

/**
 * Created by yangF on 2017/3/14.
 */
public interface SearchService {
    /**
    * 数据库同步索引
    * */
    public JsonResult syncIndex();


    public JsonResult searchDoc(PageSearchParam param);

    List<TbDictionary> searchDicList(Long typeId);

    List<TbCarBrand> searchCarBrandList();

    List<TbCarType> searchCarType();

    JsonResult searchBrandLineList(Long brandId);

    SearchResult searchPageResult(PageSearchParam param);

    List<TbCarBrandLine> searchCarBrandLineList(String car_brand);
}
