//package com.maizhong.auction.servlet;
//
//import nl.justobjects.pushlet.core.Event;
//import nl.justobjects.pushlet.core.EventPullSource;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by Xushd on 2017/6/13.
// */
//public class HelloWorldPlushlet {
//
//    static public class HwPlushlet extends EventPullSource {
//        // 休眠五秒
//        @Override
//        protected long getSleepTime() {
//            return 1000*60*10;
//        }
//        @Override
//        protected Event pullEvent() {
//            Event event = Event.createDataEvent("/cuige/he");
//
//            try {
//              while (true) {
//
//                        System.out.println("===========================================");
//
//                        event.setField("mess", "hello,world!Plushlet!");
//
//                        TimeUnit.SECONDS.sleep(1);
//
//
//
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return event;
//        }
//    }
//}
