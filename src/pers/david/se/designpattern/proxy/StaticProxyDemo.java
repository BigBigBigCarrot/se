package pers.david.se.designpattern.proxy;

public class StaticProxyDemo {

    public static void main(String[] args) {
        StaticProxy proxy = new StaticProxy();
        proxy.doSomething("hey");
        proxy.sayHi("mike");
    }
}