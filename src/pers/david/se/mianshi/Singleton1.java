package pers.david.se.mianshi;

/**
 * @author Bu Dawei
 * @Description 饿汉模式
 * @date 2020年3月12日
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

}
