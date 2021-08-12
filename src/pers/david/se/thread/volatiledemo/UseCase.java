package pers.david.se.thread.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bu Dawei
 * @Description volatile使用场景介绍：
 * 1.适合做纯赋值操作，不适合做a++等运算操作
 * @date 2020年3月15日
 */
public class UseCase implements Runnable {
    private volatile boolean flag = false;
    public AtomicInteger atomicInteger = new AtomicInteger();

    public UseCase() {
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            switchFlag();
            atomicInteger.incrementAndGet();
        }
    }

    private void switchFlag() {
        //纯赋值操作具有原子性，使用volatile修饰后可保证赋值后并发下各个线程对变量的修改可见，结果符合预期
        flag = true;
        //运算操作本身不具有原子性，结果可能不符合预期，
        //比如10000次后应该是false,但使用volatile修饰后仅可保证赋值后并发下各个线程对变量的修改可见，
        //但不能保证运算本身的原子性。
//		flag=!flag;
    }

    public static void main(String[] args) throws InterruptedException {
        UseCase uc = new UseCase();
        Thread t1 = new Thread(uc);
        Thread t2 = new Thread(uc);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(uc.isFlag());
        System.out.println(uc.atomicInteger.get());
    }
}
