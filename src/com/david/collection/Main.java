package com.david.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Integer> list;
		list=new ArrayList<Integer>();
		list.add(0);
		list.add(-1);
		list.add(-2);
		
		
		Integer[] numbers=(Integer[])list.toArray(new Integer[0]);
		//System.out.println(numbers[1]);
		
		Object[] o=list.toArray();
		//System.out.println((Integer)o[2]);
		

		List<Integer> list2;
		list2=new ArrayList<Integer>();
		list2.add(0);
		list2.add(-1);
		list2.add(-2);
		
		//System.out.println(list.containsAll(list2));
		
		list.addAll(list2);
		//System.out.println(list.size());
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		
		Set<String> set=map.keySet();
		for(String str:set.toArray(new String[0])){
			System.out.println(str);
		}
		
	}

}
