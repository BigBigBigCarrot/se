package pers.david.collections;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月15日
 * @version 
 */
public class ArraysDemo {

	/**
	 * 
	 */
	public ArraysDemo() {
	}

	/**
	 * @param args
	 */
	public void main(String[] args) {
	}
	
	/**
	 * Arrays.fill：将所有元素填充或替换为指定元素
	 */
	@Test
	public void fillPractice() {
		int[] a= {3,5,7,8,2};
		Arrays.fill(a, 6);
		System.out.print(Arrays.toString(a));
	}
	/**
	 * Arrays.copyOf：复制数组
	 */
	@Test
	public void copyOfPractice() {
		Integer[] a= {3,5,7,8,2};
		Integer[] b=Arrays.copyOf(a, a.length);
		b[0]=0;
		System.out.print(Arrays.toString(a));
	}
	/**
	 * 	Arrays.asList:转化为List
	 */
	@Test
	public void asListPractice() {
		List list=Arrays.asList(1,2,3);
		System.out.print(list.toString());
	}
	
	/**
	 * Arrays.toString：转换为形如[3, 5, 7, 8, 2]样式的字符串
	 */
	@Test
	public  void toStringPractice() {
		Integer[] a= {3,5,7,8,2};
		System.out.print(Arrays.toString(a));
	}
	
}
