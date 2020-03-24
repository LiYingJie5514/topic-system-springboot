package com.system.yyn.topicsystem.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 时间转换工具
 */
public class BaseDateUtil {
    public final static SimpleDateFormat g_SimpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public final static SimpleDateFormat g_SimpleDateFormat_1 = new SimpleDateFormat("yyMMdd");

    public final static SimpleDateFormat g_SimpleDateFormat_I = new SimpleDateFormat("yyyy-MM-dd");

    public final static SimpleDateFormat g_SimpleDateFormat_yyyyMM = new SimpleDateFormat("yyyyMM");

    public final static SimpleDateFormat g_SimpleDateFormat_ddHH = new SimpleDateFormat("ddHH");

    public final static SimpleDateFormat sdfDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public final static SimpleDateFormat sdfDateTimeFormat_I = new SimpleDateFormat("yyyyMMddHHmmss");

    public final static SimpleDateFormat sdfDateTimeFormat_MI = new SimpleDateFormat("yyMMddHHmmSSSS");

    public final static SimpleDateFormat uuidHeadDateTimeFormat = new SimpleDateFormat("yyMMddHHmmss");

    public final static SimpleDateFormat sdfDateTimeFormat_HHmmss = new SimpleDateFormat("HH:mm:ss");

    public final static SimpleDateFormat sdfDateTimeFormat_YYYY = new SimpleDateFormat("yyyy");

    public final static SimpleDateFormat sdfDateTimeFormat_MM = new SimpleDateFormat("MM");

    public final static SimpleDateFormat sdfDateTimeFormat_DD = new SimpleDateFormat("dd");
    
    public final static SimpleDateFormat sdfDateTimeFormat_MM_dd_HH_mm = new SimpleDateFormat("MM-dd HH:mm");
    
    public final static SimpleDateFormat sdfDateTimeFormat_ymd_hm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * 获取当前时间，毫秒级
     * @return 时间
     */
    public static String getDate(Date date){
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取系统当前日期
     * 
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 返回日期格式(yyyy-MM-dd HH:mm:ss)
     * 
     * @param date
     * @return
     */
    public static String toDateTimeStr(Date date) {
        if (date == null) {
            return "";
        }
        return sdfDateTimeFormat.format(date);
    }

    /**
     * 得到当前日期
     * 
     * @return String 当前日期DD格式
     */
    public static String getCurDateDD() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());

