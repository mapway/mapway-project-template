package cn.ennwifi.solu.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间辅助类.
 *
 * @author zhangjianshe
 */
public class Times {


  /**
   * 解析时间数据.
   *
   * @param data the data
   * @param format the format
   * @return the timestamp
   */
  public static final Timestamp parseTime(String data, String format) {
    if (format == null || format.length() == 0) {
      format = "yyyy-MM-dd HH:mm:ss";
    }
    SimpleDateFormat df = new SimpleDateFormat(format);
    try {
      return new Timestamp(df.parse(data).getTime());
    } catch (ParseException e) {
      e.printStackTrace();
      return now();
    }
  }

  /**
   * Parses the time.
   *
   * @param data the data
   * @return the timestamp
   */
  public static final Timestamp parseTime(String data) {
    return parseTime(data, null);
  }

  /**
   * Parses the time.
   *
   * @param appStartTime the app start time
   * @return the timestamp
   */
  public static Timestamp parseTime(Long appStartTime) {
    return new Timestamp(appStartTime);
  }

  /**
   * Format time.
   *
   * @param time the time
   * @param format the format
   * @return the string
   */
  public static final String formatTime(long time, String format) {

    if (format == null || format.length() == 0) {
      format = "yyyy-MM-dd HH:mm:ss";
    }
    SimpleDateFormat df = new SimpleDateFormat(format);
    // df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    return df.format(new Date(time));
  }

  /**
   * Format time.
   *
   * @param time the time
   * @param format the format
   * @return the string
   */
  public static final String formatTime(Date time, String format) {

    if (format == null || format.length() == 0) {
      format = "yyyy-MM-dd HH:mm:ss";
    }
    SimpleDateFormat df = new SimpleDateFormat(format);
    if (time == null) {
      time = new Date();
    }
    return df.format(time);
  }

  /**
   * Format time.
   *
   * @param time the time
   * @return the string
   */
  public static final String formatTime(long time) {
    return formatTime(time, "");
  }

  /**
   * Format time.
   *
   * @param time the time
   * @return the string
   */
  public static final String formatTime(Timestamp time) {
    if (time == null) {
      return "";
    }
    return formatTime(time.getTime(), "");
  }

  /**
   * Format time.
   *
   * @param time the time
   * @param format the format
   * @return the string
   */
  public static final String formatTime(Timestamp time, String format) {
    if (time == null) {
      return "";
    }
    return formatTime(time.getTime(), format);
  }

  /**
   * 当前的时间.
   *
   * @return the timestamp
   */
  public static Timestamp now() {
    return new Timestamp(System.currentTimeMillis());
  }

  /**
   * Format date.
   *
   * @param date the date
   * @return the string
   */
  public static String formatDate(java.sql.Date date) {
    if (date == null) {
      return "";
    } else {
      return formatTime(date.getTime());
    }
  }

  /**
   * 解析时间格式为 Calendar 对象.
   * 
   * @param datetime 时间字符串
   * @return Calendar
   */
  public static Calendar parseTimeCalendar(String datetime) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(parseTime(datetime).getTime());
    return calendar;
  }

  /**
   * 解析时间格式为 Calendar 对象.
   * 
   * @param datetime 时间字符串
   * @param format 时间格式字符串
   * @return Calendar
   */
  public static Calendar parseTimeCalendar(String datetime, String format) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(parseTime(datetime, format).getTime());
    return calendar;
  }
}
