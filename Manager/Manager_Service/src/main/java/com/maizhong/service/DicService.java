package com.maizhong.service;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.pojo.TbDictionary;

import java.util.List;

/**
 * 字典操作接口
 * Created by Xushd on 2017/3/2.
 */
public interface DicService {

    List<TbDictionary> getDicList(Boolean isParent);

    TbDictionary getDicById(Long id);

    OperateEnum insertDic(TbDictionary dictionary);

    OperateEnum updateDic(TbDictionary dictionary);

    OperateEnum deleteDic(long id);

    List<TbDictionary> getDicListByParent(long parent);

}
