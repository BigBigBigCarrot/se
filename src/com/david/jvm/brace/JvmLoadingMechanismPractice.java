package com.david.jvm.brace;

/**
 * 
 * @Description: 虚拟机的类加载机制
 * 类加载到虚拟机的步骤、生命周期：
 * 	加载->验证->准备->解析(resolution)->初始化->使用->卸载
 * [验证->准备->解析]统称为linking
 * @author dawei.bu<22597001@qq.com>
 * @version v1.0
 * @date 2017年7月29日
 *
 */
public class JvmLoadingMechanismPractice
{
	/**
	 * static语句块
	 */
	static
	{
		System.out.println("BracePractice static{1}");
	}

	static
	{
		System.out.println("BracePractice static{1}");
	}

	/**
	 * 执行一个类的main方法时会初始化这个类，所以会触发static语句块
	 * @Description: 
	 * @date 2017年7月29日
	 * @param args
	 */
	public static void main(String[] args)
	{
//		f1();
//		f2();
		int a=ClassA.A_CONSTANT_VALUE;//使用静态变量[或常量]，不触发static语句块(静态变量编译期间即可确定)
//		ClassA.staticFunction();//调用静态方法，触发static语句块s
//		ClassA classA;//声明一个ClassA的reference，不初始化ClassA这个类，也就不触发static语句块
//		classA=new ClassA();//首次new 一个ClassA的实例，初始化ClassA这个类，触发static语句块，且先于构造函数执行;
//		classA=new ClassA();//第二次new 一个ClassA的实例，ClassA的信息此前已被初始化，故此时不再触发static语句块
	}

	/**
	 * 大括号用法测试1
	 * @Description: 
	 * @date 2017年7月29日
	 */
	public static void f1(){
//		 //此段代码无法无法通过编译，调用System.out.println(a);时找不到变量a
//		 {
//		 int a=1;
//		 a++;
//		 }
//		 System.out.println(a);
	}

	/**
	 * 大括号用法测试2
	 * @Description: 
	 * @date 2017年7月29日
	 */
	public static void f2(){
		int a = 1;
		{
			a++;
		}
		System.out.println(a);
	}
	

}