        sdfDateTimeFormat_DD.setTimeZone(TimeZone.getDefault());
        return (sdfDateTimeFormat_DD.format(now.getTime()));
    }

    /**
     * 得到当前日期(月份)
     * 
     * @return String 当前日期MM格式
     */
    public static String getCurDateMM() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());

        sdfDateTimeFormat_MM.setTimeZone(TimeZone.getDefault());
        return (sdfDateTimeFormat_MM.format(now.getTime()));
    }

    /**
     * 得到当前日期(年份)
     * 
     * @return String 当前日期 yyyy格式
     */
    public static String getCurDateYYYY() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());

        sdfDateTimeFormat_YYYY.setTimeZone(TimeZone.getDefault());
        return (sdfDateTimeFormat_YYYY.format(now.getTime()));
    }

    /**
     * 得到当前日期
     * 
     * @return String 当前日期 yyMMdd格式
     */
    public static String getCurDateYYMMDD() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());

        g_SimpleDateFormat_1.setTimeZone(TimeZone.getDefault());
        return (g_SimpleDateFormat_1.format(now.getTime()));
    }

    /**
     * 得到当前日期
     * 
     * @return String 当前日期 yyyyMMdd格式
     */
    public static String getCurDateYYYYMMDD() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());

        g_SimpleDateFormat.setTimeZone(TimeZone.getDefault());
        return (g_SimpleDateFormat.format(now.getTime()));
    }

    /**
     * 得到当前日期
     * 
     * @return String 当前日期 yyyyMMddHHmmSS格式
     */
    public static String getCurTime() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());

        sdfDateTimeFormat_I.setTimeZone(TimeZone.getDefault());
        return (sdfDateTimeFormat_I.format(now.getTime()));
    }

    /**
     * 获取当前日期字符串(UUID前12位生成规则)
     * 
     * @return String 当前日期 yyMMddHHmmSS格式
     */
    public static String getCurUuidHead() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());

        uuidHeadDateTimeFormat.setTimeZone(TimeZone.getDefault());
        return (uuidHeadDateTimeFormat.format(now.getTime()));
    }

    /**
     * 获取当前日期字符串(UUID前12位生成规则)
     * 
     * @return String 当前日期 yyyyMMddHHmmSSMI格式
     */
    public static String getMiDate() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        sdfDateTimeFormat_MI.setTimeZone(TimeZone.getDefault());
        return (sdfDateTimeFormat_MI.format(now.getTime()));
    }

    /**
     * 得到当前日期
     * 
     * @return String 当前日期 yyyy-MM-dd HHmmSS格式
     */
    public static String getCurDateTime() {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        sdfDateTimeFormat.setTimeZone(TimeZone.getDefault());
        return (sdfDateTimeFormat.format(now.getTime()));
    }

    /**
     * 将日期字符串(yyyy-MM-dd HH mm SS)转换为Date
     * 
     * @return Date
     * */
    public static Date getDateByStr(String dateStr) {

    	if(StringUtils.isBlank(dateStr)) {
        	return null;
        }
    	Date date = null;
    	try {
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 返回日期格式(yyyyMMddHHmmss)
     * 
     * @param date
     * @return
     */
    public static String toDateTimeStr2(Date date) {
        if (date == null) {
            return "";
        }
        return sdfDateTimeFormat_I.format(date);
    }

    /**
     * 返回日期格式(yyyy-MM-dd)
     * 
     * @param date
     * @return
     */
    public static String toDateStr(Date date) {
        if (date == null) {
            return "";
        }
        return g_SimpleDateFormat_I.format(date);
    }

    /**
     * 返回时间格式(HH:mm:ss)
     * 
     * @param date
     * @return
     */
    public static String toTimeStrHHmmss(Date date) {
        if (date == null) {
            return "";
        }
        return sdfDateTimeFormat_HHmmss.format(date);
    }

    /**
     * 返回日期格式(yyyyMMdd)
     * 
     * @param date
     * @return
     */
    public static String toDateStryyyyMMdd(Date date) {
        if (date == null) {
            return "";
        }
        return g_SimpleDateFormat.format(date);
    }

    /**
     * 返回日期格式(yyyyMM)
     * 
     * @param date
     * @return
     */
    public static String toDateStryyyyMM(Date date) {
        if (date == null) {
            return "";
        }
        return g_SimpleDateFormat_yyyyMM.format(date);
    }

    /**
     * 返回日期格式(DDHH)
     * 
     * @param date
     * @return
     */
    public static String toDateStrddHH(Date date) {
        if (date == null) {
            return "";
        }
        return g_SimpleDateFormat_ddHH.format(date);
    }

    /**
     * <p>
     * 得到xxxx年xx月xx日 日期格式。
     * </p>
     * 
     * @param date
     * @return
     */
    public static String toChinaDateStr(Date date) {
        if (date == null) {
            return "";
        }
        // 得到yyyy-mm-dd格式日期格式
        String dateStr = toDateStr(date);
        StringBuffer sb = new StringBuffer();
        if (dateStr != null && dateStr.length() > 0) {
            String[] newStr = dateStr.split("-");
            // 得到月
            int month = Integer.valueOf(newStr[1]);
            // 得到日
            int day = Integer.valueOf(newStr[2]);
            sb.append(newStr[0]).append("年");
            sb.append(month).append("月").append(day).append("日");
        }
        return sb.toString();
    }

    /**
     * <p>
     * 获取当前系统时间的小时数
     * </p>
     * 
     * @return
     */
    public static int getCurrentHour() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * <p>
     * 获取当前系统时间的分钟数
     * </p>
     * 
     * @return
     */
    public static int getCurrentMinutes() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * <p>
     * 获取本月第一天日期（格式如YYYYMMDD）,如果当前日为当月1日,则返回上月第一日
     * </p>
     * 
     * @return
     */
    public static String getMonthFirstDay() {
        Calendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = 0;
        if (day == 1) {
            calendar.add(Calendar.MONTH, -1);
        }
        month = calendar.get(Calendar.MONTH);
        if (month < 10) {
            return "" + calendar.get(Calendar.YEAR) + "0" + (month + 1) + "01";
        } else {
            return "" + calendar.get(Calendar.YEAR) + month + "01";
        }
    }

    public static Date getFristDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    public static Date getLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间前几天或后几天的日期
     * 
     * @return
     */
    public static Date getAddDays(int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 获取某个月后的日期格式（yyyyMMdd）
     * 
     * @return
     */
    public static String getAfterMonth(int monthNum) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, monthNum);
        return g_SimpleDateFormat.format(calendar.getTime());
    }
    
    /**
     * 获取某个月后的日期格式（yyyy-MM-dd）
     * 
     * @return
     */
    public static String getPreMonth(int monthNum) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, monthNum);
        return g_SimpleDateFormat_I.format(calendar.getTime());
    }

    /**
     * 返回日期（格式yyyyMMdd）
     * 
     * @param timeMillis
     * @return
     */
    public static String getFormatDate(long timeMillis) {
        return sdfDateTimeFormat_I.format(new Date(timeMillis));
    }

    /**
     * 获取当前系统时间距离传入时间的毫秒数
     * 
     * @param strTime
     *            格式[ DD:00:00]
     * @return
     * @throws ParseException
     */
    public static long getSleepTime(String strTime) throws ParseException {
        long p = 1;
        long l_date = System.currentTimeMillis();
        Date date_now = new Date(l_date);
        String strDate = g_SimpleDateFormat_I.format(date_now) + strTime;
        if (date_now.before(sdfDateTimeFormat.parse(strDate)))
            p = (sdfDateTimeFormat.parse(strDate)).getTime() - l_date;
        else {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date_now);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date date = calendar.getTime();
            strDate = g_SimpleDateFormat_I.format(date) + strTime;
            p = (sdfDateTimeFormat.parse(strDate)).getTime() - l_date;
        }
        return p;
    }

    public static String getPredate() {
        Date nowDate = new Date();
        String nowdates = g_SimpleDateFormat_I.format(nowDate);
        String[] dates = nowdates.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]) - 1;
        if (day == 0) {
            switch (month - 1) {
            case 1:
                day = 31;
                break;
            case 3:
                day = 31;
                break;
            case 5:
                day = 31;
                break;
            case 7:
                day = 31;
                break;
            case 8:
                day = 31;
                break;
            case 10:
                day = 31;
                break;
            case 0:
                month = 13;
                year = year - 1;
                day = 31;
                break;
            case 4:
                day = 30;
                break;
            case 6:
                day = 30;
                break;
            case 9:
                day = 30;
                break;
            case 11:
                day = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    day = 29;
                } else {
                    day = 28;
                }
                break;
            default:
                break;
            }
            month = month - 1;
        }
        String predate = Integer.toString(year) + "-" + (month < 10 ? "0" + month : month) + "-"
                + (day < 10 ? "0" + day : day);
        return predate;
    }

    public static long getCurrentYear() {
        return Long.parseLong(sdfDateTimeFormat_YYYY.format(new Date()));
    }

    /**
     * 判断一个日期字符串是否合法
     * 
     * @param date
     * @param format
     * @return
     * @author liufengyu
     */
    public static boolean isDateStringCorrect(String date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);

        try {
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 将字符串类型的日期格式 转换为 符合要求的日期格式
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getStrDate4String(String date, String format) {
        if (date == null || date.trim().equals("")) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                Date d = df.parse(date);
                return df.format(d);
            } catch (ParseException e) {
                return "";
            }
        }
    }
    
    public static String getStrDate4StringFmt(String date) {
        if (date == null || date.trim().equals("")) {
            return "";
        } else {
            try {
            	SimpleDateFormat simpleDateFormat = g_SimpleDateFormat;
            	Date parse = simpleDateFormat.parse(date);
            	
            	SimpleDateFormat df = g_SimpleDateFormat_I;
                return df.format(parse);
            } catch (ParseException e) {
                return "";
            }
        }
    }

    /**
     * 将Date类型的日期格式 转换为 符合要求的 String日期格式
     * 
     * @param date
     * @param format
     * @return
     */
    public static String toDateStr(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
    }

    /**
     * 将字符串类型的日期格式 转换为 符合要求的 Date类型的日期格式
     * 
     * @param date
     * @param format
     *            yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date strToDate(String date, String format) throws Exception {
        if (date == null || date.trim().equals("")) {
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date2 = null;
            try {
                date2 = df.parse(date);
            } catch (ParseException e) {
                throw e;
            }
            return date2;
        }
    }

    public static Date getDateTime(String date) {
        if (date == null || date.trim().equals("")) {
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return df.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }

    /**
     * 计算指定日期时间之间的时间差
     * 
     * @param beginStr
     *            开始日期字符串
     * @param endStr
     *            结束日期字符串
     * @param f
     *            时间差的形式0-秒,1-分种,2-小时,3--天 日期时间字符串格式:yyyyMMddHHmmss
     * */
    public static int getInterval(String beginStr, String endStr, int f) {
        int hours = 0;
        try {
            Date beginDate = sdfDateTimeFormat.parse(beginStr);
            Date endDate = sdfDateTimeFormat.parse(endStr);
            long millisecond = endDate.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)
            /**
             * Math.abs((int)(millisecond/1000)); 绝对值 1秒 = 1000毫秒
             * millisecond/1000 --> 秒 millisecond/1000*60 - > 分钟
             * millisecond/(1000*60*60) -- > 小时 millisecond/(1000*60*60*24) -->
             * 天
             * */
            switch (f) {
            case 0: // second
                return (int) (millisecond / 1000);
            case 1: // minute
                return (int) (millisecond / (1000 * 60));
            case 2: // hour
                return (int) (millisecond / (1000 * 60 * 60));
            case 3: // day
                return (int) (millisecond / (1000 * 60 * 60 * 24));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hours;
    }

    /**
     * 获得当前时间到未来目标时间的秒差
     * @param target
     * @return
     */
    public static int getSecondsInterval(Date target){
        int hours = 0;
        try {
            Date beginDate = new Date();
            long millisecond = target.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)

            return (int) (millisecond / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hours;
    }

    /**
     * 得到起始日期前或后天数的日期
     * 
     * @param starttime
     *            起始日期 格式：yyyy-MM-dd
     * @param days
     * @return
     * @throws ParseException
     */
    public static Date getStartDateInterval(String starttime, int days) {
        // 格式化起始时间 yyyyMMdd
        Date startDate = null;
        try {
            startDate = g_SimpleDateFormat_I.parse(starttime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar startTime = Calendar.getInstance();
        startTime.clear();
        startTime.setTime(startDate);

        startTime.add(Calendar.DAY_OF_YEAR, days);
        return startTime.getTime();
    }

    /**
     * 得到起始日期和结束日期之间的天数
     * 
     * @param beginStr
     *            起始日期
     * @param endStr
     *            结束日期
     * @param format
     *            根据 日期参数的格式，传对应的SimpleDateFormat格式
     * @return 天数
     */
    public static int getDaysInterval(String beginStr, String endStr, SimpleDateFormat format) {

        try {
            int daysInterval = 0;
            Date beginDate = format.parse(beginStr);
            Date endDate = format.parse(endStr);
            long millisecond = endDate.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)
            int s = (int) (millisecond / (1000 * 60 * 60 * 24));//商
            int y = (int) (millisecond % (1000 * 60 * 60 * 24));//余数
            if(y != 0 ){
                daysInterval = s +1;
            }else{
                daysInterval = s;
            }
            return daysInterval;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 判断一个时间是否在一个范围内
     * @param format
     * @param beginPoint
     * @param endPoint
     * @return
     */
	public static boolean getIsInPeriod(String format, String beginPoint, String endPoint) {
		
		boolean flag = false;
		try {
			if(null != format && null != beginPoint && null != endPoint){
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				
				//获取格式化后的开始日期 和 结束日期
				String currYMDStr = toDateStr(new Date());
				Date begin = dateFormat.parse(currYMDStr + " " + beginPoint + ":00");
				Date end = dateFormat.parse(currYMDStr + " " + endPoint + ":00");
				
				//比较当前时间是否在开始日期和结束日期范围内
				long currMills = new Date().getTime();
				long beginMills = begin.getTime();
				long endMills = end.getTime();
				
				if(currMills >= beginMills && currMills <= endMills){
					flag = true;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static Date timemillisToDate(String timemillis) {
		Date d = null;
		try {
			Long timemi = Long.valueOf(timemillis);
			String date = sdfDateTimeFormat.format(timemi);
			d = sdfDateTimeFormat.parse(date);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	/**
	 * 返回时间格式字符串MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static String toDateStrMdHm(Date date) {
        if (date == null) {
            return "";
        }
        return sdfDateTimeFormat_MM_dd_HH_mm.format(date);
    }
	
	/**
     * 返回日期格式(yyyy-MM-dd HH:mm)
     * 
     * @param date
     * @return
     */
    public static String toDateTime_ymd_hm(Date date) {
        if (date == null) {
            return "";
        }
        return sdfDateTimeFormat_ymd_hm.format(date);
    }
    
    // 返回星期几
 	public static String getWeekOfDate(String date) {
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
 		Date s_date = null;
 		try {
 			s_date = (Date) sdf.parse(date);
 		} catch (ParseException e) {
 			e.printStackTrace();
 		}
 		String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
 		Calendar cal = Calendar.getInstance();
 		cal.setTime(s_date);
 		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
 		if (w < 0)
 			w = 0;
 		return weekDays[w];
 	}
 	
 	//获取当前时间string型
	public static String getDate( Date date , String fmt ){
		SimpleDateFormat format = new SimpleDateFormat(fmt);
		return format.format(date);
	}

    public static Integer getEndTime(){
        Date date=new Date();
        Calendar midnight=Calendar.getInstance();
        midnight.setTime(date);
        midnight.add(midnight.DAY_OF_MONTH,1);
        midnight.set(midnight.HOUR_OF_DAY,0);
        midnight.set(midnight.MINUTE,0);
        midnight.set(midnight.SECOND,0);
        midnight.set(midnight.MILLISECOND,0);
        Integer seconds=(int)((midnight.getTime().getTime()-date.getTime())/1000);
        return seconds;
    }
    
    /**
	 * 转换时间格式，返回字符串
	 * @param date 时间
	 * @param pattern 格式
	 * @return 字符串
	 */
 	public static String formatDate(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static void main(String[] args){
//        System.out.println(getEndTime());

        System.out.println(getCurDateYYYY());
    }
	
}
