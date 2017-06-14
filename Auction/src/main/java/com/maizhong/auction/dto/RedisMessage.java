package com.maizhong.auction.dto;

import java.util.Date;

/**
 * redis消息类
 * Created by Xushd on 2017/6/8.
 */
public class RedisMessage {

    private int msgId;

    private String msgContent;

    private Date msgDate;

    public RedisMessage() {
    }

    public RedisMessage(int msgId, String msgContent, Date msgDate) {
        this.msgId = msgId;
        this.msgContent = msgContent;
        this.msgDate = msgDate;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }
}
