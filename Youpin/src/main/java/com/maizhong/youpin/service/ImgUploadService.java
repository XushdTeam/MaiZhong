package com.maizhong.youpin.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/6/19.
 */
public interface ImgUploadService {

    JsonResult uploadImg(String imgStr, String type);

}
