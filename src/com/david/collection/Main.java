package com.david.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		sortPractice();
		HashMapPractice();
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
		Map<String,String> map=new HashMap<String,String>();
		map.put("key1", "value1.0");
		String v;
		v=map.put("key1", "value1.1");
		System.out.println(v);
	}
	
	public static void collectionPractice(){
		Collection collection;
	}
	
	public static void setPractice(){
		Set set1,set2,set3;
		set1=new HashSet();
		set1=new LinkedHashSet();
		set1=new TreeSet();
	}
	
	

}
