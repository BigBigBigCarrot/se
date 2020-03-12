package pers.david.mianshi;

import org.junit.Test;

public class Increment {

	public static void main(String[] args) {
	}
	
	/**
	 * 	++i和i++都是自增操作，不入栈，其中++i是先对i对自增，然后把i的数值入栈，i++是先把i的数值入栈，然后先对i对自增。
		赋值操作，即=总是最后执行。
		操作数栈存储的是基本变量的数值，比如i=4入栈，然后i自增为5，出栈刚才入栈的数值仍为4。
	 */
	@Test
	public void f0() {
		int i = 1;//i赋值为1
		int temp = i++;//①i的值1入栈 ②i++执行自增且不经过操作数栈，故i=2 ③1出栈赋值给temp，所以temp=1（赋值=最后计算）
		System.out.println("temp=" + temp);//1
		System.out.println("i="+i);//2
	}
	
	@Test
	public void f1() {
		int i=1;
		i=i++;//①i的值1入栈 ②i++执行自增且不经过操作数栈，故i=2 ③1出栈赋值给i，所以i=1
		System.out.println("i="+i);//1
	}
	
	@Test
	public void f2() {
		int i=1;
		i=i++;//①i的值1入栈 ②i++执行自增且不经过操作数栈，故i=2 ③1出栈赋值给i，所以i=1
//		System.out.println("i="+i);i=1
		int j=i++;//j=1,i=2
		/**
		 * ①i的值2入栈
		 * ②++i执行自增（不入栈）故i=3，然后入栈i的值3
		 * ③出栈3与i=3做乘法，结果为9，然后入栈数值9，并且i++自增，故i=3+1=4
		 * ④出栈数值9和2并做加法，结果为11
		 */
		int k=i+ ++i * i++;
		System.out.println("i="+i);//4
		System.out.println("j="+j);//1
		System.out.println("k="+k);//11
	}
}
