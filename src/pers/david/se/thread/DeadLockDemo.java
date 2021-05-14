package pers.david.se.thread;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月16日
 * @version
 */
public class DeadLockDemo {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public DeadLockDemo() {
	}

	public static void main(String[] args) {
		MyRun1 myRun1 = new MyRun1();
		MyRun2 myRun2 = new MyRun2();
		new Thread(myRun1,"t1").start();;
		new Thread(myRun2,"21").start();;
	}
}

class MyRun1 implements Runnable {
	@Override
	public void run() {
		synchronized (DeadLockDemo.lock1) {
			System.out.print("a");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			synchronized (DeadLockDemo.lock2) {
				System.out.print("b");
			}
		}
	}
}

class MyRun2 implements Runnable {
	@Override
	public void run() {
		synchronized (DeadLockDemo.lock2) {
			System.out.print("c");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			synchronized (DeadLockDemo.lock1) {
				System.out.print("d");
			}
		}
	}
}
