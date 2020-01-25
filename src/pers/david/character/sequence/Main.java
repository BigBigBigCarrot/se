package pers.david.character.sequence;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		efficiencyComparision();

	}
	
	public static void efficiencyComparision(){
		String messagePattern="开始时间{0} 结束时间{1} 时间差{2}";
		String message;
		Calendar srartCalendar,endCalendar;
		Date startDate,endDate;
		String timesBetween;
		int loop=100000;
		String str="";
		StringBuffer sb=new StringBuffer("");
		StringBuilder sbd=new StringBuilder("");
		srartCalendar=Calendar.getInstance();
		startDate=srartCalendar.getTime();
		for(int i=0;i<loop;i++){
//			str=str+i;
//			sb.append(i);
			sbd.append(i);
		}
		endCalendar=Calendar.getInstance();
		endDate=endCalendar.getTime();
		timesBetween=endDate.getTime()-startDate.getTime()+"毫秒";
		message=MessageFormat.format(messagePattern, startDate,endDate,timesBetween);
		System.out.println(message);
	}

}
