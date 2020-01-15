package com.david.thread;

class Thread3 extends Thread{//继承Thread类，作为线程的实现类
	private int count=5;
	public Thread3(String name) {
		this.setName(name);//通过构造方法配置name属性
	}
	
	public void run() {//覆写run()方法，作为线程 的操作主体
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

class MyRun2 implements Runnable{
	private int count=5;
	
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

public class ComparisionDemo {

	public static void main(String[] args) {
		//Thread demostration A和B的count无法共享
//		Thread3 th1=new Thread3 ("A");
//		Thread3 th2=new Thread3 ("B");
//		th1.start();
//		th2.start();
		
		//Runnable demostration 
		//每个线程可以用同一个实例化对象来实现共享mr的内部变量，也可以用不同的实例化对象（不能实现共享mr的内部变量）
		MyRun2 mr=new MyRun2();
		new Thread(mr,"C").start();
		new Thread(mr,"D").start();
		new Thread(mr,"E").start();
	}

}
