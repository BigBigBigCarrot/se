package pers.david.se.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author david
 * @Description TODO
 * @Date 2021年05月15日 14:43:00
 */
public class ForEachTester {
    public static void sayHi(String name){
        System.out.println("Hi "+name);
    }

    @Test
    public void f(){
        List<String> names= Arrays.asList("Jack","Mike");
        names.forEach(name->{
            System.out.println("Hi "+name);
        });
//      等价于
        names.forEach(ForEachTester::sayHi);
//      等价于
        Consumer<String> c1=name->{System.out.println("Hi "+name);};
        names.forEach(c1);
//      等价于
        Consumer<String> c2=ForEachTester::sayHi;
        names.forEach(c2);

    }
}
