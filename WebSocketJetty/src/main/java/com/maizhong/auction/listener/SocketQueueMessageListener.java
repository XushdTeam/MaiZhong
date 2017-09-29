package com.maizhong.auction.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * socket 监听器
 * Created by Xushd on 2017/9/21.
 */
public class SocketQueueMessageListener implements MessageListener {


    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + tm.getText());


        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
