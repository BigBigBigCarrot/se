package pers.david.se.designpattern.proxy;

public class ActionImpl implements Action {
    @Override
    public Object doSomething(String arg) {
        System.out.println("ActionImpl do something ,arg: "+arg);
        return "doSomething successfully";
    }

    @Override
    public Object sayHi(String name) {
        System.out.println("ActionImpl says hi "+name);
        return "sayHi successfully";
    }
}