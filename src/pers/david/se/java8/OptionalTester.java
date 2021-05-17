package pers.david.se.java8;
/**
 * @Author： bdawei@linewell.com
 * @Description：
 * @Data Created：in10:53 2021/5/17
 * @Modify By：
 **/

import org.junit.Test;

import java.util.Optional;

/**
 * @Author david
 * @Description TODO
 * @Date 2021年05月17日 10:53:00
 */

public class OptionalTester {
    static class A{
        B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        public A(B b) {
            this.b = b;
        }
    }
    static class B{
        C c;

        public C getC() {
            return c;
        }

        public void setC(C c) {
            this.c = c;
        }

        public B(C c) {
            this.c = c;
        }
    }
    static class C{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public C(String name) {
            this.name = name;
        }
    }

    public static A getInstanceOfA(){
        // C c=new C("Jack");
        C c=null;
        B b=new B(c);
        A a=new A(b);
        return a;
    }

    @Test
    public void testJava7Demo(){
        A a=OptionalTester.getInstanceOfA();
        //频繁判null，if嵌套，代码长，可读性差
        String name=null;
        if (a != null&&a.getB()!=null) {
            B b=a.getB();
            if (b.getC() != null) {
                C c=b.getC();
                name=c.getName();
            }
        }
        if (null==name){
            name="Mike";
        }
        System.out.println(name);

    }

    @Test
    public void testJava8DemoMap(){
        A instanceOfA=OptionalTester.getInstanceOfA();
        Optional<A> optionalA=Optional.ofNullable(instanceOfA);
        //链式调用，更简洁，不用频繁的判null
        String name=optionalA.map(a->a.getB()).map(b->b.getC()).map(c->c.getName()).orElse("Mike");
        System.out.println(name);
    }

    @Test
    public void testJava8Demo2FlatMap(){
        A instanceOfA=OptionalTester.getInstanceOfA();
        Optional<A> optionalA=Optional.ofNullable(instanceOfA);
        //flatMap需要自己在闭包里面封装成Optional，而map是帮用户封装好
        String name =optionalA.flatMap(a->Optional.ofNullable(a.getB())).flatMap(b->Optional.ofNullable(b.getC())).flatMap(c->Optional.ofNullable(c.getName())).orElse("Mike");
        System.out.println(name);
    }

}