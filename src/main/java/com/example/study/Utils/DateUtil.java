/**
 *
 */
package com.example.study.Utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author huangxm
 */
public class DateUtil {

    public static String getCurrentStr(String fromate) {

        SimpleDateFormat sf = new SimpleDateFormat(fromate);
        return sf.format(new Date());
    }

    public static String addMinute(String date, int minute, String fromate) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat(fromate);
        Date dates = sf.parse(date);

        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(dates);
        nowTime.add(Calendar.MINUTE, minute);

        return sf.format(nowTime.getTime());
    }

    /**
     * @return
     */
    public static Date nextYear() {

        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
        Date date = curr.getTime();
        return date;
    }

    /**
     * @return java.lang.String
     * @Description 格式化日期为字符串
     * @Date 2019/9/18
     * @Param [date, formate]
     **/
    public static String formate(Date date, String formate) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(date);
    }

    /**
     * @return java.util.Date
     * @Description 字符串转日期
     * @Date 2019/9/18
     * @Param [date, formate]
     **/
    public static Date stringToDate(String date, String formate) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public static Date getCurretDate() {
        return new Date();
    }

    /**
     * 秒数加减
     * @param date
     * @param num
     * @return
     */
    public static Date addSecond(Date date, int num) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(date);
        nowTime.add(Calendar.SECOND, num);
        return nowTime.getTime();
    }

    public static Date addMinute(Date date, int num) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(date);
        nowTime.add(Calendar.MINUTE, num);
        return nowTime.getTime();
    }

    public static Date addHour(Date date, int num) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(date);
        nowTime.add(Calendar.HOUR, num);
        return nowTime.getTime();
    }

    public static Date addMonth(Date date, int num) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(date);
        nowTime.add(Calendar.MONTH, num);
        return nowTime.getTime();
    }

    /**
     * @return java.util.Date
     * @Description 在日期上加上几天(传负减少)
     * @Date 2019/9/18
     * @Param [date, num]
     **/
    public static Date addDay(Date date, int num) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(date);
        nowTime.add(Calendar.DATE, num);
        return nowTime.getTime();
    }

    /**
     * 比较日期大小
     * date1 > date2  为1
     * date1 = date2  为0
     * date1 < date2  为-1
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compare(Date date1, Date date2) {
        try {

            if (date1.getTime() > date2.getTime()) {
                return 1;
            } else if (date1.getTime() < date2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static Date getLastMonth() {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        return date;
    }


    /**
     * 显示时间，如果与当前时间差别小于一天，则自动用**秒(分，小时)前，如果大于一天则用format规定的格式显示
     *
     * @param ctime  时间
     * @param format 格式 格式描述:例如:yyyy-MM-dd yyyy-MM-dd HH:mm:ss
     * @return
     * @author wxy
     */
    public static String showTimeStyle(Date ctime, String format) {
        // System.out.println("当前时间是："+new Timestamp(System.currentTimeMillis()));

        // System.out.println("发布时间是："+df.format(ctime).toString());
        String r = "";
        if (ctime == null)
            return r;
        if (format == null)
            format = "MM-dd HH:mm";

        long nowtimelong = System.currentTimeMillis();

        long ctimelong = ctime.getTime();
        long result = Math.abs(nowtimelong - ctimelong);

        if (result < 60000) {// 一分钟内
            long seconds = result / 1000;
            if (seconds == 0) {
                r = "刚刚";
            } else {
                r = seconds + "秒前";
            }
        } else if (result >= 60000 && result < 3600000) {// 一小时内
            long seconds = result / 60000;
            r = seconds + "分钟前";
        } else if (result >= 3600000 && result < 86400000) {// 一天内
            long seconds = result / 3600000;
            r = seconds + "小时前";
        } else if (result >= 86400000 && result < 1702967296) {// 三十天内
            long seconds = result / 86400000;
            r = seconds + "天前";
        } else {// 日期格式
            format = "MM-dd HH:mm";
            SimpleDateFormat df = new SimpleDateFormat(format);
            r = df.format(ctime).toString();
        }
        return r;
    }

    /**
     * @return int
     * @Author liujie
     * @Description 获取年龄
     * @Date 2019/9/11
     * @Param [birthDay]
     **/
    public static Integer getAgeByBirth(Date birthDay) throws ParseException {
        int age = 0;
        if (birthDay == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }

    public static Integer mistimingDay(Date date) {
        if (date == null) {
            return null;
        }
        long a = date.getTime() - System.currentTimeMillis();
        long b = a / (24 * 60 * 60 * 1000);
        if (b < 0) {
            return null;
        }
        return Math.toIntExact(b + 1);
    }

    /**
     * @return java.util.Date
     * @Author liujie
     * @Description 获取本周第一天
     * @Date 2019/9/18
     * @Param []
     **/
    public static Date getWeekStartDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();
        return date;
    }

    /**
     * @return java.util.List<java.lang.String>
     * @Author liujie
     * @Description 获取两个时间的单个天数集合
     * egg:"2019-09-10", "2019-09-18"
     * return:[2019-09-10, 2019-09-11, 2019-09-12, 2019-09-13, 2019-09-14, 2019-09-15, 2019-09-16, 2019-09-17, 2019-09-18]
     * @Date 2019/9/18
     * @Param [startTime, endTime]
     **/
    public static List<String> everySingleDay(String startTime, String endTime, Integer num) {
        List<String> list = new ArrayList<>();
        if (startTime.equals(endTime)) {
            list.add(startTime);
            return list;
        }
        list.add(startTime);
        String format = "yyyy-MM-dd";
        String newDay = formate(addDay(stringToDate(startTime, format), num), format);
        recursionDay(list, newDay, endTime, num);
        return list;
    }

    private static void recursionDay(List<String> list, String startTime, String endTime, Integer num) {
        String format = "yyyy-MM-dd";
        Date startTimeDate = stringToDate(startTime, format);
        Date endTimeDate = stringToDate(endTime, format);
        int compare = compare(startTimeDate, endTimeDate);
        if (compare == 0) {
            list.add(startTime);
            return;
        } else if (compare > 0) {
            list.add(endTime);
            return;
        } else {
            list.add(startTime);
        }

        recursionDay(list, formate(addDay(stringToDate(startTime, format), num), format), endTime, num);
    }

    public static List<String> everySingleDay(Date start, Date end, Integer num) {
        String format = "yyyy-MM-dd";
        String startTime = formate(start, format);
        String endTime = formate(end, format);
        return everySingleDay(startTime, endTime, num);
    }

    /**
     * @return java.util.Date
     * @Author liujie
     * @Description 获取传入时间第一天
     * @Date 2019/8/12
     * @Param [date]
     **/
    public static Date getFirstDayDateOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * @return java.util.Date
     * @Author liujie
     * @Description 获取传入时间最后一天
     * @Date 2019/8/12
     * @Param [date]
     **/
    public static Date getLastDayOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * 格式化开始时间时间戳
     * @param startTime
     * @return
     */
    public static Instant formatStartTime(Long startTime) {
        return stringToDate(formate(new Date(startTime), "yyyy-MM-dd") + " 00:00:00", "yyyy-MM-dd HH:mm:ss").toInstant();
    }

    /**
     * 格式化结束时间时间戳
     * @param endTime
     * @return
     */
    public static Instant formatEndTime(Long endTime) {
        return stringToDate(formate(new Date(endTime), "yyyy-MM-dd") + " 23:59:59", "yyyy-MM-dd HH:mm:ss").toInstant();
    }

    public static String formatStartTimeString(Long startTime) {
        return formate(new Date(startTime), "yyyy-MM-dd") + " 00:00:00";
    }

    public static String formatEndTimeString(Long endTime) {
        return formate(new Date(endTime), "yyyy-MM-dd") + " 23:59:59";
    }

    /**
     *活动持续时间
     * @param start
     * @param end
     * @return
     */
    public static Integer durationTime(Instant start, Instant end) {
        if (start == null || end == null) return 0;

        Instant now = Instant.now();

        if (now.compareTo(start) <= 0) {
            return 0;
        } else if (now.compareTo(end) > 0) {
            Duration between = Duration.between(start, end);
            Long l = between.toDays();
            return l.intValue() + 1;
        } else {
            Duration between = Duration.between(start, now);
            Long l = between.toDays();
            return l.intValue() + 1;
        }
    }

    /**
     * 获取当天23:59:59时间
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取传入时间距离当天末秒数
     * @return
     */
    public static int distanceDate(Date date) {
        Date endOfDay = getEndOfDay(date);
        //毫秒
        long millisecond = endOfDay.getTime() - date.getTime();
        return (int) (millisecond / 1000);
    }

    public static void main(String[] args) {
        String format = "yyyy-MM-dd HH:mm:ss";

        //计算两个时间相差多少天
//        Integer integer = durationTime(DateUtil.stringToDate("2020-02-26 11:20:56", format).toInstant(), new Date().toInstant());
//        System.out.println(integer);


//		try {
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			System.out.println(showTimeStyle(df.parse("2017-08-11 19:31:00"), "yyyy-MM-dd HH:mm:ss"));
//		} catch (Exception e) {
//		}
        //得到两个时间内的天数集合
//        List<String> strings = everySingleDay("2019-09-10", "2019-12-18",7);
//        System.out.println(strings);


    }


}
