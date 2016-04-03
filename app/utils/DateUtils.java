package utils;

import java.util.Date;

/**
 * Created by gchuyun on 16/4/3.
 */
public class DateUtils {

    public static Date toLastSecond(Date date){
        date = org.apache.commons.lang.time.DateUtils.setHours(date, 23);
        date = org.apache.commons.lang.time.DateUtils.setMinutes(date, 59);
        date = org.apache.commons.lang.time.DateUtils.setSeconds(date, 59);
        date = org.apache.commons.lang.time.DateUtils.setMilliseconds(date, 99);
        return date;
    }

    public static Date toFirstSecond(Date date){
        date = org.apache.commons.lang.time.DateUtils.setHours(date, 0);
        date = org.apache.commons.lang.time.DateUtils.setMinutes(date, 0);
        date = org.apache.commons.lang.time.DateUtils.setSeconds(date, 0);
        date = org.apache.commons.lang.time.DateUtils.setMilliseconds(date, 0);
        return date;
    }

    public static Date addMinutes(Date date, int amount){
        return org.apache.commons.lang.time.DateUtils.addMinutes(date, amount);
    }

    public static String format(Date date, String pattern){
        return org.apache.http.client.utils.DateUtils.formatDate(date, pattern);
    }

    public static Date parse(String dateValue, String... patterns){
        return org.apache.http.client.utils.DateUtils.parseDate(dateValue, patterns);
    }
}
