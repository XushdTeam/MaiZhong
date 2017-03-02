package com.maizhong.service;

import com.maizhong.common.result.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务接口
 * Created by Xushd on 2017/3/2.
 */
public interface FileUploadService {

    JsonResult uploadImg(MultipartFile filedata);
}
