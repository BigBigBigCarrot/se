package pers.david.se.thread;

class MyThread extends Thread {//继承Thread类，作为线程的实现类
    private int count = 5;

    public MyThread(String name) {
        this.setName(name);//通过构造方法配置name属性
    }

    public void run() {//覆写run()方法，作为线程 的操作主体
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + "运行 count=" + count--);
            try {
                sleep((int) Math.random() * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRun implements Runnable {
    private int count = 5;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行 count=" + count--);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * @author Bu Dawei
 * @Description extends Thread 和 implements Runnable的比较
 * @date 2020年1月19日
 */
public class ComparisionDemo {

    public static void main(String[] args) {
        //Thread demostration A和B的count无法共享
//		MyThread th1=new MyThread ("A");
//		MyThread th2=new MyThread ("B");
//		th1.start();
//		th2.start();

        //Runnable demostration 
        //每个线程可以用同一个实例化对象来实现共享mr的内部变量，也可以用不同的实例化对象（不能实现共享mr的内部变量）
        //虽然通过继承Thread的方式跑多线程不能通过一个实例化对象来共享内部变量，但可以给每个Thread实例传入同一个对象实例变量来实现共享，
            // 比如public MyThread(Object obj)//t1=new MyThread(obj1);t2=new MyThread(obj1);
        MyRun mr = new MyRun();
        new Thread(mr, "C").start();
        new Thread(mr, "D").start();
        new Thread(mr, "E").start();
    }

}
