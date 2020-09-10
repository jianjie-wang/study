package com.example.study.practice.time;

import com.example.study.Utils.DateUtil;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-18 11:01
 **/
public class TimeService {

    public static void main(String[] args) {
        Date date = new Date();//年月日时分秒     Tue Aug 18 17:31:07 CST 2020
        //数据库的三种类都继承了java.util.Date，在除了数据库的情况下使用
        Date sDate = new java.sql.Date(date.getTime());//年月日    2020-08-18
        Time sTime = new Time(sDate.getTime());//时分秒   17:31:07
        Timestamp sTimeStamp = new Timestamp(sTime.getTime());//年月日时分秒毫秒   2020-08-18 17:31:07.973
        Instant instant = Instant.now();//UTC时间     2020-08-18T09:31:07.977Z

        //当前毫秒时间戳
        Long t = System.currentTimeMillis();    //1597743067977

        //获取当前天的开始和结束时间(MySQL存储的数据格式：2020-06-20 17:45:04    可用Instant格式直接查询)
        Instant startTime = DateUtil.formatStartTime(System.currentTimeMillis());  //2020-08-17T16:00:00Z
        Instant endTime = DateUtil.formatEndTime(System.currentTimeMillis());

        //日历类是一个抽象基类
        Calendar calender = Calendar.getInstance();//

        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime:"+now);

        System.out.println("Date:"+date);
        System.out.println("sql.Date:"+sDate);
        System.out.println("Time:"+sTime);
        System.out.println("Timestamp:"+sTimeStamp);
        System.out.println("Calendar:"+calender);
        System.out.println("Instant:"+instant);
        System.out.println("System.currentTimeMillis():"+ t);
        System.out.println("今日开始时间:"+startTime);
        System.out.println("今日结束时间:"+endTime);


        //T表示分隔符，Z表示的是UTC。
        //UTC：世界标准时间，在标准时间上加上8小时，即东八区时间，也就是北京时间。(Instant)
        String dateTime = "2020-01-13T16:00:00.000Z";
        dateTime = dateTime.replace("Z", " UTC");
        System.out.println(dateTime);        //2020-01-13T16:00:00.000 UTC
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date time = format.parse(dateTime);
            System.out.println(time);      //Tue Jan 14 00:00:00 CST 2020
            String result = defaultFormat.format(time);
            System.out.println(result);   //打印： 2020-01-14 00:00:00
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
