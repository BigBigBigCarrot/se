package com.david.collections;

import java.util.LinkedList;
import java.util.List;
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
	public void comparisonDemo() {
		
	}
	
	@Test
	public void vectorDemo() {
		Vector<String> vector;
		vector = new Vector();

		Student[] stu;
		stu = new Student[5];

		vector.add("element1");
		vector.add("element2");
		vector.add("element3");

		System.out.println(vector.get(0));
		System.out.println(vector.toString());
	}

	public void linkedListDemo() {
		List linkedList = new LinkedList();
	}
	
}
