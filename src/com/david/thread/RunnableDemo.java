package com.david.thread;

class MyThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
		}
	}

}

public class RunnableDemo {
	public static void main(String args[]) {
		MyThread mt1 = new MyThread(); // 实例化对象
		MyThread mt2 = new MyThread(); // 实例化对象
		Thread t1 = new Thread(mt1,"线程A"); // 实例化Thread类对象
		Thread t2 = new Thread(mt2,"线程B"); // 实例化Thread类对象
		t1.start(); // 启动多线程
		t2.start(); // 启动多线程
	}
}
