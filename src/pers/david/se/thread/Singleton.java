package pers.david.se.thread;

/**
 * @author Bu Dawei
 * @Description 线程安全的单例模式
 * @date 2020年1月16日
 */
public class Singleton {

    private Singleton() {
    }

    private static Singleton instance = null;

    // 效率低
//	public static Singleton getInstance() {
//		synchronized (Singleton.class) {
//			if (instance == null) {
//				instance = new Singleton();
//			}
//			return instance;
//		}
//
//	}

    // 效率更高
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
