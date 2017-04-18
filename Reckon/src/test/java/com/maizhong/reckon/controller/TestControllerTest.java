package com.maizhong.reckon.controller;

import com.maizhong.reckon.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import static org.junit.Assert.*;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-17
 * Time: 16:23
 */

@Controller
public class TestControllerTest {

    @Autowired
    private TestService testService;
    @Test
    public void testReckon() throws Exception {
        testService.testService("sdaf");
    }

}