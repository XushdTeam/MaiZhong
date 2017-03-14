package com.maizhong.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangF on 2017/3/7.
 */
@RequestMapping("/file")
@Controller
public class FileUploadController {


    @Resource
    private FileUploadService fileUploadService;

    @Value("${CAR_FILEPATH_KEY}")
    private String carImgFilepathKey;

    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam(value = "uploadFile") MultipartFile file ){

        Map<String,Object> result = new HashMap<>();

        JsonResult jsonResult = fileUploadService.uploadImg(file,carImgFilepathKey==null?"/car":carImgFilepathKey);

        if (jsonResult!=null&&jsonResult.getStatus()==200&&jsonResult.getData()!=null){
            result.put("error",0);
            result.put("url",jsonResult.getData().toString());
        }else{
            result.put("error",1);
            result.put("message","图片添加失败");
        }
        return result;
    }
}
