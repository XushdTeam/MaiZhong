package com.maizhong.bRest.service.impl;

import com.maizhong.bRest.service.ImgUploadService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xushd on 2017/3/29.
 */
@Service
public class ImgUploadServiceImpl implements ImgUploadService {

    // aliOSS

    @Value("${ENDPOINT}")
    private String ENDPOINT;

    @Value("${ACCESSKEYID}")
    private String ACCESSKEYID;

    @Value("${ACCESSKEYSECRET}")
    private String ACCESSKEYSECRET;

    @Value("${BUCKETNAME}")
    private String BUCKETNAME;

    @Value("${IMGURL}")
    private String IMGURL;


    @Override
    public JsonResult uploadImg(MultipartFile filedata, String key) {

        try {
            if (filedata.isEmpty()) return JsonResult.build(OperateEnum.FILE_EMPTY);
            if (filedata.getSize() > 2000 * 1024) return JsonResult.build(OperateEnum.FILE_SIZE);

            Map param = getParam();
            String originalFilename = filedata.getOriginalFilename();
            param.put("originalFilename", originalFilename);
            param.put("key", key);

            String newFileName = FileUploadUtil.UploadFileOSS(param, filedata.getBytes());

            return JsonResult.build(200, OperateEnum.FILE_UPLOAD_SUCCESS.getStateInfo(), IMGURL + key + newFileName);

        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.build(OperateEnum.FAILE);
        }
    }

    /**
     * 获取OSS对象参数
     *
     * @return
     */
    private Map<String, String> getParam() {

        Map<String, String> param = new HashMap<>();
        param.put("endpoint", ENDPOINT);
        param.put("accessKeyId", ACCESSKEYID);
        param.put("accessKeySecret", ACCESSKEYSECRET);
        param.put("bucketName", BUCKETNAME);

        return param;
    }
}
