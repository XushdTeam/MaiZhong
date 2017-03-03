package com.maizhong.common.result;

import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.enums.OperateEnum;

/**
 * 自定义Json 返回对象
 * Created by Xushd on 2017/2/28.
 */
public class JsonResult {

    //响应状态
    private Integer status;

    //响应消息
    private String message;

    //响应中的数据
    private Object data;


    public static JsonResult build(Integer status, String message, Object data){
        return new JsonResult(status, message, data);
    }

    public static JsonResult Error(String message){
        return new JsonResult(500,message,null);
    }

    public static JsonResult Error(OperateEnum result){
        return new JsonResult(result.getState(),result.getStateInfo(),null);
    }

    public static JsonResult build(OperateEnum result){
        if (result.getState()==200){
            return new JsonResult(200,result.getStateInfo(),null);
        }else{
            return new JsonResult(500,result.getStateInfo(),null);
        }
    }
    public static JsonResult build(AuthEnum result){
        if (result.getState()==200){
            return new JsonResult(200,result.getStateInfo(),null);
        }else{
            return new JsonResult(500,result.getStateInfo(),null);
        }
    }


    public static JsonResult OK(){
        return new JsonResult(null);
    }
    public static JsonResult OK(String message){
        return new JsonResult(200,message,null);
    }

    public static JsonResult OK(Object data){
        return new JsonResult(data);
    }

    public JsonResult(Object data) {
        this.status = 200;
        this.message ="OK";
        this.data = data;
    }

    public JsonResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public JsonResult() {

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
