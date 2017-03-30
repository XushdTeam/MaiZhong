package com.maizhong.common.utils;

import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;
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
}
