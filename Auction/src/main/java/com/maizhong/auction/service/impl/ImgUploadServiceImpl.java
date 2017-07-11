package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.pojo.CkXsz;
import com.maizhong.auction.service.ImgUploadService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.Base64Img;
import com.maizhong.common.utils.FileUploadUtil;
import com.maizhong.common.utils.HttpUtils;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xushd on 2017/6/19.
 */
@Service
public class ImgUploadServiceImpl implements ImgUploadService {


    // aliOSS

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
            String[] split1 = split[0].split("/");
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

    @Override
    public JsonResult xszSb(String imgUrl) {

        String base64 = Base64Img.GetImageStrFromUrl(imgUrl);
        if(base64==null)return JsonResult.Error("图片有误");
        String host = "https://dm-53.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_vehicle.json";
        String method = "POST";
        String appcode = "7aa943b54aff495bbdec6c30aae1fb06";
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        JSONObject object=new JSONObject();
        JSONObject image=new JSONObject();
        image.put("dataType",50);
        image.put("dataValue",base64);
        JSONArray array=new JSONArray();
        JSONObject object1=new JSONObject();
        object1.put("image",image);
        array.add(object1);
        object.put("inputs",array);
        String bodys= JsonUtils.objectToJson(object);

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

            String result= EntityUtils.toString(response.getEntity());
            JSONObject resultObj = JSONObject.parseObject(result);

            JSONArray jsonArray = resultObj.getJSONArray("outputs");
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String jsonObjectString = jsonObject.getString("outputValue");
            JSONObject parseObject = JSONObject.parseObject(jsonObjectString);
            String dataValue = parseObject.getString("dataValue");
            JSONObject objDateValue = JSONObject.parseObject(dataValue);

            JSONObject returnObj = new JSONObject();

            returnObj.put("number",objDateValue.getString("plate_num"));
            returnObj.put("ppxh",objDateValue.getString("model"));
            returnObj.put("cjh",objDateValue.getString("vin"));
            returnObj.put("fdjh",objDateValue.getString("engine_num"));
            returnObj.put("lx",objDateValue.getString("vehicle_type"));
            returnObj.put("xz",objDateValue.getString("use_character"));

            return JsonResult.OK(returnObj);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return JsonResult.Error("图片有误");
    }
}
