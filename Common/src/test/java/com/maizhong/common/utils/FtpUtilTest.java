package com.maizhong.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by Xushd on 2017/3/2.
 */
public class FtpUtilTest {

    @org.junit.Test
    public void uploadFile() throws Exception {

        try {
            FileInputStream in=new FileInputStream(new File("F:\\156.jpg"));
            boolean flag = FtpUtil.uploadFile("192.168.3.190", 21, "ftpuser", "123456", "/images","/2015/01/21", "156.jpg", in);
            System.out.println(flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}