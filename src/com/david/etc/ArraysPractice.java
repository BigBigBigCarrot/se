package com.david.etc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月15日
 * @version 
 */
public class ArraysPractice {

	/**
	 * 
	 */
	public ArraysPractice() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		fillPractice();
//		copyOfPractice();
//		asListPractice();
		toStringPractice();
	}
	public static void fillPractice() {
		int[] a= {3,5,7,8,2};
		Arrays.fill(a, 6);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
	public static void copyOfPractice() {
		Integer[] a= {3,5,7,8,2};
		Integer[] b=Arrays.copyOf(a, a.length);
		b[0]=0;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
	public static void asListPractice() {
		List list=Arrays.asList(1,2,3);
		System.out.print(list.toString());
	}
	public static void toStringPractice() {
		Integer[] a= {3,5,7,8,2};
		System.out.print(Arrays.toString(a));
	}
}
