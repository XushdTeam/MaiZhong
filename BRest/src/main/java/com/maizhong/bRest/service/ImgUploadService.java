package com.maizhong.bRest.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Xushd on 2017/3/29.
 */
public interface ImgUploadService {


    String uploadImg(MultipartFile filedata);

}
