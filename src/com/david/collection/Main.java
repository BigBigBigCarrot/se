package com.david.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		sortPractice();
	}
	public static void linkedListPractice(){
		List linkedList=new LinkedList();
	}
	public static void sortPractice(){
		List<Integer> list=new ArrayList<Integer>();
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
	
	public static void HashMapPractice(){
		Map map=new HashMap();
	}
	
	

}
