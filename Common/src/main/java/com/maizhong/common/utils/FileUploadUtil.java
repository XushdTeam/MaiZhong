package com.maizhong.common.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * OSS 文件上传
 * Created by Xushd on 2017/3/30.
 */
public class FileUploadUtil {

    public static String UploadFileOSS(Map<String, String> param, byte[] bytes) {

        OSSClient client = new OSSClient(param.get("endpoint"), param.get("accessKeyId"), param.get("accessKeySecret"));
        // 新文件名
        String newFileName = IDUtils.genImageName() + param.get("originalFilename").substring(param.get("originalFilename").lastIndexOf("."));

        client.putObject(param.get("bucketName"),param.get("key")+newFileName, new ByteArrayInputStream(bytes));

        return newFileName;

    }

    /**
     * json文件上传到OSS
     * @param param
     * @param is
     * @return
     */
    public static boolean UploadJsonOSS(Map<String, String> param, InputStream is){

        OSSClient client = new OSSClient(param.get("endpoint"), param.get("accessKeyId"), param.get("accessKeySecret"));

        try {
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(is.available());
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType("application/json;charset=UTF-8");
            //上传文件
            client.putObject(param.get("bucketName"),param.get("key")+param.get("fileName"), is, metadata);
            return true;
        } catch (Exception e) {
            System.out.println("上传阿里云OSS服务器异常." + e.getMessage());
        }
        return false;
    }
}
