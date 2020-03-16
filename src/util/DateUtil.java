package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	//定义一天的毫秒数
	static long millisecondsOfOneDay = 1000*60*60*24;
	
	//将util包的日期函数转成sql包的
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	//获取今天的时间，将时分秒置为0
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		return c.getTime();
	}
	
	//获取本月的第一天。
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE,1);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();
	}
	
	//获取月末
	public static Date monthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}
	
	//获取本月一共有多少天
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMillisSeconds = monthBegin().getTime();
		
		return (int)((lastDayMilliSeconds-firstDayMillisSeconds)/millisecondsOfOneDay)+1;
	}
	
	//获取本月还剩多少天
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMillisSeconds = today().getTime();
		
		return (int)((lastDayMilliSeconds-toDayMillisSeconds)/millisecondsOfOneDay)+1;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.monthEnd());
	}
}
