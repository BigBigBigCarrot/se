package com.david.thread;

/**
 * @Description
 * 	implements Runnable情况下使用synchronized同步方法
 * @author Bu Dawei
 * @date 2020年1月16日
 * @version 
 */
public class SellTicket3 {

	public static void main(String[] args) {
		Window2 Window2=new Window2();
		Thread t1=new Thread(Window2,"t1");
		Thread t2=new Thread(Window2,"t2");
		Thread t3=new Thread(Window2,"t2");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class Window2 implements Runnable{
	private int ticket=50;
	@Override
	public void run() {
		while(true) {
			show();
		}
	}	
	
	private synchronized void show() {//使用this作为同步锁
		if(ticket>0) {
			System.out.println(Thread.currentThread().getName()+"卖票，票号："+ticket);
			ticket--;
			try {
				Thread.sleep(100);//完成抢票后slepp下，给其他线程让出机会，增大切换概率（不加也行）
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.exit(0);
		}
	}
}
