package com.david.reflection;

import java.lang.reflect.Array;

public class ArrayTest {

	public ArrayTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		f1();
	}
	
	/**
	 * new instance
	 */
	public static void f1(){
//		String[] strArray1={"1","2"};
		String[] strArray2=(String[])Array.newInstance(String.class, 2);
		strArray2[0]="3";
		strArray2[1]="4";
		for (String string : strArray2) {
			System.out.println(string);
		}
	}

}
