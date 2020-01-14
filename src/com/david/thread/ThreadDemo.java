package com.david.thread;

class MyThread2 extends Thread { // 继承Thread类，作为线程的实现类
	private int count=5;
	public MyThread2(String name) {
		setName(name); // 通过构造方法配置name属性
	}

	public void run() { // 覆写run()方法，作为线程 的操作主体
		for (int i = 0; i < 5; i++) {
			System.out.println(this.getName()+"运行 count="+count--);
			try {
				sleep((int)Math.random()*10);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread2 mt1 = new MyThread2("线程A "); // 实例化对象
		MyThread2 mt2 = new MyThread2("线程B "); // 实例化对象
		mt1.start(); // 调用线程主体
		mt2.start(); // 调用线程主体
	}

}