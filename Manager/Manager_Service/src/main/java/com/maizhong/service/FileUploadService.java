package com.maizhong.service;

import com.maizhong.common.result.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务接口
 * Created by Xushd on 2017/3/2.
 */
public interface FileUploadService {

    /**
     * 图片上传服务
     * @param filedata 文件
     * @param key 分类路径
     * @return
     */
    JsonResult uploadImg(MultipartFile filedata,String key);
}
