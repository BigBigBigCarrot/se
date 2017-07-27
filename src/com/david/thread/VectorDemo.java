package com.david.thread;
import java.util.Vector;


public class VectorDemo
{

	public static void main(String[] args)
	{
		Vector vector;
		vector=new Vector();
		
		Student[] stu;
		stu=new Student[5];
		
		vector.add("this is the first element");
		vector.add("I am the seconde element");
		vector.add("I am the third element");
		
		System.out.println(vector.get(0));

	}

}
