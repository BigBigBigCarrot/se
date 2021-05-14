package pers.david.se.str;

import org.junit.Test;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月19日
 * @version
 */
public class StringDemo {

	public StringDemo() {
	}

	public static void main(String[] args) {
	}

	@Test
	public void test1() {
		// 通过字面量定义的方式给String 变量赋值
		String s1 = "abc";// 方法区常量池存了一个"abc"
		String s2 = "abc";// 方法区里面只有一个"abc",即上一行创建的那个
		s2 = "hello";// 方法区常量池存了一个"hello"
		String s3 = s2 + " mike";// 方法区常量池存了一个"hello mike"
		String s4 = s3.replace("mike", "jhon");// 方法区常量池存了一个"hello john"
	}

	@Test
	public void test2() {
		// 字面量定义
		String s1 = "a";
		String s2 = "a";

		// new + 构造器的方式
		String s3 = new String("a");// 在堆中存了一个String，值为"a"
		String s4 = new String("a");

		System.out.println(s1 == s2);// true
		System.out.println(s1 == s3);// false
		System.out.println(s1 == s4);// false
		System.out.println(s3 == s4);// false
	}

	@Test
	public void test3() {
		// 字符串拼接
		String s1 = "a";
		String s2 = "b";

		String s3 = "ab";
		String s4 = "a" + "b";
		String s5 = s1 + "b";
		String s6 = "a" + s2;
		String s7 = s1 + s2;
		String s8 = s5.intern();// 返回s5中使用的常量值已经存在的值的地址

		System.out.println(s3 == s4);// true
		System.out.println(s3 == s5);// false
		System.out.println(s3 == s6);// false
		System.out.println(s3 == s7);// false
		System.out.println(s5 == s8);// false
		System.out.println(s5 == s7);// false
		System.out.println(s6 == s7);// false
	}

	@Test
	public void test4() {
		StringTest st = new StringTest();
		st.change(st.str);
	}
	
	/**
	 * 	将给定的字符的某个连续部分反转，比如"abcdefg"反转为"abedcfg"
	 * @param str
	 * @param starIndex
	 * @param endIndex
	 * @return
	 */
	public String reverse1(String str,int starIndex,int endIndex) {
		if(str==null) {
			return "";
		}
		char[] arr=str.toCharArray();
		for (int x=starIndex,y=endIndex; x < y; x++,y--) {
			char temp=arr[x];
			arr[x]=arr[y];
			arr[y]=temp;
		}
		return new String(arr);
	}
	/**
	 * 	将给定的字符的某个连续部分反转，比如"abcdefg"反转为"abedcfg"
	 * @param str
	 * @param starIndex
	 * @param endIndex
	 * @return
	 */
	public String reverse2(String str,int starIndex,int endIndex) {
		if(str==null) {
			return "";
		}
		StringBuilder sb=new StringBuilder(str.length());
		
		sb.append(str.substring(0, starIndex));
		
		for (int i = endIndex; i >= starIndex; i--) {
			sb.append(str.charAt(i));
		}
		
		sb.append(str.substring(endIndex+1, str.length()));
		return sb.toString();
	}

	@Test
	public void test5() {
		String str="abcdefg";
		String reverseStr=reverse1(str,2,5);
		System.out.println(reverseStr);
		String reverseStr2=reverse2(str,2,5);
		System.out.println(reverseStr2);
	}
	
	@Test
	public void test6() {
		String str="ab";
		System.out.println("\"ab\".substring(1,1):"+str.substring(1,1));
		System.out.println("\"ab\".substring(1,2):"+str.substring(1,2));
	}

}

class StringTest {
	String str = new String("abc");

	public void change(String str) {
		str = "def";
		System.out.println(this.str);// abc
		this.str = "def";
		System.out.println(this.str);// def
	}
}
