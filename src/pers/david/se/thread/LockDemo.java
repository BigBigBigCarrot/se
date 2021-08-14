package pers.david.se.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Bu Dawei
 * @Description 进程安全示例，如果没有做好同步，则会出现同票号（一个票号卖了多次），票号<0的情况 implements
 * Runnable情况下使用synchronized同步代码块
 * @date 2020年1月16日
 */
public class LockDemo {
    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Seller seller = new Seller();
        Thread t1 = new Thread(seller, "t1");
        Thread t2 = new Thread(seller, "t2");
        Thread t3 = new Thread(seller, "t2");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Seller implements Runnable {
    private int ticket = 50;

    @Override
    public void run() {
        while (true) {
            LockDemo.reentrantLock.lock();
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，票号：" + ticket);
                ticket--;
                LockDemo.reentrantLock.unlock();
                try {
                    Thread.sleep(100);// 完成抢票后slepp下，给其他线程让出机会，增大切换概率（不加也行）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            LockDemo.reentrantLock.unlock();
            break;
        }
    }
}
