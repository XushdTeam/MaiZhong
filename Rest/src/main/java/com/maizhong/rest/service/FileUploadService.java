package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务接口
 * Created by Xushd on 2017/3/2.
 */
public interface FileUploadService {

    /**
     * 图片上传
     * @param json
     * @param key
     * @param fileName
     * @return
     */
    JsonResult uploadImg(byte[] json, String key,String fileName);
}
