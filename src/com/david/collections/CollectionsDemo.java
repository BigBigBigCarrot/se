package com.david.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月21日
 * @version 
 */
public class CollectionsDemo {

	public CollectionsDemo() {
	}

	public static void main(String[] args) {

	}
	
	@Test
	public void sortDemo() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(2);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("invoke Collections.sort(List<T> list)");
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

}
