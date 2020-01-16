package com.david.etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.david.vo.Student;


public class Main {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f7();
//		f8();
		comparatorPractice();
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


	/**
	 * This method will return
     * null in such implementations if this class was loaded by the bootstrap
     * class loader
	 */
	public static void f2(){
		ClassLoader classLoader;
		classLoader=String.class.getClassLoader();
		System.out.println(classLoader.getClass().getName());
	}
	
	/**
	 * array.getClass()
	 */
	public static void f3(){
//		System.out.println(Student.class.getName());
		System.out.println(Student.class.getClassLoader().getClass().getName());
	}
	
	/**
	 * Class<?> java.lang.Class.forName(String className)
	 */
	public static void f4(){
		Class cl;
		try{
			cl=Class.forName("java.lang.String");
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
			return;
		}
		System.out.println(cl.getName());
	}
	
//	public static void f6(){
//		Class<Student> cl;
//		try{
//			cl=Class.forName("com.david.vo.Student");
////			cl=Student.class;
//		}catch(ClassNotFoundException e){
//			System.out.println(e.toString());
//			return;
//		}
//		Student stu=cl.newInstance();
//		System.out.println(Student.class.getClassLoader().getClass().getName());
//	}
	
	public static void f7(){
		Class cl;
		try{
//			cl=Class.forName("java.lang.String");
			cl=Class.forName("com.david.vo.Student");
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
			return;
		}
		System.out.println(cl.getProtectionDomain().getCodeSource().getLocation());
	}
	
	public static void f8(){
		String qualifiedName="com.david.vo.CompanyVO";
		System.out.println(qualifiedName.replace(".", "/"));
	}
	
	public static void comparatorPractice() {
		List<Integer> list=new ArrayList();
		list.add(5);
		list.add(3);
		list.add(1);
		list.add(2);
		Collections.sort(list);//升序排列
		
		//降序排列
		Comparator comparator=new Comparator<Integer>(){//匿名内部类
			public int compare(Integer o1, Integer o2) {return -o1.compareTo(o2);}
		};
		list.sort(comparator);
		System.out.println(list.toString());
	}
}
