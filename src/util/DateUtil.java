package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	//����һ��ĺ�����
	static long millisecondsOfOneDay = 1000*60*60*24;
	
	//��util�������ں���ת��sql����
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	//��ȡ�����ʱ�䣬��ʱ������Ϊ0
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		return c.getTime();
	}
	
	//��ȡ���µĵ�һ�졣
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
	
	//��ȡ��ĩ
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
	
	//��ȡ����һ���ж�����
	public static int thisMonthTotalDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long firstDayMillisSeconds = monthBegin().getTime();
		
		return (int)((lastDayMilliSeconds-firstDayMillisSeconds)/millisecondsOfOneDay)+1;
	}
	
	//��ȡ���»�ʣ������
	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = monthEnd().getTime();
		long toDayMillisSeconds = today().getTime();
		
		return (int)((lastDayMilliSeconds-toDayMillisSeconds)/millisecondsOfOneDay)+1;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.monthEnd());
	}
}
