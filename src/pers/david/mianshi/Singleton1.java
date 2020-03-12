package pers.david.mianshi;

/**
 * 
 * @Description
 * 	饿汉模式
 * @author Bu Dawei
 * @date 2020年3月12日
 * @version
 */
public class Singleton1 {

	public static final Singleton1 INSTANCE=new Singleton1();
	
	private Singleton1() {
	}

}
