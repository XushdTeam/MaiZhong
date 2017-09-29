package com.maizhong.auction.dao.impl;

import com.maizhong.auction.dao.ActiveMqProducer;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * ActiveMq 消息
 * Created by Xushd on 2017/9/21.
 */
public class ActiveMqProducerImpl implements ActiveMqProducer {


    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    /**
     * 发送 mq 消息
     * @param destination
     * @param msg
     */
    @Override
    public void sendMessage(Destination destination, final String msg) {
        System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
