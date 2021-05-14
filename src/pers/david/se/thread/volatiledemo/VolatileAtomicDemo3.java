package pers.david.se.thread.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicDemo3 {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyVolatileRun3 myRun=new MyVolatileRun3();
		for (int i = 1; i <= 100; i++) {
			new Thread(myRun).start();
		}
	}

}

class MyVolatileRun3 implements Runnable{
	private AtomicInteger count=new AtomicInteger(0);//使用原子类保证自增的原子性
	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			count.incrementAndGet();//先递增再获取
			System.out.println("count="+count);
			try {
				Thread.sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
