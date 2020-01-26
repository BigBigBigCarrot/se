package pers.david.designpattern.proxy;

/**
 * 
 * @Description
 * 	<p>静态代理：是通过proxy持有actionObject的引用，并进行一层封装。</p>
 * 	<p>https://blog.csdn.net/wangqyoho/article/details/77584832</p>
 * 	<p>
	 * 	<br>比如说想要在调用Action接口实现类的方法ActionImpl.doSomething的时候添加一些功能（例如在执行方法的前后打日志），但又不想改动接口实现方法的源代码ActionImpl，</br>
	 * 	<br>则可以选择通过代理的方式，例如静态代理类StaticProxy内部维护了一个Action对象字段，且StaticProxy也实现了接口，</br>
	 * 	<br>在StaticProxy实现Action方法的代码中调用Action.doSomething(); 然后再其前后打印日志，这样就不用改动ActionImpl。</br>
	 * 	<br>缺点：假设一个项目的很多这种操作都要在前后打日志，那每个操作都要去手写一个静态代理，每个静态代理都要维护这些实现类的字段，都要implements对应的接口，</br>
	 * 	<br>代码量很重复、工作量很大</br>
 * </p>
 * @author Bu Dawei
 * @date 2020年1月25日
 * @version
 */
public class StaticProxy implements Action {
	private Action actionImpl;

	public StaticProxy() {
		this.actionImpl = new ActionImpl();
	}

	public Object doSomething(String arg) {
		
		System.out.println("=====print log before doSomething=====");
		Object result= actionImpl.doSomething(arg);
		System.out.println("=====print log after doSomething=====");
		
		return result;
	}

	@Override
	public Object sayHi(String name) {
		System.out.println("=====print log before sayHi=====");
		Object result= actionImpl.sayHi(name);
		System.out.println("=====print log after sayHi=====");
		
		return result;
	}
}
