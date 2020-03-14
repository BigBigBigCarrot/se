package pers.david.thread.volatiledemo;

public class VolatileAtomicDemo {

	/**
	 * 总共加了10万次，但count的值不一定是10万，可能小于10万，因为这里的count++不具有原子性
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyVolatileRun myRun = new MyVolatileRun();
		for (int i = 1; i <= 100; i++) {
			new Thread(myRun).start();
		}
	}

}

class MyVolatileRun implements Runnable {
	private int count = 0;

	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			count++;
			System.out.println("count=" + count);
			try {
				Thread.sleep((int) Math.random() * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
