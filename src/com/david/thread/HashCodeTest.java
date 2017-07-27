package com.david.thread;

public class HashCodeTest
{
	public static void main(String[] args)
	{
		Student s1,s2;
		s1=new Student("s1");
		s2=new Student("s1");
		
		
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		s2=s1;
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		/*
		HashCodeTest[] h;
		h=new HashCodeTest[100];
		for(int i=0;i<=h.length-1;i++)
		{
			h[i]=new HashCodeTest();
			System.out.println(h[i].hashCode());
		}
		*/
	}
}
