package pers.david.designpattern.proxy;

/**
 * 
 * @Description
 * 	静态代理：是通过proxy持有actionObject的引用，并进行一层封装。
 * 	https://blog.csdn.net/wangqyoho/article/details/77584832
 * @author Bu Dawei
 * @date 2020年1月25日
 * @version
 */
public class StaticProxy implements Action {
	private Action actionObject;

	public StaticProxy(Action actionObject) {
		this.actionObject = actionObject;
	}

	public Object doSomething(String arg) {
		System.out.println("staticProxy do");
		return actionObject.doSomething(arg);
	}
}
