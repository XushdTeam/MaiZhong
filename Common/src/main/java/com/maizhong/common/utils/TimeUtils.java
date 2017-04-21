package com.maizhong.common.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * show 时间工具类
 *
 * @author Xushd
 * @since 2017/1/17 0017 下午 10:02
 */
public class TimeUtils {

    private static final String format_default = "yyyy-MM-dd HH:mm:ss";
    private static final String format_default_s = "yyyy-MM-dd";
    private static final DateTimeFormatter format = DateTimeFormat.forPattern(format_default);
    private static final DateTimeFormatter format2 = DateTimeFormat.forPattern(format_default_s);
    /**
     * 获取当期时间 "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getNowTime(){
        DateTime dateTime = new DateTime();
        return dateTime.toString(format_default);
    }

    /**
     * 获取前一天时间
     * @param date
     * @return
     */
    public static String getFormatDateTime(DateTime date){
        return date.toString(format_default_s);
    }

    /**
     * 通过字符串获取Date
     * @param time
     * @return
     */
    public static Date getDate(String time){
        DateTime dateTime = DateTime.parse(time,format);
        return dateTime.toDate();
    }

    public static Date getDate2(String time){
        DateTime dateTime = DateTime.parse(time,format2);
        return dateTime.toDate();
    }

    /**
     * 获取几天前的Date
     * @param day
     * @return
     */
    public static Date getDateBefore(int day){
        DateTime dateTime = new DateTime();
        return dateTime.minusDays(day).toDate();
    }

    public static String getDateBeforeDay(int day){
        DateTime dateTime = new DateTime();
        return getFormatDateTime(dateTime.minusDays(day));
    }

    /**
     * 获取当前年
     * @return
     */
    public static String getYear(){
        DateTime dateTime = new DateTime();
        return dateTime.toString("yyyy");
    }
    /**
     * 获取当前月
     * @return
     */
    public static String getMonth(){
        DateTime dateTime = new DateTime();
        return dateTime.toString("MM");
    }
    /**
     * 获取当前日
     * @return
     */
    public static String getDay(){
        DateTime dateTime = new DateTime();
        return dateTime.toString("dd");
    }


}
