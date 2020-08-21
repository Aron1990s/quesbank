package com.physics.quesbank.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	private final static SimpleDateFormat sdfHour = new SimpleDateFormat(
			"HH:mm:ss");
	
	private final static SimpleDateFormat sdfDayTime = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}
	
	/**
	 * 获取yyyyMMddHHmmss格式
	 * @return
	 */
	public static String getDayTime(){
		return sdfDayTime.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	* @Title: compareDate
	* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        
        return dateStr;
    }
    
    /**
     * 获取当月最小天数
     * @param date
     * @return
     * @throws Exception
     */
	public static String getCurrentMonthMinDay(String date) throws Exception {
		Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        String first = sdfDay.format(c.getTime())+" 00:00:00";
		return first;
	}
	
	/**
	 * 获取当月最大天数
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentMonthMaxDay (String date) throws Exception {
	   Calendar ca = Calendar.getInstance();    
       ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
       String last = sdfDay.format(ca.getTime())+" 23:59:59";
       return last;
	}
	
	/**
	 * 获取某月最大天
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysByYearMonth(int year, int month) {  		  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }
	
	/**
	 * 获取年份
	 * @param args
	 */
	public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
	}
	
	/**
	 * 获取月份
	 * @param args
	 */
	public static String getSysMonth() {
        Calendar date = Calendar.getInstance();
        String month = String.valueOf(date.get(Calendar.MONTH)+1);
        return month;
	}
	
	/**
	 * 获取某天几天后的日期
	 */
	public static String getDayByOffset(String str,Integer count) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
        Date date = sdf.parse(str, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        calendar.add(Calendar.DATE, count);
        Date date1 = calendar.getTime();
        String out = sdf.format(date1);
        return out;
	}
	
	/** 
     * 获取最近12个月，经常用于统计图表的X轴 
     */  
    public static String[] getLast12Months(){  
          
        String[] last12Months = new String[12];  
          
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1); //要先+1,才能把本月的算进去</span>  
        for(int i=0; i<12; i++){  
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月  
            last12Months[11-i] = cal.get(Calendar.YEAR)+ "-" + (cal.get(Calendar.MONTH)+1);  
        }  
        
        return last12Months;  
    } 
    
	/**
	 * 获取两个时间间隔(分钟)
	 */
	public static int getDateMinGap(String startDate, String endDate) throws Exception {			
		double re = (Double.parseDouble(String.valueOf(sdfTime.parse(endDate).getTime())) - Double.parseDouble(String.valueOf(sdfTime.parse(startDate).getTime()))) / (60 * 1000);
		return NumberFormatUtil.numberFormatForTwoDecimal(re);
	}
	
	/**
	 * 比较时间 h/m/s
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public static boolean compareHour (String start, String end) throws Exception {
		return sdfHour.parse(start).getTime() > sdfHour.parse(end).getTime();
	}
	
	/**
	 * 一段时间后的时间
	 * @param args
	 * @throws Exception
	 */
	public static String getTimeByTimeInterval(String time, long minute) throws Exception{
		Date date = sdfTime.parse(time);
		long curren = date.getTime();
        curren += minute * 60 * 1000;
        Date da = new Date(curren);
        return sdfTime.format(da);
	}
	
	/**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) throws Exception {
//    	System.out.println(getDays());
//    	System.out.println(getAfterDayWeek("3"));
//    	System.out.println(getLast12Months()[0]);
//    	System.out.println(getLast12Months()[1]);
//    	System.out.println(getLast12Months()[2]);
//    	System.out.println(getLast12Months()[3]);
//    	System.out.println(getLast12Months()[4]);
//    	System.out.println(getLast12Months()[5]);
//    	System.out.println(getLast12Months()[6]);
//    	System.out.println(getLast12Months()[7]);
//    	System.out.println(getLast12Months()[8]);
//    	System.out.println(getLast12Months()[9]);
//    	System.out.println(getLast12Months()[10]);
//    	System.out.println(getLast12Months()[11]);
//    	String [] aaaa = getLast12Months();
//    	for (String string : aaaa) {
//			System.out.println(string);
//		}
//    	System.out.println(getAfterDayWeek("-7"));
//    	System.out.println(getTime().substring(0,10));
//    	System.out.println(getAfterDayDate("-3"));
//    	System.out.println(getDayByOffset("2018-03-04",1));
//    	for (int i = 0; i < 7; i++) {
//    		System.out.println(getDayByOffset("2018-03-04",i));
//		}
    	
    	System.out.println(getTimeByTimeInterval("2018-03-04 12:12:12", 60));
    	System.out.println("2018-03-04 12:12:12".substring(11, 13));
    	System.out.println("2018-03-04 12:12:12".substring(14, 16));
    }

}
