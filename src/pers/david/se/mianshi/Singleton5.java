package pers.david.se.mianshi;

/**
 * 
 * @Description
 * 	线程安全的懒汉模式
 * @author Bu Dawei
 * @date 2020年3月12日
 * @version
 */
public class Singleton5 {
	private static Singleton5 instance;
	
	/**
	 * 	低效率
	 * @return
	 */
//	public static Singleton5 getInstance() {
//		synchronized (Singleton5.class) {//每次获取都要锁一下
//			if(instance==null) {
//				instance=new Singleton5();
//			}
//		}
//		return instance;
//	}
	
	/**
	 * 	高效率
	 * @return
	 */
	public static Singleton5 getInstance() {
		if(instance==null) {//已经new后不用锁一下
			synchronized (Singleton5.class) {
				if(instance==null) {
					instance=new Singleton5();
				}
			}
		}
		return instance;
	}
	
	private Singleton5() {
	}

}
