package com.maizhong.rest.service.impl;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.FileUploadUtil;
import com.maizhong.rest.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传服务接口实现
 * Created by Xushd on 2017/3/2.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Value("${FTP_SERVER_IP}")
    private String FTP_SERVER_IP;

    @Value("${FTP_SERVER_PORT}")
    private Integer FTP_SERVER_PORT;

    @Value("${FTP_SERVER_USERNAME}")
    private String FTP_SERVER_USERNAME;

    @Value("${FTP_SERVER_PASSWORD}")
    private String FTP_SERVER_PASSWORD;

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



//    public JsonResult uploadImg(MultipartFile filedata,String pathKey) {
//
//        try{
//            if (filedata.isEmpty()) return JsonResult.build(OperateEnum.FILE_EMPTY);
//            if (filedata.getSize() > 500 * 1024) return JsonResult.build(OperateEnum.FILE_SIZE);
//
//            String filePath = "/"+ TimeUtils.getYear()+"/"+TimeUtils.getMonth()+"/"+TimeUtils.getDay();
//
//            String originalFilename = filedata.getOriginalFilename();
//            //新文件名
//            String newFileName = IDUtils.genImageName()+originalFilename.substring(originalFilename.lastIndexOf("."));
//            //转存文件,上传到FTP
//            FtpUtil.uploadFile(FTP_SERVER_IP,FTP_SERVER_PORT,FTP_SERVER_USERNAME,FTP_SERVER_PASSWORD
//            ,pathKey,filePath,newFileName,filedata.getInputStream());
//
//            return JsonResult.build(200,OperateEnum.FILE_UPLOAD_SUCCESS.getStateInfo(),IMAGE_BASE_URL+pathKey+filePath+"/"+newFileName);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return JsonResult.build(OperateEnum.FAILE);
//        }
//    }

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

    @ServiceLog(methods = "图片上传",module = "文件服务")
    @Override
    public JsonResult uploadImg(byte[] json, String key,String fileName) {
        try {
        /*    if (filedata.isEmpty()) return JsonResult.build(OperateEnum.FILE_EMPTY);
            if (filedata.getSize() > 500 * 1024) return JsonResult.build(OperateEnum.FILE_SIZE);*/
            Map param = getParam();
            param.put("originalFilename",fileName);
            param.put("key",key);
            String newFileName = FileUploadUtil.UploadFileOSS(param,json);
            return JsonResult.build(200,OperateEnum.FILE_UPLOAD_SUCCESS.getStateInfo(),IMGURL+key+newFileName);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.build(OperateEnum.FAILE);
        }
    }
}
