package com.model.zlx.zhanglxalex.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName DateUtil
 * @Author zhanglixin Alex
 * @Date 2020/6/7 下午4:21
 * @Version 1.0
 */
public class DateUtil extends DateUtils {

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHMSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YMD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HHmmss = "HHmmss";
    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd HH:mm", "yyyy.MM"};

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date stringToDateFormat(String dateString, String format) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = YYYYMMDDHHMMSS;
        }
        return dateValue(dateString, format);
    }

    public static Date stringToDate(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        SimpleDateFormat clsFormat = null;
        String format = "";
        if (dateString.length() == 19) {
            format = YMDHMS;
        } else if (dateString.length() == 10) {
            format = YMD;
        } else if (dateString.length() == 14) {
            format = YYYYMMDDHHMMSS;
        } else if (dateString.length() == 8) {
            format = YYYYMMDD;
        } else {
            return null;
        }
        return dateValue(dateString, format);
    }

    private static Date dateValue(String dateString, String format) {
        SimpleDateFormat clsFormat = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        return clsFormat.parse(dateString, pos);
    }

    public static Date getNowTime() {
        return new Date();
    }

    public static int getDate8() {
        SimpleDateFormat clsFormat = new SimpleDateFormat(YYYYMMDD);
        return Integer.valueOf(clsFormat.format(getNowTime()));
    }

    public static int getDate(int date) {

        SimpleDateFormat sf = new SimpleDateFormat(YYYYMMDD);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, date);
        Date d = c.getTime();
        int before = Integer.valueOf(sf.format(d));
        return before;
    }

    public static String getTime6() {
        SimpleDateFormat clsFormat = new SimpleDateFormat(HHmmss);
        return clsFormat.format(getNowTime());
    }

    /**
     * @Description 传入时间与当前时间相差时间数
     * @Param
     * @Return 返回的是毫秒
     **/
    public static long timeDifference(Date time) {
        return getNowTime().getTime() - time.getTime();
    }

    public static Date dateTimeAddTimes(Date time, long times) {
        return new Date(time.getTime() + times * 1000);
    }

    public static String datetoString(Date time, String format) {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern(format);
        return null == time ? "" : df.format(time);
    }

    /**
     * 获得当地时间，返回Timestamp格式
     *
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Timestamp getCurTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getCurTM() {
        return getCurTime("HHmmss");
    }

    public static String getCurTM(String date) {
        return getCurTime(date, "HHmmss");
    }

    public static String getCurHH() {
        return getCurTime("HH");
    }

    public static String getCurDT() {
        return getCurTime("yyyyMMdd");
    }

    public static String getCurTime(String format) {
        StringBuilder str = new StringBuilder();
        Date ca = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        str.append(sdf.format(ca));
        return str.toString();
    }

    public static String getCurTime(String date, String format) {
        StringBuilder str = new StringBuilder();
        Date ca = stringToDate(date);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        str.append(sdf.format(ca));
        return str.toString();
    }

    /**
     * 取得线程耗时
     *
     * @param startTime 开始时间戳 long startTime = System.currentTimeMillis();
     * @return 耗时信息
     * @author zhao_qg
     */
    public static String getHaoShiTimeMsg(long startTime) {
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        long day = time / (24 * 60 * 60 * 1000);
        long hour = time / (60 * 60 * 1000) - day * 24;
        long min = (time / (60 * 1000)) - day * 24 * 60 - hour * 60;
        long s = time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;
        long hs = time - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000;
        return "耗时: " + day + "天" + hour + "小时 " + min + "分 " + s + "秒 " + hs + "毫秒";
    }

    public static boolean isValidDate(String date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String addDay(Integer num) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        Date currdate = ca.getTime();
        return format.format(currdate);
    }

    /**
     * 获取当天剩余秒数
     *
     * @return
     */
    public static int getSeconds() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH),
                curDate.get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000;
    }

    public static void main(String[] args) {
        System.out.println(getSeconds());
    }

    public static boolean checkAdult(Date date) {
        Calendar current = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTime(date);
        Integer year = current.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        if (year > 18) {
            return true;
        }
        if (year < 18) {
            return false;
        }
        // 如果年相等，就比较月份
        Integer month = current.get(Calendar.MONTH) - birthDay.get(Calendar.MONTH);
        if (month > 0) {
            return true;
        }
        if (month < 0) {
            return false;
        }
        // 如果月也相等，就比较天
        Integer day = current.get(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH);
        return day >= 0;
    }

}
