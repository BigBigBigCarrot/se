package pers.david.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * 
 * @Description 
 * 	没有实现类但是在运行期动态创建了一个接口对象的方式，我们称为动态代码。JDK提供的动态创建接口对象的方式，就叫动态代理。
 * 	aop基本就是利用动态代理实现的
 * @author Bu Dawei
 * @date 2020年1月25日
 * @version
 */
public class DynamicProxyDemo {

	public static void main(String[] args) {
	}

	@Test
	/**
	 * 	动态代理的简易写法，不是特别好理解
	 */
	public void demo1() {
		InvocationHandler handler = new InvocationHandler() {// 创建了接口InvocationHandler的匿名内部类实现的实例
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method);
				if (method.getName().equals("doSomething")) {
					System.out.println("hi " + args[0]);
				}
				return "successful";
			}
		};
		Action action = (Action) Proxy.newProxyInstance(Action.class.getClassLoader(), // 传入ClassLoader
				new Class[] { Action.class }, // 传入要实现的接口
				handler); // 传入处理调用方法的InvocationHandler
		Object result = action.doSomething("jack");
		System.out.println("result： " + result);
	}

	@Test
	/**
	 * 	动态代理的详细写法，比较好理解
	 */
	public void demo2() {
		Action actionImpl=new ActionImpl();//生成一个接口实现类的实例
		Action actionProxyInsatcne=(Action)MyProxyFactory.getProxyInsatcne(actionImpl);//获取Action的动态代理对象，
			//动态代理在调用接口方法的时候会调用传入的actionImpl中的对应方法，并且可以在调用actionImpl方法的前后定义一系列其他的操作，即AOP(比如前后打印日志)
			//由于动态代理是软编码，传入的impl不仅可以是Action的实现类实例,也可以传其他接口的实现类实例，所以这一套流程中额外的AOP操作对其他所有接口都有效
		System.out.println(actionProxyInsatcne.getClass());//class com.sun.proxy.$Proxy4
			//actionProxyInsatcne是com.sun.proxy.$Proxy4——代理类的实例对象，通过强制类型转换暴露出Action接口定义的方法以供调用，
			//actionProxyInsatcne没有硬编码实现Action定义的接口，而是运行时利用反射动态实现的
			//Object java.lang.reflect.Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		actionProxyInsatcne.doSomething("传入参数1");//不但执行了ActionImpl中对应的实现方法，同时还有动态代理对象的handler种定义的AOP代码
		actionProxyInsatcne.sayHi("Jane");//不但执行了ActionImpl中对应的实现方法，同时还有动态代理对象的handler种定义的AOP代码
		System.out.println(actionProxyInsatcne);
		System.out.println(actionProxyInsatcne.getClass());//class com.sun.proxy.$Proxy4	说明该实例是代理其实是对象
	}
}

class MyProxyFactory{
	/**
	 * 
	 * @param implementation 被代理的接口的实现类的实例
	 * @return
	 */
	public static Object getProxyInsatcne(Object implementation) {
		MyInvocationHandler handler=new MyInvocationHandler();
		handler.bind(implementation);
		
		Object proxy=Proxy.newProxyInstance(implementation.getClass().getClassLoader(), implementation.getClass().getInterfaces(), handler);
		//第一个参数是要生成的接口实现类的ClassLoader，通过ClassLoader来动态生成实例
		//第二个参数为接口数组，即这个动态代理对外提供哪些接口代理
		//第三个参数是handler，通过handler
		return proxy;
	}
}

class MyInvocationHandler implements InvocationHandler{
	private Object implementation;//接口的实现类的实例（Object类型，什么都可以放，不一定只能放ActionImpl，软编码）
	
	public void bind(Object implementation) {
		this.implementation=implementation;
	}
	
	/**
	 * 	通过代理类的对象调用接口方法时，会自动调用该方法。
	 * 	invoke除了调用绑定的imple种对应的方法，还在执行的前后定义了一些列AOP操作
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method);
		System.out.println("=====打印日志1=====");//aop
		Object returnValue=method.invoke(implementation, args);//根据方法名签名调用对应的implementation中对应的实现方法
		System.out.println("=====打印日志2=====");//aop
		
		return returnValue;//returnValue作为被代理的方法的返回值
	}
	
}
