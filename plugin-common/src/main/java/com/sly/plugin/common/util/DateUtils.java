package com.sly.plugin.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期utils
 *
 * @author sly
 * @time 2018年12月22日
 */
public class DateUtils {
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    private static final String YEAR_MONTH_DAY_24HOUR_MIN_SEC = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyyMMddHHmmss
	 */
	private static final String YEAR_MONTH_DAY_24HOUR_MIN_SEC_1 = "yyyyMMddHHmmss";
	/**
	 * yyyy-MM-dd
	 */
	private static final String YEAR_MONTH_DAY = "yyyy-MM-dd";
	/**
	 * yyyyMMdd
	 */
	private static final String YEAR_MONTH_DAY_1 = "yyyyMMdd";


    /**
     * 格式化当前日期 输出格式: 2006-4-16
     *
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public static String formatDate() {
        Date date = new Date();
        String format = DateFormat.getDateInstance(DateFormat.DEFAULT).format(date);
        return format;
    }

    /**
     * 按指定格式格式化当前日期
     *
     * @param format
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public static String formatDate(String format) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化指定日期 输出格式: 2006-4-16
     *
     * @param date
     * @return
     * @author sly
     * @time 2018年12月22日
     */
    public static String formatDate(Date date) {
        String format = DateFormat.getDateInstance(DateFormat.DEFAULT).format(date);
        return format;
    }

    /**
     * 按指定格式格式化日期
     *
     * @param date
     * @param format
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化当前时间 输出格式: 2006-01-01 00:00:00
     *
     * @return
     * @author SLY
     * @date 2020/8/6
     */
    public static String formatTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEAR_MONTH_DAY_24HOUR_MIN_SEC);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化指定时间 输出格式: 2006-01-01 00:00:00
     *
     * @param date
     * @return
     * @author sly
     * @time 2018年12月22日
     */
    public static String formatTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEAR_MONTH_DAY_24HOUR_MIN_SEC);
        return simpleDateFormat.format(date);
    }


}
