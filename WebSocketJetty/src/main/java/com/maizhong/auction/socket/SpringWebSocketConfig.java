package com.maizhong.auction.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;



/**
 * Created by Xushd on 2017/6/26.
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class SpringWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    @Autowired
    private SpringWebSocketHandler springWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(springWebSocketHandler,"/websocket/socketServer").addInterceptors(new HandShake()).setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(springWebSocketHandler, "/websocket/sockjs").addInterceptors(new HandShake()).withSockJS();
    }
}
