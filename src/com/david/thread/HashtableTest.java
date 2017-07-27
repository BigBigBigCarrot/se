package com.david.thread;
import java.util.Hashtable;


public class HashtableTest
{
	public static void main(String[] args)
	{
		Hashtable<Integer, Student> hashtable;
		Student[] stu;
		
		hashtable=new Hashtable<Integer, Student>();
		stu=new Student[5];
		
		stu[0]=new Student("a");
		stu[1]=new Student("b");
		stu[2]=new Student("c");
		stu[3]=new Student("d");
		stu[4]=new Student("e");
		
		for(int i=0;i<=stu.length-1;i++)
		{
			hashtable.put(i, stu[i]);
		}
		
		String str;
		Student stu2=new Student("stu2");
		hashtable.put(0, stu2);
		//str=(hashtable.get(stu[3].hashCode())).id;
		str=(hashtable.get(0)).id;
		System.out.println(str);
		
		str=(hashtable.get(0)).id;
		System.out.println(str);
	}
}
