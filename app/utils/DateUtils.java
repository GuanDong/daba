package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date parse(String dateValue, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateValue);
        } catch (ParseException e) {
            return null;
        }
    }
}
