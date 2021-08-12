package pers.david.se.thread;

/**
 * @author Bu Dawei
 * @Description 进程安全示例，如果没有做好同步，则会出现同票号（一个票号卖了多次），票号<0的情况
 * implements Runnable情况下使用synchronized同步代码块
 * @date 2020年1月16日
 */
public class SynchronizedDemo1 {

    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window, "t1");
        Thread t2 = new Thread(window, "t2");
        Thread t3 = new Thread(window, "t2");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 50;

    @Override
    public void run() {
        while (true) {
            /**
             * 	使用synchronized关键字标注的代码块，在同一时间内只能有一个线程执行该代码块
             * 	要求相关的线程都必须使用同一个对象实例来充当锁（不一定要求用this）
             */
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票，票号：" + ticket);
                    ticket--;
                    try {
                        Thread.sleep(100);//完成抢票后slepp下，给其他线程让出机会，增大切换概率（不加也行）
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                break;
            }
        }
    }
}
