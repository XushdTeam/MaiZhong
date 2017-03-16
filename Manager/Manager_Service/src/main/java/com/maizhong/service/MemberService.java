package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-15
 * Time: 10:15
 */
public interface MemberService {

    /**
     * 会员列表--分页
     * @param param
     * @return
     */
    PageResult getMemberList(PageSearchParam param);
}
