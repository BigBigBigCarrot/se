package com.david.thread;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月16日
 * @version
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
