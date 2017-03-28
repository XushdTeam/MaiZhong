package com.maizhong.bRest.controlloer;

import com.maizhong.bRest.service.UserService;
import com.maizhong.common.result.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by YangF on 2017/3/28.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/login")
    public JsonResult login(@RequestParam("username") String username,@RequestParam("password") String password){



        return null;
    }


    @RequestMapping("/online")
    public JsonResult isOnline(@RequestParam("token") String token){
        return null;
    }



}
