package com.maizhong.auction.channel;

import com.maizhong.auction.service.ChannelService;
import com.maizhong.auction.socket.SpringWebSocketHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.socket.TextMessage;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xushd on 2017/6/26.
 */
public class InitChannel implements ServletContextListener {

    public static Logger LOGGER = LoggerFactory.getLogger(InitChannel.class);

    private ChannelService channelService;



    private static int chNum = 10;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        channelService = context.getBean(ChannelService.class);

        LOGGER.info("-----开启轮训线程-----");

        //channelService.clearChannel(chNum);

        //channelService.createAuctionQueue(chNum);

        for (int i = 0; i < chNum; i++) {
            String channel = "CH"+i;
            Thread mThread = new Thread(new ThreadChanle(channel),channel);
            // 则当jvm只剩“守护线程”时(主线程结束)，该线程也会结束。
            mThread.setDaemon(true);
            // 开始线程
            mThread.start();
            LOGGER.info("开启通道轮训:{}",channel);
        }
        LOGGER.info("-----开启数据存储轮训线程-----");
        // 数据持久化进程
        Thread mDateSave = new Thread(new ThreadDataSave(),"datasave");
        // 则当jvm只剩“守护线程”时(主线程结束)，该线程也会结束。
        mDateSave.setDaemon(true);
        // 开始线程
        mDateSave.start();

        LOGGER.info("-----开启发送轮训线程-----");
        // 数据持久化进程
        Thread mSocket = new Thread(new ThreadSocket(),"socket");
        // 则当jvm只剩“守护线程”时(主线程结束)，该线程也会结束。
        mSocket.setDaemon(true);
        // 开始线程
        mSocket.start();


    }

    /**
     * 内部类线程类
     */
    class ThreadChanle implements Runnable {
        public ThreadChanle(String ch) {
            this.ch = ch;
        }
        private String ch;
        public void run() {
            while (true) {
                try {
                    //3s 间隔
                    TimeUnit.SECONDS.sleep(3);
                    channelService.pollingChannel(ch);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * 数据存储
     */
    class ThreadDataSave implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    channelService.dataSave();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * 消息推送
     */
    class ThreadSocket implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    channelService.sendSocket();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
