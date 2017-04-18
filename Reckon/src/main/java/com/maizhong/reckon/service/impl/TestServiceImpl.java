package com.maizhong.reckon.service.impl;
import com.maizhong.reckon.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-17
 * Time: 13:32
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testService(String test) {
        System.out.println("---"+test);
        return test+" ddddd";
    }
}
