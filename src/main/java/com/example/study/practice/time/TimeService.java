package com.example.study.practice.time;

import com.example.study.Utils.DateUtil;
import org.springframework.util.StopWatch;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-18 11:01
 **/
public class TimeService {
    public static void main(String[] args) {

        //计算方法中各段执行的时间，并打印小型报表
        StopWatch stopWatch = new StopWatch("时间");
        stopWatch.start("第一个");

        Instant ttt = DateUtil.formatStartTime(System.currentTimeMillis());  //2020-12-17T16:00:00Z
        Instant act = ttt.plusMillis(86399000);//时间增加23:59:59
        Instant fdf = ttt.plusSeconds(86399);  //时间增加23:59:59
        Instant fgg = ttt.plusMillis(TimeUnit.HOURS.toMillis(8));//加8小时 2020-12-18T15:13:03.428Z

        try {
            System.out.println("----------------------------------Instant类型String转date");
            String dateTime = "2020-01-13T16:00:00.000Z";
            dateTime = dateTime.replace("Z", " UTC");
            System.out.println(dateTime);        //2020-01-13T16:00:00.000 UTC
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date time = simpleDateFormat.parse(dateTime);
            System.out.println(time);       //Tue Jan 14 00:00:00 CST 2020

            //DateFormat
            String timet = "2020/10/30 16:00:00";
            DateFormat formatf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//上转型
            Date tt = new Date(formatf.parse(timet).getTime());
            System.out.println(tt);
        } catch (Exception e) {
            System.out.println("----> Exception: " + e.toString());
            e.printStackTrace();
        }

        stopWatch.stop();
        stopWatch.start("第二个");

        //文本和日期相互转换
        try {
            System.out.println("----------------------------------文本和日期相互转换");
            String day = "2008年08月18日 20:07:33";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss", Locale.getDefault());
            Date date = simpleDateFormat.parse(day);
            System.out.println("----> 格式化后的日期为: " + date);

            String day1 = "2008-08-18 20:07:33";
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date date1 = simpleDateFormat.parse(day1);
            System.out.println("----> 格式化后的日期为: " + date1);

            String day3 = "20131227085009";
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
            Date date2 = simpleDateFormat.parse(day3);
            System.out.println("----> 格式化后的日期为: " + date2);

            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String time = simpleDateFormat.format(date2);
            System.out.println("----> 时间文本为: " + time);
//            ----> 格式化后的日期为: Mon Aug 18 20:07:33 CST 2008
//            ----> 格式化后的日期为: Mon Aug 18 20:07:33 CST 2008
//            ----> 格式化后的日期为: Fri Dec 27 08:50:09 CST 2013
//            ----> 时间文本为: 2013-12-27 08:50:09
        } catch (Exception e) {
            System.out.println("----> Exception: " + e.toString());
        }

        //时间和时间戳相互转换
        try {
            System.out.println("----------------------------------时间和时间戳相互转换");
            long timeStamp2 = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date date4 = new Date(timeStamp2);
            String time4 = simpleDateFormat5.format(date4);
            System.out.println("----> 当前时间戳为: " + timeStamp2 + " ,其字符串为:" + time4);
            Date parsedDate = simpleDateFormat5.parse(time4);
            long ts = parsedDate.getTime();
            System.out.println("----> 将字符串转换为时间戳: " + ts);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //T表示分隔符，Z表示的是UTC。
        //UTC：世界标准时间，在标准时间上加上8小时，即东八区时间，也就是北京时间。(Instant)
        Date date = new Date();//周月日时分秒年     Fri Dec 18 15:13:03 CST 2020
        //数据库的三种类都继承了java.util.Date，在除了数据库的情况下使用
        Date sDate = new java.sql.Date(date.getTime());//年月日   2020-12-18·
        Time sTime = new Time(sDate.getTime());        //时分秒   15:13:03
        Timestamp sTimeStamp = new Timestamp(sTime.getTime());     //年月日时分秒毫秒  2020-12-18 15:13:03.426
        Instant instant = Instant.now();                                  //UTC时间   2020-12-18T07:13:03.428Z
        Instant p = instant.plusMillis(TimeUnit.HOURS.toMillis(8));//加8小时 2020-12-18T15:13:03.428Z
        Long s = Instant.now().getEpochSecond(); //当前秒时间戳1608275583442
        LocalDateTime now = LocalDateTime.now();                                     //2020-12-18T15:13:03.442
        Long t = System.currentTimeMillis();    //当前毫秒时间戳1608275583442
        Calendar calender = Calendar.getInstance();//日历类是一个抽象基类
        //获取当前天的开始和结束时间(MySQL存储的数据格式：2020-06-20 17:45:04    可用Instant格式直接查询)
        Instant startTime = DateUtil.formatStartTime(System.currentTimeMillis());  //2020-12-17T16:00:00Z
        Instant endTime = DateUtil.formatEndTime(System.currentTimeMillis());      //2020-12-18T15:59:59Z

        System.out.println("===================================");
        System.out.println("Date:" + date);
        System.out.println("sql.Date:" + sDate);
        System.out.println("Time:" + sTime);
        System.out.println("Timestamp:" + sTimeStamp);
        System.out.println("Instant:" + instant);
        System.out.println("Instant:" + p);
        System.out.println("Instant:" + s);
        System.out.println("LocalDateTime:" + now);
        System.out.println("System.currentTimeMillis():" + t);
        System.out.println("Calendar:" + calender);
        System.out.println("今日开始时间:" + startTime);
        System.out.println("今日结束时间:" + endTime);
        System.out.println("===================================");

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
