package pers.david.jvm.loading;

public class ClassA
{
	static int aStaticValue=0;
	static final int A_CONSTANT_VALUE=1;
	static ClassA[] arrayA=new ClassA[1];

	public static void main(String[] args)
	{
		System.out.println("execute main block");
	}
	
	static
	{
		System.out.println("execute ClassA static{1}");
	}
	

	public ClassA(){
		System.out.println("执行ClassA构造函数");
	}

	public static void staticFunction(){
		System.out.println("执行ClassA的静态方法");
	}
	

}
