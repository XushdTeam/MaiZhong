package com.maizhong.bRest.service;

import com.maizhong.common.result.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Xushd on 2017/3/29.
 */
public interface ImgUploadService {


    JsonResult uploadImg(MultipartFile filedata, String key);

}
