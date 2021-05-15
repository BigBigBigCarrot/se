package pers.david.se.thread.volatiledemo;

/**
 * 
 * @Description
 * 	研究多线程下变量访问的不可见性现象
 * @author Bu Dawei
 * @date 2020年3月12日
 * @version
 */
public class VisibilityDemo2 {

	/**
	 * 效果：main线程读取的flag的值不是最新的被其他线程修改过的值
	 * @param args
	 */
	//线程1：主线程
	public static void main(String[] args) {
		MyThreadV2 t=new MyThreadV2();
		t.start();
		
		while(true) {
			synchronized (t) {//解决方法1：加并发锁，
				//原理：加锁的代码每次清空工作内存的数据，然后去主内存中读取最新的共享变量的值到本线程的副本中
				if(t.isFlag()) {
					System.out.println("main： flag="+t.isFlag());
				}
			}
		}
	}
}
class MyThreadV2 extends Thread{
	private boolean flag=false;
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