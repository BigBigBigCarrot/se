package com.david.thread;

class Thread3 extends Thread{
	private int count=5;
	public Thread3(String name) {
		this.setName(name);//Thread中自带name
	}
	
	public void run() {
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

class Thread4 implements Runnable{
	private int count=5;
//	private String name;
//	public Thread4(String name) {
//		this.name=name;
//	}
	
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
		Thread3 th1=new Thread3 ("A");
		Thread3 th2=new Thread3 ("B");
		th1.start();
		th2.start();
		
		//Runnable demostration 
		//每个线程可以用同一个实例化对象
//		Thread4 th3=new Thread4();
//		new Thread(th3,"C").start();
//		new Thread(th3,"D").start();
//		new Thread(th3,"E").start();
	}

}
