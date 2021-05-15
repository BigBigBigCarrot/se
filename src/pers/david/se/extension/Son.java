package pers.david.se.extension;

public class Son extends Father {

    public Son() {
        System.out.println("run Son()");
    }

    public void greet() {
        System.out.println("a greeting from son");
    }

    public static void main(String[] args) {
        Father a=new Son();
        a.greet();
        ((Father)a).greet();

    }

}
