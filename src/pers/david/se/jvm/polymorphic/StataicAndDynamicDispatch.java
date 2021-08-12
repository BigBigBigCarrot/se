package pers.david.se.jvm.polymorphic;

import java.util.Scanner;

public class StataicAndDynamicDispatch {

    public StataicAndDynamicDispatch() {
        // TODO Auto-generated constructor stub
    }

    static abstract class Human {
        public abstract void sayHi();
    }

    static class Man extends Human {
        public void sayHi() {
            System.out.println("hi I am man");
        }
    }

    static class Woman extends Human {
        public void sayHi() {
            System.out.println("hi I am woman");
        }
    }

    public static void sayHello(Human person) {
        System.out.println("hello human");
    }

    public static void sayHello(Man person) {
        System.out.println("hello man");
    }

    public static void sayHello(Woman person) {
        System.out.println("hello woman");
    }


    public static void main(String[] args) {
//		staticDispatch();
//		dynamicDispatch();
        dynamicDispatch2();
    }

    /**
     * 静态分派，编译时可知
     */
    public static void staticDispatch() {
        Human man, woman;
        man = new Man();
        woman = new Woman();
        StataicAndDynamicDispatch.sayHello(man);
        StataicAndDynamicDispatch.sayHello(woman);
    }

    /**
     * 动态分派，编译时不可知
     */
    public static void dynamicDispatch() {
        Human man, woman;
        man = new Man();
        woman = new Woman();
        man.sayHi();
        woman.sayHi();
    }

    /**
     * 动态分派，编译时不可知
     */
    public static void dynamicDispatch2() {
        Human person;
        while (true) {
            System.out.println("please type 1 or something else");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                person = new Man();
            } else {
                person = new Woman();
            }
            person.sayHi();
        }
    }

}
