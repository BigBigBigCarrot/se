package pers.david.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @Description
 * 	没有实现类但是在运行期动态创建了一个接口对象的方式，我们称为动态代码。JDK提供的动态创建接口对象的方式，就叫动态代理
 * @author Bu Dawei
 * @date 2020年1月25日
 * @version
 */
public class DynamicProxyDemo {

	public static void main(String[] args) {
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method);
				if (method.getName().equals("doSomething")) {
					System.out.println("hi "+args[0]);
				}
				return null;
			}
		};
		Action action = (Action) Proxy.newProxyInstance(Action.class.getClassLoader(), // 传入ClassLoader
				new Class[] { Action.class }, // 传入要实现的接口
				handler); // 传入处理调用方法的InvocationHandler
		action.doSomething("jack");
	}

}
