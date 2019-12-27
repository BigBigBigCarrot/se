package com.david.thread;

class MyRun implements Runnable {
	private int count=5;
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+"运行 count="+count--);
			try {
				Thread.sleep((int)Math.random()*10);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

public class RunnableDemo {
	public static void main(String args[]) {
		MyRun mr1 = new MyRun(); // 实例化对象
		MyRun mr2 = new MyRun(); // 实例化对象
		//每个线程可以用同一个实例化对象来实现共享mt1的内部变量，也可以用不同的实例化对象（不能实现共享mt1的内部变量）
		Thread t1 = new Thread(mr1,"线程A"); // 实例化Thread类对象，
		Thread t2 = new Thread(mr1,"线程B"); // 实例化Thread类对象
		Thread t3 = new Thread(mr2,"线程C"); // 实例化Thread类对象
		t1.start(); // 启动多线程
		t2.start(); // 启动多线程
		t3.start(); // 启动多线程
	}
}
