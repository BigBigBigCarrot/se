package pers.david.se.thread.volatiledemo;

/**
 * @author Bu Dawei
 * @Description 研究指令重排序可能带来的问题
 * @date 2020年3月12日
 */
public class OutOfOrder2 {
    public volatile static int a = 0;//使用volatile关键字禁止指令重排序
    public volatile static int b = 0;

    public volatile static int i = 0;
    public volatile static int j = 0;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while (true) {
            count++;
            a = 0;
            b = 0;
            i = 0;
            j = 0;
            // 线程1
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    i = b;
                }

            });

            // 线程2
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    j = a;
                }

            });

            t1.start();
            t2.start();
            t1.join();// 等待线程1执行完
            t2.join();// 等待线程2执行完

            System.out.println("第" + count + "次执行结果");
            System.out.println("i=" + i);
            System.out.println("j=" + j);

            if (i == 0 && j == 0) {
                break;
            }
        }
        // 重复执行多次后可能出现i==0,j==0
    }
}
