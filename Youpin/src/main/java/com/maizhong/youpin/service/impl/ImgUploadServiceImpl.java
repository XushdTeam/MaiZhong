package com.maizhong.youpin.service.impl;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.FileUploadUtil;
import com.maizhong.youpin.service.ImgUploadService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xushd on 2017/8/17.
 */
@Service
public class ImgUploadServiceImpl implements ImgUploadService {

    @Value("${ENDPOINT}")
    private  String ENDPOINT;

    @Value("${ACCESSKEYID}")
    private  String ACCESSKEYID;

    @Value("${ACCESSKEYSECRET}")
    private  String ACCESSKEYSECRET;

    @Value("${BUCKETNAME}")
    private  String BUCKETNAME;

    @Value("${IMGURL}")
    private  String IMGURL;

    /**
     * 获取OSS对象参数
     * @return
     */
    private Map<String,String> getParam(){
        Map<String,String> param = new HashMap<>();
        param.put("endpoint",ENDPOINT);
        param.put("accessKeyId",ACCESSKEYID);
        param.put("accessKeySecret",ACCESSKEYSECRET);
        param.put("bucketName",BUCKETNAME);
        return param;
    }

    @Override
    public JsonResult uploadImg(String imgStr, String type) {

        try {
            String fileName = "";
            String[] split = imgStr.split(";");
            fileName = "originalFilename.jpg";
            String[] split2 = split[1].split("se64,");
            imgStr = split2[1];
            byte[] bytes = imgStr.getBytes("UTF-8");
            bytes = Base64.decodeBase64(bytes);
            Map<String, String> param = this.getParam();
            param.put("originalFilename",fileName);
            param.put("key",type);
            fileName = FileUploadUtil.UploadFileOSS(param, bytes);
            return JsonResult.OK(IMGURL+type+fileName);

        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.build(OperateEnum.SERVER_ERROR);
        }
    }
}
