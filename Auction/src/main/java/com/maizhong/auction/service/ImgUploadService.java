package com.maizhong.auction.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Xushd on 2017/6/19.
 */
public interface ImgUploadService {

    JsonResult uploadImg(String imgStr, String type);

    JsonResult xszSb(String imgUrl);

    JsonResult uploadImgFile(MultipartFile file, String key);

    JsonResult xszSbBase64(String base64);
}
