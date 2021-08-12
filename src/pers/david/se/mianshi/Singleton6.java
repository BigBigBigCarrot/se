package pers.david.se.mianshi;

/**
 * @author Bu Dawei
 * @Description 线程安全的懒汉模式2
 * 静态内部类不会随着外部类的加载和初始化而被加载和初始化，它需要被单独加载和初始化
 * 主动使用内部类的变量导致内部类加载 类加载机制只会加载一次 所以线程安全
 * @date 2020年3月12日
 */
public class Singleton6 {
    private Singleton6() {
    }

    private static class Inner {
        private static Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }
}
