package pers.david.se.thread;

/**
 * @author Bu Dawei
 * @Description extends Thread情况下使用synchronized同步方法
 * @date 2020年1月16日
 */
public class SynchronizedDemo4 {

    public SynchronizedDemo4() {
    }

    public static void main(String[] args) {
        Thread wt1 = new WindowThread2("wt1");
        Thread wt2 = new WindowThread2("wt2");
        Thread wt3 = new WindowThread2("wt3");

        wt1.start();
        wt2.start();
        wt3.start();
    }

}

class WindowThread2 extends Thread {
    private static int ticket = 50;

    public WindowThread2(String name) {
        setName(name);
    }

    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() {//同步锁为this.getClass();
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，票号：" + ticket);
            ticket--;
            try {
                Thread.sleep(100);//完成抢票后slepp下，给其他线程让出机会，增大切换概率（不加也行）
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }
}
