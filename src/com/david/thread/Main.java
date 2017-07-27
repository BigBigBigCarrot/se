package com.david.thread;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Main
{
	public static void main(String[] args)
	{
		/*
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date); 
		
		System.out.println(time);
		*/
		
		/*
		Student s1,st;
		s1=new Student("-1");
		
		for(int i=0;i<=9;i++)
		{
			st=(Student)s1.clone();
			System.out.println(st);
		}
		*/
		
		/*
		A a=new A();
		a.getB().print();
		*/
		
		/*
		double choice;
		choice=1.2;
		
		switch((int)choice)
		{
			case 0:{System.out.println(0);break;}
			case 1:{System.out.println(1);break;}
			case 2:{System.out.println(2);break;}
			case 3:{System.out.println(3);break;}
		}
		System.out.println("end");
		*/
		
		/*
		//String���Ȳ���
		String str="";
		for(int i=0;i<=50000;i++)
		{
			str=str+"\n "+i;
		}
		System.out.println(str);
		*/
		/*
		System.out.println(9%2);
		System.out.println(9/2);
		System.out.println(3/7);
		System.out.println(3/2);
		System.out.println(3%7);
		*/
		
		/*
		Long num=new Long(1);
		Long num2=new Long(1);
		if(num==num2)
		{
			System.out.println("num==num2");
		}
		else
		{
			System.out.println("num!=num2");
		}
		System.out.println("num-num2="+(num-num2));
		*/
		
		//System.out.println(10%3);
		/*
		int a,b,c;
		a=55;
		b=22;
		c=a/b;
		if(a%b>0)
		{
			c++;
		}
		System.out.println(c);
		*/
		
		/*
		int lineNum=38014;
		int maxLIne=500;
		int position=(lineNum+1)%maxLIne;
		System.out.println(position);
		*/
		
		/*
		Integer num=new Integer("1");
		if(num>0){
			System.out.println("num>0");
		}
		*/
		
		/*
		List<String> list=new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		
		for(String str:list){
			System.out.println(str);
		}
		*/
		
		/*
		System.out.println(checkNum("0.0000001"));
		System.out.println(checkNum("1"));
		System.out.println(checkNum("1.1"));
		System.out.println(checkNum("0.0001"));
		System.out.println(checkNum("0.0000"));
		System.out.println(checkNum("-1"));
		System.out.println(checkNum("0.0"));
		System.out.println(checkNum("1231.0000"));
		System.out.println(checkNum("a1231.0000"));
		System.out.println(checkNum("++1231.0000"));
		System.out.println(checkNum("1.-"));
		System.out.println(checkNum("1111"));
		
		BigDecimal bd=new BigDecimal("");
		*/
		
		/*
		int[] nums={3,2,2,3};
		int val=3;
		int length=0;
        for(int item: nums){
            if(item==val){
                length++;
                item=val+1;
            }
        }
        
        System.out.println(nums);
        */
		
//		
//		String idPath=">1>2>3>4>6>7153>";
//		String temp;
//		temp=idPath.substring(0, idPath.lastIndexOf(">")-1);
//		System.out.println(temp.substring(0, temp.lastIndexOf(">")+1));
		
		System.out.println("h10oChi3njc25TZIRB0eXhNTnXHG7OPyRPP3e6jiPiR1Tls17Gh5N2GXH0Q0TrF".substring(0, 16));
//		Date sysDate=new Date();
//		Date date;
//		long time;
//		time=1000*60*60*24*30;//������long�����������ɸ���
//		date=new Date(sysDate.getTime()+1000*60*60*24*30);
//		System.out.println(sysDate);
//		System.out.println(date);
//		System.out.println(time);

//		Calendar calendar;
//		Calendar calendar2;
//		calendar=Calendar.getInstance();
//		System.out.println(calendar.getTime());
//		calendar.add(Calendar.DAY_OF_YEAR, 31);
//		System.out.println(calendar.getTime());
	}
	
	//�ж��Ƿ�Ϊ����
	public static boolean checkNum(String str) {
		//Pattern pattern = Pattern.compile("^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$");
		Pattern pattern = Pattern.compile("^-?\\d+\\.?\\d*$");
		return pattern.matcher(str).matches();
	}
	
	
}
