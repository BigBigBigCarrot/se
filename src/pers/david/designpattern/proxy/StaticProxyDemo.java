package pers.david.designpattern.proxy;

public class StaticProxyDemo {

	public static void main(String[] args) {
		StaticProxy proxy = new StaticProxy(new ActionObject());
	    proxy.doSomething("hey");
	}
}
