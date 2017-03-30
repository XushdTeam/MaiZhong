package com.maizhong.bRest.service.impl;

import com.maizhong.bRest.service.ImgUploadService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.FtpUtil;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.TimeUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Xushd on 2017/3/29.
 */
@Service
public class ImgUploadServiceImpl implements ImgUploadService {

    @Override
    public String uploadImg(MultipartFile filedata) {
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
//                    ,pathKey,filePath,newFileName,filedata.getInputStream());
//
//            return JsonResult.build(200,OperateEnum.FILE_UPLOAD_SUCCESS.getStateInfo(),IMAGE_BASE_URL+pathKey+filePath+"/"+newFileName);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return JsonResult.build(OperateEnum.FAILE);
//        }
//    }
//





        return null;
    }
}
