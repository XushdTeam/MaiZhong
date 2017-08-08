package com.maizhong.common.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
     *
     * @return
     */
    public static String getNowTime() {
        DateTime dateTime = new DateTime();
        return dateTime.toString(format_default);
    }

    /**
     * 获取当前数据的时间戳
     * @return
     */
    public static long getCurrentTime(){
        DateTime dateTime = new DateTime();
        return dateTime.getMillis();
    }
    /**
     * 获取前一天时间
     *
     * @param date
     * @return
     */
    public static String getFormatDateTime(DateTime date) {
        return date.toString(format_default_s);
    }

    public static String getFormatDateTime2(DateTime date) {
        return date.toString(format_default);
    }

    public static String getFormatDateTime3(Date date) {
        SimpleDateFormat format3 = new SimpleDateFormat(format_default);
        return format3.format(date);
    }
    public static String getFormatDateTimeShort(Date date) {
        SimpleDateFormat format3 = new SimpleDateFormat(format_default_s);
        return format3.format(date);
    }
    /**
     * 通过字符串获取Date
     *
     * @param time
     * @return
     */
    public static Date getDate(String time) {
        DateTime dateTime = DateTime.parse(time, format);
        return dateTime.toDate();
    }

    /**
     * Date => String
     * @param date
     * @param format
     * @return
     */
    public static String getFormatDateTime(Date date,String format){

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    /**
     * 获取当前时间后几分钟的时间戳
     * @param minutes
     * @return
     */
    public static long getOverTime(int minutes){
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMinutes(minutes);
        return dateTime.getMillis();
    }

    /**
     * 时间戳是否大于系统当前时间
     * @param time
     * @return
     */
    public static boolean compare(long time){
        if(time>new DateTime().getMillis())return true;
        return false;
    }

    /**
     * 获取时间戳与当前系统时间的差值
     * @param time
     * @return
     */
    public static long getDiff(long time){
        return (time - new DateTime().getMillis());
    }

    public static Date getDate2(String time) {
        DateTime dateTime = DateTime.parse(time, format2);
        return dateTime.toDate();
    }

    /**
     * 获取几天前的Date
     *
     * @param day
     * @return
     */
    public static Date getDateBefore(int day) {
        DateTime dateTime = new DateTime();
        return dateTime.minusDays(day).toDate();
    }

    public static String getDateBeforeDay(int day) {
        DateTime dateTime = new DateTime();
        return getFormatDateTime(dateTime.minusDays(day));
    }

    /**
     * 获取当前年
     *
     * @return
     */
    public static String getYear() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("yyyy");
    }

    /**
     * 获取当前月
     *
     * @return
     */
    public static String getMonth() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("MM");
    }

    /**
     * 获取当前日
     *
     * @return
     */
    public static String getDay() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("dd");
    }


}
