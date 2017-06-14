//package com.maizhong.auction.comet;
//
//import com.maizhong.auction.service.ChannelService;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//
////import org.comet4j.core.CometContext;
////import org.comet4j.core.CometEngine;
//
///**
// * Created by Xushd on 2017/6/9.
// */
//public class TestComet implements ServletContextListener {
//
//
//    // 频道个数
//    private static final int CHANNEL_NUM = 10;
//
//
//    private ChannelService channelService;
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//
//
////        ServletContext servletContext = servletContextEvent.getServletContext();
////        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(
////                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
////
////        //initialize service when spring context initialized,
////        //建立对应的service当spring上下文初始化之后
////        //使用spring框架中已经初始化的channelService
////        channelService = context.getBean(ChannelService.class);
////
////        // CometContext ： Comet4J上下文，负责初始化配置、引擎对象、连接器对象、消息缓存等。
////        CometContext cc = CometContext.getInstance();
////
////
////        for (int i = 1; i <= CHANNEL_NUM; i++) {
////            String ch = "CH"+i;
////            channelService.createChannel(ch);
////            // 注册频道，即标识哪些字段可用当成频道，用来作为向前台传送数据的“通道”
////            cc.registChannel(ch);
////            Thread mThread = new Thread(new ThreadChanle(ch),ch);
////            // 则当jvm只剩“守护线程”时(主线程结束)，该线程也会结束。
////            mThread.setDaemon(true);
////            // 开始线程
////            mThread.start();
////
////        }
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
//    class ThreadChanle implements Runnable {
//        public ThreadChanle(String ch) {
//            this.ch = ch;
//        }
//        private String ch;
//        public void run() {
//            while (true) {
////                try {
////                    Thread.sleep(5000);
////                } catch (Exception ex) {
////                    ex.printStackTrace();
////                }
////                String message = channelService.getMessage(ch);
////                PriceDto dto = JsonUtils.jsonToPojo(message,PriceDto.class);
////                // CometEngine ： 引擎，负责管理和维持连接，并能够必要的发送服务
////                CometEngine engine = CometContext.getInstance().getEngine();
////                JSONObject obj = new JSONObject();
////                obj.put("p",dto.getNowPrice());
////                obj.put("d",new Date());
////                engine.sendToAll(ch,obj.toJSONString());
//
//            }
//        }
//    }
//
//}
