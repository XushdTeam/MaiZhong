package com.maizhong.auction.socket;

import com.maizhong.auction.service.impl.ChannelServiceImpl;
import com.maizhong.common.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by Xushd on 2017/6/26.
 */
@Component
public class SpringWebSocketHandler implements WebSocketHandler {


    public static Logger LOGGER = LoggerFactory.getLogger(SpringWebSocketHandler.class);

    public static final Map<String, WebSocketSession> userSocketSessionMap;

    static {
        userSocketSessionMap = new HashMap<String, WebSocketSession>();
    }


    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        String ch = (String) session.getAttributes().get("ch");
        if(StringUtils.isNotBlank(ch)){
            String userId= IDUtils.getOrderId()+ch;
            if (userSocketSessionMap.get(userId) == null) {
                userSocketSessionMap.put(userId, session);
                LOGGER.info("通道 {} userId {}  Time {}",ch,userId,new Date());
            }
        }


    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        webSocketSession.sendMessage(webSocketMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if (webSocketSession.isOpen()) {
            webSocketSession.close();
        }
        Iterator<Map.Entry<String, WebSocketSession>> it = userSocketSessionMap
                .entrySet().iterator();
        // 移除Socket会话
        while (it.hasNext()) {
            Map.Entry<String, WebSocketSession> entry = it.next();
            if (entry.getValue().getId().equals(webSocketSession.getId())) {
                userSocketSessionMap.remove(entry.getKey());
                LOGGER.info("Socket会话已经移除:用户ID {} Time {}",entry.getKey(),new Date());
                break;
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
       
        Iterator<Map.Entry<String, WebSocketSession>> it = userSocketSessionMap
                .entrySet().iterator();
        // 移除Socket会话
        while (it.hasNext()) {
            Map.Entry<String, WebSocketSession> entry = it.next();
            if (entry.getValue().getId().equals(webSocketSession.getId())) {
                userSocketSessionMap.remove(entry.getKey());
                LOGGER.info("Socket会话已经移除:用户ID {} Time {}",entry.getKey(),new Date());
                break;
            }
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }



    /**
     * 给所有在统一通道的用户发送消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessageToCH(final TextMessage message,String ch) throws IOException {
        Iterator<Map.Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();

        // 多线程群发
        while (it.hasNext()) {
            final Map.Entry<String, WebSocketSession> entry = it.next();
            if (entry.getValue().isOpen() && entry.getKey().contains(ch)) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            if (entry.getValue().isOpen()) {
                                entry.getValue().sendMessage(message);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
}
