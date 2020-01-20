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
import java.util.Vector;

import org.junit.Test;

import com.david.vo.Student;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月20日
 * @version
 */
public class ListDemo {

	public ListDemo() {
	}

	public static void main(String[] args) {

	}

	@Test
	public void vectorDemo1() {
		Vector vector;
		vector = new Vector();

		Student[] stu;
		stu = new Student[5];

		vector.add("this is the first element");
		vector.add("I am the seconde element");
		vector.add("I am the third element");

		System.out.println(vector.get(0));
	}

	public void linkedListDemo() {
		List linkedList = new LinkedList();
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

	public void HashMapDemo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1.0");
		String v;
		v = map.put("key1", "value1.1");
		System.out.println(v);
	}


	public void setDemo() {
		Set set1, set2, set3;
		set1 = new HashSet();
		set1 = new LinkedHashSet();
		set1 = new TreeSet();
	}

	public void collectionsDemo() {
		Collections collections;
	}

}
