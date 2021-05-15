package pers.david.java8;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Author david
 * @Description
 *  方法引用可以认为是Lambda表达式的一种特殊形式，
 *  Lambda表达式可以让开发者自定义抽象方法的实现代码，
 *  方法引用则可以让开发者直接引用已存在的实现方法，
 *  作为Lambda表达式的Lambda体(参数列表得一致)。
 *  https://blog.csdn.net/lkforce/article/details/99682885
 * @Date 2021年05月15日 13:35:00
 */
public class ConsumerTester {
    public static void sayHi(String name){
        System.out.println("Hi "+name);
    }
    @Test
    public void f(){
//      使用lambda表达式构造一个闭包或者说函数来作为一个函数式接口的实现
        Consumer<String> c=name-> {
            System.out.println("Hi "+name);
        };
        c.accept("Mike");
//      使用方法引用，直接引用现有的方法来作为一个函数式接口的实现
        Consumer<String> c2=ConsumerTester::sayHi;
        c2.accept("Jack");
    }

}
