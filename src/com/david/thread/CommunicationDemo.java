package com.david.thread;
/**
 * 
 * @Description
 * 	线程通信
 * 	1.实现两个线程交替打印
 * @author Bu Dawei
 * @date 2020年1月18日
 * @version
 */
public class CommunicationDemo {

	public CommunicationDemo() {
	}

	public static void main(String[] args) {
		Printer p=new Printer();
		Thread t1=new Thread(p,"t1");
		Thread t2=new Thread(p,"t2");
		
		t1.start();
		t2.start();
	}

}

class Printer implements Runnable{
	private int number=1;
	@Override
	public void run() {
		while(true) {
			synchronized(this) {
//				this.notify();//唤醒一个线程（按高优先级排序），同一个锁.notify
				this.notifyAll();//唤醒所有线程
				if(number<=100) {
					System.out.println(Thread.currentThread().getName()+" "+number);
					number++;
					try {
//						Thread.sleep(10);//阻塞自己，但是不释放锁。可以在任何场景下调用
						wait();//阻塞自己，并且释放锁。只能在同步代码块或方法中调用
					}catch (Exception e) {
						e.printStackTrace();
					}
					
				}else {
					break;
				}
			}
		}
	}
}