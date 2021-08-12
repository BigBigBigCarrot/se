package pers.david.se.thread.volatiledemo;

public class VolatileAtomicDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyVolatileRun2 myRun = new MyVolatileRun2();
        for (int i = 1; i <= 100; i++) {
            new Thread(myRun).start();
        }
    }

}

class MyVolatileRun2 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            synchronized (this) {// 加线程锁保证操作的原子性
                count++;
            }
            System.out.println("count=" + count);
            try {
                Thread.sleep((int) Math.random() * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
