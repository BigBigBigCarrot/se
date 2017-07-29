package com.david.jvm.brace;

public class ClassA
{
	static final int A_CONSTANT_VALUE=1;
	
	static
	{
		System.out.println("ExampleClass static{1}");
	}
	

	public ClassA(){
		System.out.println("执行ClassA构造函数");
	}

	public static void staticFunction(){
		System.out.println("执行ClassA的静态方法");
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
