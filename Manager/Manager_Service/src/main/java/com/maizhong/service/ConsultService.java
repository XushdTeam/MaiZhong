package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbConsult;

/**
 * Description:用户咨询管理服务接口
 * User: 王存浩
 * Date: 2017-03-21
 * Time: 15:12
 */
public interface ConsultService {


    PageResult getConsultList(PageSearchParam param);

    TbConsult getConsultById(Long id);

    OperateEnum updatConsult(TbConsult tbConsult);
}
