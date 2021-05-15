package pers.david.java8;

import org.junit.Test;

/**
 * @Author david
 * @Description TODO
 * @Date 2021年05月14日 23:38:00
 */
public class FunctionalIinterfaceDemo {
    @Test
    public void firstFunctionalInterfaceTest(){
        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        greetService1.sayMessage("Jack");

        GreetingService greetService2 = m -> System.out.println("Hello " + m);
        greetService1.sayMessage("Mike");
    }
}
