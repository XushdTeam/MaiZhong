package com.maizhong.service;

import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbCarColumn;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-15
 * Time: 15:40
 */
public interface CarColumnService {
    PageResult getCarColumnList(PageSearchParam param);


    OperateEnum insertCarColumn(TbCarColumn tbCarColumn);

    List<KeyValue> getColumnList();

    OperateEnum deleteColumnCarById(long id);

    TbCarColumn getCarColumnByid(Long aLong);

    OperateEnum updateCarColumn(TbCarColumn tbCarColumn);
}
