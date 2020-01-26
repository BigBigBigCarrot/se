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
	 * 	动态代理的详细写法，附带详细注释，比较好理解
	 */
	public void demo2() {
		Action actionImpl=new ActionImpl();
		Action actionProxyInsatcne=(Action)MyProxyFactory.getProxyInsatcne(actionImpl);//传入的impl不是硬编码，也可以穿其他接口的impl
		System.out.println(actionProxyInsatcne.getClass());//class com.sun.proxy.$Proxy4
		//actionProxyInsatcne是com.sun.proxy.$Proxy4——代理类的实例对象，通过强制类型转换暴露出Action接口定义的方法以供调用，
		//actionProxyInsatcne没有硬编码实现Action定义的接口，而是运行时利用反射动态实现的
		//Object java.lang.reflect.Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		actionProxyInsatcne.doSomething("传入参数1");
		actionProxyInsatcne.sayHi("Jane");
	}
}
class DynamicProxy{
	public Object doThing(String arg) {
		return "successful";
	}
}

class MyProxyFactory{
	/**
	 * 
	 * @param obj 被代理的对象
	 * @return
	 */
	public static Object getProxyInsatcne(Object obj) {
		MyInvocationHandler handler=new MyInvocationHandler();
		handler.bind(obj);
		
		Object proxy=Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
		return proxy;
	}
}

class MyInvocationHandler implements InvocationHandler{
	private Object obj;//需要使用被代理类的对象进行赋值，obj为被代理的对象
	
	public void bind(Object obj) {
		this.obj=obj;
	}
	
	/**
	 * 	通过代理类的对象调用方法时，会自动调用该方法。
	 * 	将被代理类要执行的方法的功能声明在invoke()中
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method);
		System.out.println("=====打印日志1=====");//aop
		Object returnValue=method.invoke(obj, args);//代理对象调用的方法，此方法也作为被代理对象要调用的方法
		System.out.println("=====打印日志2=====");//aop
		
		return returnValue;//returnValue作为被代理的方法的返回值
	}
	
}
