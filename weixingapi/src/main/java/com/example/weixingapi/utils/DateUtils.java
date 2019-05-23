package com.example.weixingapi.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

/**
 * 描述：日期工具类
 * 修改人：zhaopengfei
 * 修改时间：2018/4/24
 */
@Slf4j
public class DateUtils {
    private DateUtils() {
    }

    public static final int NEXT_DAY = 5;
    public final static String DEFAULT_YEAR_FORMAT = "yyyy";
    public final static String DEFAULT_MONTH_FORMAT = "yyyy-MM";
    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//--格式化日期start-----------------------------------------

    /**
     * 格式化日期,返回格式为 HH:mm:ss 例:12:24:24
     *
     * @param date 日期
     * @return
     */
    public static String formatAsTime(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 yyyy-MM-dd
     *
     * @param date 日期
     * @return
     */
    public static String formatAsDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return
     */
    public static String formatAsDateTime(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 dd ,即对应的天数.
     *
     * @param date 日期
     * @return
     */
    public static String formatAsDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd");
        return df.format(date);
    }

    /**
     * 根据传入的格式格式化日期.默认格式为MM月dd日
     *
     * @param d 日期
     * @param f 格式
     * @return
     */
    public static String format(Date d, String f) {
        Date date = d;
        String format = f;
        if (date == null) {
            date = new Date();
        }
        if (format == null) {
            format = DATE_TIME_FORMAT;
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }


    //--格式化日期end-----------------------------------------

    //--解析日期start-----------------------------------------

    /**
     * 将字符转换成日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date parse(String dateStr, String format) {
        Date date = null;
        SimpleDateFormat sdateFormat = new SimpleDateFormat(format);
        sdateFormat.setLenient(false);
        try {
            date = sdateFormat.parse(dateStr);

        } catch (Exception e) {
            log.info("DateUtils error {} ", e);
        }
        return date;
    }


//    /**
//     * 将string类型解析为日期类型
//     *
//     * @param dateStr
//     * @param format  需要解析的格式
//     * @return
//     */
//    public static Date toDate(String dateStr, String format) {
//        SimpleDateFormat df = new SimpleDateFormat(format);
//        try {
//            return df.parse(dateStr);
//        } catch (ParseException e) {
//            return new Date();
//        }
//    }

    /**
     * 根据传入的String返回对应的date
     *
     * @param dateString
     * @return
     */
    public static Date parseAsDate(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 按给定参数返回Date对象
     *
     * @param dateTime 时间对象格式为("yyyy-MM-dd HH:mm:ss");
     * @return
     */
    public static Date parseAsDateTime(String dateTime) {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpledateformat.parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
    }

    //获取当天的开始时间
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    //获取当天的结束时间
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取指定日期的开始时间
     * 如：00:00:00
     *
     * @param value
     * @return
     */
    public static Date getDate0000(Date value) {
        LocalDateTime today_start = LocalDateTime.of(DateUtils.date2LocalDate(value), LocalTime.MIN);
        return DateUtils.localDateTime2Date(today_start);
    }

    /**
     * 获取指定日期的结束时间
     * 如：23:59:59
     *
     * @param value
     * @return
     */
    public static Date getDate2359(Date value) {
        LocalDateTime date_end = LocalDateTime.of(DateUtils.date2LocalDate(value), LocalTime.MAX);
        return DateUtils.localDateTime2Date(date_end);
    }


    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        return Date.from(zdt.toInstant());
    }

    /***
     * 获得今天的指定时间点
     * @param time 格式为"HH:mm:ss"
     * @return
     */
    public static Date getTodayTime(String time) {
        return getDateTime(new Date(), time);
    }

    /***
     *获得日期的指定时间点
     * @param date
     * @param time  格式为"hh:mm:ss"
     * @return
     */
    public static Date getDateTime(Date date, String time) {
        SimpleDateFormat simpledateformat = new SimpleDateFormat(
                "HH:mm:ss");
        try {
            Date parse = simpledateformat.parse(time);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(parse);

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);

            calendar2.set(Calendar.HOUR_OF_DAY, calendar1.get(Calendar.HOUR_OF_DAY));
            calendar2.set(Calendar.MINUTE, calendar1.get(Calendar.MINUTE));
            calendar2.set(Calendar.SECOND, calendar1.get(Calendar.SECOND));
            calendar2.set(Calendar.MILLISECOND, 0);
            return calendar2.getTime();
        } catch (ParseException e) {

        }
        return null;
    }
    //--解析日期 end-----------------------------------------


    /**
     * Date转换为LocalDateTime
     *
     * @param date
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        if (date == null) {
            return LocalDateTime.now();
        }
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 日期转 LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        if (date == null) {
            return LocalDate.now();
        }
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 日期转 LocalTime
     *
     * @param date
     * @return
     */
    public static LocalTime date2LocalTime(Date date) {
        if (date == null) {
            return LocalTime.now();
        }
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        return instant.atZone(zoneId).toLocalTime();
    }

    //-计算日期 start------------------------------------------

    /**
     * 得到当前时间前一天的时间
     *
     * @return
     */
    public static String getForwardDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    //当前时间下一天的时间
    public static String getNextDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 得到本月的日期
     *
     * @return
     */
    public static String getForwardMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(cal.getTime());

    }

