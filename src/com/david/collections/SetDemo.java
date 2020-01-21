package com.david.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 
 * @Description
 * @author Bu Dawei
 * @date 2020年1月20日
 * @version
 */
public class SetDemo {

	public SetDemo() {
	}
	

	public static void main(String[] args) {

	}
	
	public void comparison() {
		Set hashSet=new HashSet();
		Set linkedHashSet=new LinkedHashSet();
		Set treeSet=new TreeSet();
	}
	
	@Test
	public void treeSetDemo() {
		TreeSet ts=new TreeSet();
		ts.add(5);
		ts.add(3);
		ts.add(2);
//		ts.add("a");//不能添加不同类的对象实例
		//TreeSet会调用compareTo方法进行升序排序
		Iterator it=ts.iterator();
		while (it.hasNext()) {
			Integer type = (Integer) it.next();
			System.out.println(type);
		}
	}

}
