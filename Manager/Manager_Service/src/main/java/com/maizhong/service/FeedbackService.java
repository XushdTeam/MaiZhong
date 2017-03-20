package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-20
 * Time: 14:22
 */
public interface FeedbackService {

    PageResult getFeedBackList(PageSearchParam param);
}
