package com.david.thread;

/**
 * @Description
 * 	extends Thread情况下使用synchronized同步代码块
 * @author Bu Dawei
 * @date 2020年1月16日
 * @version 
 */
public class SynchronizedDemo2 {

	public SynchronizedDemo2() {
	}

	public static void main(String[] args) {
		Thread wt1=new WindowThread("wt1");
		Thread wt2=new WindowThread("wt2");
		Thread wt3=new WindowThread("wt3");
		
		wt1.start();
		wt2.start();
		wt3.start();
	}

}

class WindowThread extends Thread{
	private static int ticket=50;
	
	public WindowThread(String name) {
		setName(name);
	}
	
	public void run() {
		while(true) {
			synchronized(WindowThread.class) {
				if(ticket>0) {
					System.out.println(Thread.currentThread().getName()+"卖票，票号："+ticket);
					ticket--;
					try {
						Thread.sleep(100);//完成抢票后slepp下，给其他线程让出机会，增大切换概率（不加也行）
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				break;
			}
		}
	}
}
