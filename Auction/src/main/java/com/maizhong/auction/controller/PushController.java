package com.maizhong.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class PushController {



    @RequestMapping("/push")
    public void getDate(HttpServletResponse response,
                        HttpServletRequest request){

        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        boolean isOver = true;
        try {
            while (isOver){
                PrintWriter writer = response.getWriter();
                Date date = new Date();
                String result = "data:"+date.toString()+"\n\n";
                writer.write(result);//这里需要两个\n
                writer.flush();
                System.out.println("-------任务执行 "+date.toString()+"--------");
                TimeUnit.SECONDS.sleep(5);
            }
        }catch (Exception e){

            e.printStackTrace();
        }




    }

}
