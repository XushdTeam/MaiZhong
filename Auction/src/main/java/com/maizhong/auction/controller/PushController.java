package com.maizhong.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class PushController {



    @RequestMapping("/push")
    public void getDate(HttpServletResponse response, HttpServletRequest request){


        OutputStream bos = null;
        try {
            Date date = new Date();
            String result = "data:"+date.toString()+"\n\n";
            response.setContentType("text/event-stream");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(result);//这里需要两个\n
            writer.flush();

            TimeUnit.SECONDS.sleep(5);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{

        }

    }

}