    //得到当前月
    public static String getNowMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(cal.getTime());

    }


    /**
     * 给定日期后增加多少天后的日期
     *
     * @param date 日期
     * @param days 天数
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(date);
            cal.add(Calendar.DATE, days);

        } catch (Exception e) {
            // log.info("DateUtils error {} ", e);
        }
        return cal.getTime();

    }

    /**
     * 检测给定的日期是否在指定的时间内
     *
     * @param date      日期
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static boolean isDateInRange(Date date, Date startDate, Date endDate) {
        if (null == date || null == startDate || null == endDate) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String dateStr = df.format(date);
        String startDateStr = df.format(startDate);
        String endDateStr = df.format(endDate);
        return isDateInRange(dateStr, startDateStr, endDateStr);
    }

    /**
     * 检测给定的日期是否在指定的时间内
     *
     * @param date      日期
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static boolean isDateInRange(String date, String startDate,
                                        String endDate) {
        if (null == date || null == startDate || null == endDate) {
            return false;
        }
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    /**
     * @param @param  currTime
     * @param @param  startTime
     * @param @param  endTime
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: isDateTimeInRange
     * @Description: check date time in range
     */
    public static boolean isDateTimeInRange(Date currTime, Date startTime, Date endTime) {
        if (null == currTime || null == startTime || null == endTime) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        String timeStr = df.format(currTime);
        String startTimeStr = df.format(startTime);
        String endTimeStr = df.format(endTime);
        return isDateInRange(timeStr, startTimeStr, endTimeStr);
    }

    /**
     * 比较两个日期的大小
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Date date1, Date date2) {
        if (null == date1 || null == date2) {
            return 0;
        }
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String date1Str = df.format(date1);
        String date2Str = df.format(date2);
        return date1Str.compareTo(date2Str);
    }

    //-计算日期 end------------------------------------------

    /**
     * 检测给定的日期是否是工作日
     *
     * @param date
     * @return
     */
    public static boolean isWorkday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return day != 1 && day != 7;
    }

    /**
     * 检测给定的日期是否是工作日
     *
     * @param dateStr
     * @return
     */
    public static boolean isWorkday(String dateStr) {
        boolean result = false;
        DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Date date;
        try {
            date = df.parse(dateStr);
            result = isWorkday(date);
        } catch (Exception e) {
            // donothing
        }
        return result;
    }

    /**
     * 得到date当前月最后一天距离现在的天数
     *
     * @param date
     * @return
     */
    public static int getMonthLastDayDistNow(Date date) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1900);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));
        int lastDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDays - c.get(Calendar.DAY_OF_MONTH) + 1;
    }

    /**
     * 得到date当前月的天数
     *
     * @param date
     * @return
     */
    public static int getMonthDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1900);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));
        int lastDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDays;
    }


    /**
     * 得到当前日期的本周周一时间
     *
     * @return
     */
    public static String getForwardWeekStartTime() {
        int mondayPlus = weekDays();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(monday);
    }

    /**
     * 得到当前日期本周的周日时间
     *
     * @return
     */
    public static String getForwardWeekEndTime() {
        int mondayPlus = weekDays();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(monday);
    }

    /**
     * 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
     *
     * @return
     */
    private static int weekDays() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;


    }


    /**
     * 得到日期后几天的日期时间
     *
     * @return
     */
    public static String getNextDay(String nowDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(sdf.parse(nowDate));
            //cal.add(Calendar.DATE,5);
            cal.add(Calendar.DATE, NEXT_DAY); //update by bill 2010-07-20

        } catch (ParseException e) {
            //log.info("DateUtils error {} ", e);
        }
        return sdf.format(cal.getTime());

    }

    /**
     * 得到日期后几天的日期时间
     *
     * @param d dd
     * @return
     */
    public static Date getNextDay(Date d) {
        Date date = d;
        if (date == null) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, NEXT_DAY);

        return cal.getTime();
    }

    /**
     * 返回两个日期相差的天数
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getDistDates(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = sdf.parse(sdf.format(startDate));
        } catch (ParseException e) {
            log.info("DateUtils error {} ", e);
        }
        try {
            endDate = sdf.parse(sdf.format(endDate));
        } catch (ParseException e) {
            log.info("DateUtils error {} ", e);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 返回两个日期相差的小时
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static Double getDistHour(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Double.valueOf((timeend - timestart) / (1000 * 60 * 60.0));
    }

    /**
     * 返回两个日期相差的分钟
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static Double getDistMinute(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Double.valueOf(Math.abs((timeend - timestart)) / (1000 * 60.0));
    }

    public static Float getFloatDistHour(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Float.valueOf(timeend - timestart) / (1000 * 60 * 60);
    }


    public static Float getFloatDistMsec(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Float.valueOf(timeend - timestart);
    }

    /**
     * 根据日期获得所在周的日期
     *
     * @param mdate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static List<Date> getWeekList(Date mdate) {
        int b = mdate.getDay();
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 0; a < 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a, fdate);
        }
        return list;
    }

    /**
     * 给当前时间增加固定秒数
     *
     * @param date
     * @param
     * @return
     */
    public static Date getDateBySecond(Date date, Integer second) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime() + second * 1000);
        date = cal.getTime();
        return date;
    }

    /**
     * 获取当年的第一天
     *
     * @param
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     *
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取月份第一天
     *
     * @param
     * @return
     * @author zhaopengfei@hengyunsoft.com
     * @version 1.0.0,
     * create 2017/6/10 14:18
     * @since GYDBDC1.0.0
     */
    public static Date getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取月份最后一天
     *
     * @param
     * @return
     * @author zhaopengfei@hengyunsoft.com
     * @version 1.0.0,
     * create 2017/6/10 14:18
     * @since GYDBDC1.0.0
     */
    public static Date getMonthLastDay(Date date) {
        //创建日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);     //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        return calendar.getTime();
    }


    /***
     * 判断两个时间是否跨天
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isCrossDays(Date startTime, Date endTime) {
        String startStr = format(startTime, DateUtils.DEFAULT_DATE_FORMAT);
        String endStr = format(endTime, DateUtils.DEFAULT_DATE_FORMAT);
        return !startStr.equals(endStr);
    }

    /***
     * 判断两个时间包含的周末(星期六星期天)的天数
     * @param startTime
     * @param endTime
     * @return
     */
    public static int hasWeekEndContain(Date startTime, Date endTime) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(startTime);

        int totalWeekEnds = 0;
        //设置开始日期为星期一,
        //如果开始日期是星期天，那么周末总天数加1，并且开始时间往后走一天
        //如果开始日期不是星期天，那么开始时间往前走 当前星期的值 减去 星期一的星期值
        int sDayWeek = calendar1.get(Calendar.DAY_OF_WEEK);//开始时间是星期几
        if (sDayWeek != Calendar.SUNDAY) {
            startTime = addDays(startTime, -(sDayWeek - Calendar.MONDAY));
        } else {
            startTime = addDays(startTime, 1);
            totalWeekEnds += 1;
        }
        //设置结束日期为星期天,
        //不是星期天的完前走 星期值 减去 1  的天数
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(endTime);
        int eDayWeek = calendar2.get(Calendar.DAY_OF_WEEK);
        if (eDayWeek != Calendar.SUNDAY) {
            endTime = addDays(endTime, -(eDayWeek - 1));
            if (eDayWeek == Calendar.SATURDAY) {
                totalWeekEnds += 1;
            }
        }
        int distDates = getDistDates(startTime, endTime) + 1;
        totalWeekEnds += (distDates / 7) * 2;
        return totalWeekEnds;
    }

    //获取昨天的开始时间
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    //获取昨天的结束时间
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }


    /**
     * 获取当前系统时间最近12月的年月（含当月）
     */
    public static String[] getLatest12Month() {
        String[] latest12Months = new String[12];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1); //要先+1,才能把本月的算进去
        for (int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
            latest12Months[11 - i] = cal.get(Calendar.YEAR) + "-" + fillZero(cal.get(Calendar.MONTH) + 1);
        }
        return latest12Months;
    }

    /**
     * 获取当前系统时间最近12月的年月（含当月）
     */
    public static String[] getLatest6Month() {
        String[] latest12Months = new String[6];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1); //要先+1,才能把本月的算进去
        for (int i = 0; i < 6; i++) {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
            latest12Months[5 - i] = cal.get(Calendar.YEAR) + "-" + fillZero(cal.get(Calendar.MONTH) + 1);
        }
        return latest12Months;
    }

    /**
     * 格式化月份
     */
    public static String fillZero(int i) {
        String month = "";
        if (i < 10) {
            month = "0" + i;
        } else {
            month = String.valueOf(i);
        }
        return month;
    }

    /**
     * 获取指定时间最近的年月（含指定时间所在的年月）
     * month 显示月的个数
     * designationTime 指定时间
     * <p>
     * String time="2018-11"+"-01 00:00:00";
     * Date date=null;
     * SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     * date=formatter.parse(time);
     * getSpecifiedTimesMonth(13,date);
     */
    public static List<String> getSpecifiedTimesMonth(int month, Date specifiedTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        List<String> months = new ArrayList<>();// 创建一个集合 用于存储年月
        for (int i = 1; i <= month; i++) {// 遍历
            Calendar tmp = Calendar.getInstance();
            tmp.setTime(specifiedTime);
            tmp.add(Calendar.MONTH, (i - month));
            months.add(sdf.format(tmp.getTime()));// 往集合添加数据
        }
        return months;
    }

    /**
     * 获得过去12个月(包括本月)
     *
     * @return
     */
    public static List<Date> getLastYearMonth() {
        List<Date> dates = new ArrayList<>();
        Date date = new Date();
        dates.add(date);
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 11; i++) {
            cal.setTime(date);
            cal.add(cal.MONTH, -1);
            date = cal.getTime();
            dates.add(date);
        }
        Collections.reverse(dates);
        return dates;
    }

    /**
     * 判断data1>data2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isLagerDate(Date date1, Date date2) {
        if (date1 == null) {
            return false;
        }
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            boolean isSameYear = cal1.get(Calendar.YEAR) >= cal2
                    .get(Calendar.YEAR);
            boolean isSameMonth = isSameYear
                    && cal1.get(Calendar.MONTH) >= cal2.get(Calendar.MONTH);

            return isSameMonth;
        } catch (Exception e) {
        }
        return false;
    }


    /**
     * 计算结束时间与当前时间中的天数
     *
     * @param endDate 结束日期
     * @return
     */
    public static long until(Date endDate) {
        return LocalDateTime.now().until(date2LocalDateTime(endDate), ChronoUnit.DAYS);
    }

    /**
     * 计算结束时间与开始时间中的天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static long until(Date startDate, Date endDate) {
        return date2LocalDateTime(startDate).until(date2LocalDateTime(endDate), ChronoUnit.DAYS);
    }

    /**
     * 计算2个日期之间的所有的日期 yyyy-MM-dd
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenDay(Date start, Date end) {
        return getBetweenDay(format(start, "yyyy-MM-dd"), format(end, "yyyy-MM-dd"));
    }

    /**
     * 计算2个日期之间的所有的日期 yyyy-MM-dd
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenDay(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusDays(1)).
                limit(distance + 1).forEach(f -> list.add(f.toString()));
        return list;
    }

    /**
     * 计算2个日期之间的所有的周 yyyy-ww
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenWeek(Date start, Date end) {
        return getBetweenWeek(format(start, "yyyy-MM-dd"), format(end, "yyyy-MM-dd"));
    }

    /**
     * 计算2个日期之间的所有的周 yyyy-ww
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenWeek(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        long distance = ChronoUnit.WEEKS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusWeeks(1)).
                limit(distance + 1).forEach(f -> list.add(f.format(DateTimeFormatter.ofPattern("yyyy-ww"))));
        return list;
    }

    /**
     * 计算2个日期之间的所有的月 yyyy-MM
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenMonth(Date start, Date end) {
        return getBetweenMonth(format(start, "yyyy-MM-dd"), format(end, "yyyy-MM-dd"));
    }

    /**
     * 计算2个日期之间的所有的月 yyyy-MM
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenMonth(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        long distance = ChronoUnit.MONTHS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }

        Stream.iterate(startDate, d -> d.plusMonths(1))
                .limit(distance + 1)
                .forEach(f -> list.add(f.format(DateTimeFormatter.ofPattern("yyyy-MM"))));
        return list;
    }

}