package pers.david.se.mianshi;

/**
 * @author Bu Dawei
 * @Description 线程不安全的懒汉模式
 * @date 2020年3月12日
 */
public class Singleton4 {
    private static Singleton4 instance;

    public static Singleton4 getInstance() {
        if (instance == null) {
            //在instance==null时多个线程同时访问会new多次。
            instance = new Singleton4();
        }
        return instance;
    }

    private Singleton4() {
    }

}
