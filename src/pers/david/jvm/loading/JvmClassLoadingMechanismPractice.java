package pers.david.jvm.loading;

/**
 * 
 * 虚拟机的类加载机制
 * 类加载到虚拟机的步骤、生命周期：
 * 	加载->验证->准备->解析(resolution)->初始化->使用->卸载
 * [验证->准备->解析]统称为linking
 * @author dawei.bu<22597001@qq.com>
 * @version v1.0
 * @date 2017年7月29日
 *
 */
public class JvmClassLoadingMechanismPractice
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
		System.out.println("BracePractice static{2}");
	}

	/**
	 * 执行一个类的main方法时会初始化这个类，所以会触发static语句块
	 * @Description: 
	 * @date 2017年7月29日
	 * @param args
	 */
	public static void main(String[] args)
	{
		f0();
		
//		f1();
//		f2();
	}
	
	/**
	 * JVM的类加载机制测试
	 * @Description: 
	 * @date 2017年7月29日
	 */
	public static void f0(){
//		int a=ClassA.aStaticValue;//使用未被final修饰的静态变量，需要加载类信息，会触发static语句块;
//		int b=ClassA.A_CONSTANT_VALUE;//使用被final关键字修饰的静态变量，在编译时就放入常量池，调用该变量不加载类，不触发static语句块
//		ClassA.staticFunction();//调用静态方法，触发static语句块s
//		ClassA classA;//声明一个ClassA的reference，不初始化ClassA这个类，也就不触发static语句块
//		classA=new ClassA();//首次new 一个ClassA的实例，初始化ClassA这个类，触发static语句块，且先于构造函数执行;
//		classA=new ClassA();//第二次new 一个ClassA的实例，ClassA的信息此前已被初始化，故此时不再触发static语句块
		{}//需要加载一个类，且这个类的父类尚未初始化时，会初始化父类
		ClassA[] arrayA=ClassA.arrayA;//触发ClassA中的static语句块
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
