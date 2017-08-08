package com.david.etc;

import com.david.vo.Student;


public class Main {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
	}
	
	/**
	 * 三元运算符
	 */
	public static void f1(){
		int i=1;
		System.out.println(i<2?"i<2":"i>2");
	}
	
	public void HashCodeBuilderPractice(){
//		HashCodeBuilder.appen("name");//org.apache.commons.lang.builder;
	}

	public static void f2(){
		ClassLoader cl;
//		cl="".getClass().getClassLoader();
		cl=String.class.getClassLoader();
		System.out.println(cl.getClass().getName());
		
	}
	
	public static void f3(){
//		System.out.println(Student.class.getName());
		System.out.println(Student.class.getClassLoader().getClass().getName());
	}
}
