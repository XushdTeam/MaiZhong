//package com.maizhong.auction.comet;
////
////import org.comet4j.core.CometContext;
////import org.comet4j.core.CometEngine;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created by Xushd on 2017/6/9.
// */
//public class TestCometTime implements ServletContextListener {
//
//    // 频道1
//    private static final String CHANNEL1 = "timer";
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
////        // CometContext ： Comet4J上下文，负责初始化配置、引擎对象、连接器对象、消息缓存等。
////        CometContext cc = CometContext.getInstance();
////
////        // 注册频道，即标识哪些字段可用当成频道，用来作为向前台传送数据的“通道”
////        cc.registChannel(CHANNEL1);
////
////        Thread myThread = new Thread(new SendToClientThread(),"SendToClientThread");
////        // 下面的内部类的方法是个死循环，设置helloAppModule线程为“守护线程”，则当jvm只剩“守护线程”时(主线程结束)，该线程也会结束。
////        myThread.setDaemon(true);
////        // 开始线程
////        myThread.start();
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//
//    }
//
//    /**
//     * 内部类线程类
//     */
//    class SendToClientThread implements Runnable {
//        public void run() {
//            while (true) {
////                try {
////                    Thread.sleep(1000);
////                } catch (Exception ex) {
////                    ex.printStackTrace();
////                }
////
////                // CometEngine ： 引擎，负责管理和维持连接，并能够必要的发送服务
////                CometEngine engine = CometContext.getInstance().getEngine();
////
////                //设置日期格式
////                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////                // new Date()为获取当前系统时间
////                String strDate=df.format(new Date());
////
////                // 参数的意思：通过什么频道（CHANNEL1）
////                // 发送什么数据（number1++），
////                // 前台可用可用频道的值（result1）来获取某频道发送的数据
////                engine.sendToAll(CHANNEL1, strDate);
//            }
//        }
//    }
//}
