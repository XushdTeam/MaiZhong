package com.maizhong.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.maizhong.common.enums.SMSTemplateEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 阿里 sms 工具
 * Created by Xushd on 2017/8/1.
 */
public class AliSMSUtils {


    public static boolean sendSMS(SMSTemplateEnum templateEnum, String verifyCode, String phone){
        /**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount("LTAIOG04oFWrylm9", "ecfETvISlI5yMoEAvJRfIl9pURN5Os", "http://1154794566719344.mns.cn-hangzhou.aliyuncs.com/");
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef("sms.topic-cn-hangzhou");
        /**
         * Step 2. 设置SMS消息体（必须）
         *
         * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        /**
         * Step 3. 生成SMS消息属性
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName(templateEnum.getName());
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(templateEnum.getCode());
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("name", templateEnum.getName());
        smsReceiverParams.setParam("code", verifyCode);
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver(phone, smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            /**
             * Step 4. 发布SMS消息
             */
            topic.publishMessage(msg, messageAttributes);
        } catch (Exception se) {
            client.close();
            return false;
        }
        client.close();
        return true;
    }

    public static boolean sendSMS2(SMSTemplateEnum templateEnum, String verifyCode, String phone,String operate){

        try {
            String host = "http://ali-sms.showapi.com";
            String path = "/sendSms";
            String method = "GET";
            String appcode = "8dc7c8b35fbf4f17b00bddb7d424c308";
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            JSONObject object = new JSONObject();
            object.put("name",operate + templateEnum.getName());
            object.put("code",verifyCode);
            object.put("time",2);
            //URLEncoder.encode(object.toJSONString(),"UTF-8")
            querys.put("content",object.toJSONString() );
            querys.put("mobile", phone);
            querys.put("tNum", templateEnum.getCode());

            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            String res = EntityUtils.toString(response.getEntity());

            JSONObject obj = JSONObject.parseObject(res);
            String retCode = obj.getJSONObject("showapi_res_body").getString("ret_code");
            if(StringUtils.equals("0",retCode))return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
