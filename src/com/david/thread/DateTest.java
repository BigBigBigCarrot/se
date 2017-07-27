package com.david.thread;
import java.util.Calendar;
import java.util.Date;

//import java.sql.Date;




public class DateTest
{

	public static void main(String[] args)
	{
		//����Date����
		Date date;
		date=new Date(2016-1900,1-1,30);
		//date=new Date("16-1-30");
		//date.setMonth(1);
		//date=new Date();
		//date.setYear(2016);
		//date.setMonth(1);
		
		//System.out.println(date.getYear()+" "+date.getMonth()+" "+date.getDay());
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		
		System.out.println(date);
		
		/*
		Calendar cal=Calendar.getInstance();

		cal.setTime(date);
		System.out.println(cal.getTime());
		*/
		
		//��ȡϵͳʱ��
		Calendar calendar = Calendar.getInstance();
		int year;
		year=calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		date=new Date(year-1900,month,day,hour,minute,second);
		
		System.out.println("��ǰʱ��"+year+"��"+month+"��"+day+"��"+hour+"ʱ"+minute+"��"+second+"��");
		System.out.println("date:"+date);
	}

}
