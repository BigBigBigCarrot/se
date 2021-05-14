package pers.david.se.thread.volatiledemo;

/**
 * 
 * @Description
 * 	研究多线程下变量访问的不可见性现象
 * @author Bu Dawei
 * @date 2020年3月12日
 * @version
 */
public class VisibilityDemo3 {

	/**
	 * 效果：main线程读取的flag的值不是最新的被其他线程修改过的值
	 * @param args
	 */
	//线程1：主线程
	public static void main(String[] args) {
		MyThreadV3 t=new MyThreadV3();
		t.start();
		
		while(true) {
			if(t.isFlag()) {
				System.out.println("main： flag="+t.isFlag());
			}
		}
	}
}
class MyThreadV3 extends Thread{
	//解决方法3：用volatile修饰共享变量
	private volatile boolean flag=false;//被volatile修饰的共享变量如果在某个线程中被修改，会通知其他使用到改变了的线程
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag=true;//修改共享成员变量
		System.out.println("MyThreadV.run： flag="+flag);
		
	}
	
	public boolean isFlag() {
		return flag;
	}
}