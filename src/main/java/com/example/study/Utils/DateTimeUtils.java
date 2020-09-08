package com.example.study.Utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeUtils {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final int MILLI_SECOND = 1;
    private static final int SECOND = 1000 * MILLI_SECOND;// 1000ms
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    public static final String OVERDUE = "OVERDUE";
    public static final String TODAY_OVERDUE = "TODAY";
    public static final String FUTURE = "FUTURE";

    public static final String[] WEEK_NAME = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    public static final String[] DAY_NAME = {"昨天 ", "", "明天 ", "后天 "};
    public static final String[] WEEK_NAME_PRE = {"上", "", "下"};

    public static String getDisplayTime(long time) {
        return getDisplayTime(new Date(), new Date(time));
    }

    public static String getDisplayTime(Date now, Date date) {
        if (date == null) return null;
        //date的时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //当前的时间
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(now);

        //时间间隔判断
        //非同一年
        if (calNow.get(Calendar.YEAR) != cal.get(Calendar.YEAR)) {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
        }

        String hourMinute = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date);
        int diffDay = cal.get(Calendar.DAY_OF_YEAR) - calNow.get(Calendar.DAY_OF_YEAR);
        if (0 <= diffDay && diffDay <= 1) { //相差一天内
            return DAY_NAME[diffDay + 1]
                    .concat(hourMinute);
        }
        if (diffDay == 2) {
            return DAY_NAME[diffDay + 1]
                    .concat(hourMinute);
        }

        int diffWeek = cal.get(Calendar.WEEK_OF_YEAR) - calNow.get(Calendar.WEEK_OF_YEAR);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) diffWeek--;
        if (calNow.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) diffWeek++;
        if (0 <= diffWeek && diffWeek <= 1 && diffDay >= 0) {
            return WEEK_NAME_PRE[diffWeek + 1]
                    .concat(WEEK_NAME[cal.get(Calendar.DAY_OF_WEEK) - 1])
                    .concat(" ")
                    .concat(hourMinute);
        }
        return new SimpleDateFormat("MM月dd日", Locale.getDefault()).format(date);

        //        long dif = calNow.getTime().getTime() - date.getTime();
        //        if (dif < MINUTE * 15) {
        //            //15分钟内
        //            return "刚刚";
        //        } else if (dif < HOUR) {
        //            //1小时内
        //            return (dif / MINUTE) + "分钟前";
        //        } else if (dif < HOUR * 3) {
        //            //3小时内
        //            return (dif / HOUR) + "小时前";
        //        } else if (dif < DAY) {
        //            //当天3小时外
        //            return new SimpleDateFormat("H:s", Locale.getDefault()).format(date);
        //        }
        //        return "";
    }

    /**
     * 得到今天开始时间
     */
    public static Long getBeginOfDay(long time) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(time));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 得到三小时后的时间
     */
    public static Long getTimeAfterThreeHours() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 3);
        return calendar.getTime().getTime();
    }

    /**
     * 得到今天结束的时间
     */
    public static Long getEndOfToday() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 得到今天开始的时间
     */
    public static Long getBeginOfToday() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 得到明天结束的时间
     */
    public static Long getEndOfTomorrow() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 得到本周工作日结束的时间
     */
    public static Long getEndOfLastWorkDayInThisWeek() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);

        calendar.add(Calendar.DATE, 4);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime().getTime();
    }

    /**
     * 得到本周周末结束的时间
     */
    public static Long getEndOfWeekend() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);

        calendar.add(Calendar.DATE, 6);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime().getTime();
    }

    /**
     * 得到一周后的时间
     */
    public static Long getTimeAfterWeek() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);

        calendar.add(Calendar.DATE, 9);
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime().getTime();
    }

    public static String[] getTimeString(long dueTime) {
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        if (dueTime <= getBeginOfToday()) {//逾期
            return new String[]{OVERDUE, getDueTimeString(now, new Date(dueTime))};
        } else if (dueTime < calendar.getTime().getTime()) { //今天内逾期
            return new String[]{TODAY_OVERDUE, "逾期不到 1 天"};
//            return new String[]{
//                    TODAY_OVERDUE, new SimpleDateFormat("HH:mm", Locale.getDefault()).format(dueTime)
//            };
        } else {
            return new String[]{FUTURE, getDisplayTime(now, new Date(dueTime))};
        }
    }

    public static String getDueTimeString(Date nowDate, Date dueDate) {

        if (dueDate == null) return null;
        //date的时间
        Calendar due = Calendar.getInstance();
        due.setTime(dueDate);
        //当前的时间
        Calendar now = Calendar.getInstance();
        now.setTime(nowDate);

        //先判断年
        if (now.get(Calendar.YEAR) > due.get(Calendar.YEAR)) {//跨年
            int diffYear = now.get(Calendar.YEAR) - due.get(Calendar.YEAR); // 1、2、3
            if (now.get(Calendar.MONTH) < due.get(Calendar.MONTH) ||
                    (now.get(Calendar.MONTH) == due.get(Calendar.MONTH)
                            && now.get(Calendar.DAY_OF_MONTH) < due.get(Calendar.DAY_OF_MONTH))) {//跨年但不足一年
                int diffMonth = 12 - due.get(Calendar.MONTH) + now.get(Calendar.MONTH);//月数差
                if (now.get(Calendar.DAY_OF_MONTH) < due.get(Calendar.DAY_OF_MONTH)) {
                    diffMonth--;
                }
                if (diffMonth > 0) {
                    return "逾期 " + diffMonth + " 月";
                } else {
                    long timeDistance = getTimeDistance(dueDate, nowDate);
                    if (timeDistance >= 7) {
                        return "逾期 " + timeDistance / 7 + " 周";
                    } else {
                        return "逾期 " + timeDistance + " 天";
                    }
                }
            } else {
                return "逾期 " + diffYear + " 年";
            }
        } else {//不跨年

            //判断月
            int diffMonth = now.get(Calendar.MONTH) - due.get(Calendar.MONTH);
            if (now.get(Calendar.DAY_OF_MONTH) < due.get(Calendar.DAY_OF_MONTH)) {
                diffMonth--;
            }
            if (diffMonth > 0) return "逾期 " + diffMonth + " 月";

            //判断周
            int diffWeek = now.get(Calendar.WEEK_OF_YEAR) - due.get(Calendar.WEEK_OF_YEAR);
            if (now.get(Calendar.DAY_OF_WEEK) < due.get(Calendar.DAY_OF_WEEK)) {
                diffWeek--;
            }
            if (diffWeek > 0) return "逾期 " + diffWeek + " 周";

            //判断日
            long big = now.getTime().getTime();
            long small = due.getTime().getTime();
            int diffDay = (int) ((big - small) / (1000 * 60 * 60 * 24));
            diffDay = diffDay == 0 ? 1 : diffDay;//避免相差不到一天的情况

            return "逾期 " + diffDay + " 天";
        }
    }

    public static int getTimeDistance(Date beginDate, Date endDate) {
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));//先算出两时间的毫秒数之差大于一天的天数

        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);//使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);//再使endCalendar减去1天
        if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH))//比较两日期的DAY_OF_MONTH是否相等
            return betweenDays + 1;    //相等说明确实跨天了
        else
            return betweenDays;    //不相等说明确实未跨天
    }

    public static ZonedDateTime dateTimeToZonedDataTime(String datatime) {
        if (StringUtils.isNotEmpty(datatime)) {

            DateTimeFormatter format = DateTimeFormatter
                    .ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime leaving = LocalDateTime.parse(datatime, format);

            // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.

            ZoneId leavingZone = ZoneId.systemDefault();

            ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);
            return departure;
        }
        return null;
    }

    public static ZonedDateTime convertToZonedDateTime(Long value) {
        Timestamp tm = new Timestamp(value);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(tm.toInstant(), ZoneOffset.UTC);
        return zdt;
    }

    public static Long convertToTimestamp(ZonedDateTime value) {
        return value.toEpochSecond();
    }

    public static String ofPatternToSecond(Instant instant) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        .withLocale(Locale.CHINA)
                        .withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

}
