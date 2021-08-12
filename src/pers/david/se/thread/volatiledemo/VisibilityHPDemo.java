package pers.david.se.thread.volatiledemo;

/**
 * @author Bu Dawei
 * @Description volatile写读建立的happens-before关系研究
 * 总规则：
 * 如果线程1写入了volatile变量v（临界资源）
 * 接着线程2读取了v，那么，线程1写入v及之前的写操作都对线程2课件（线程1和线程2可以是同一个线程）
 * @date 2020年3月15日
 */
public class VisibilityHPDemo {
    private int a = 1;
    private int b = 2;
//	volatile private int b=2;

    public void write() {
        a = 3;
        b = a;
    }

    public void read() {
        System.out.println("a=" + a + " b=" + b);
    }

    public static void main(String[] args) {
        while (true) {
            final VisibilityHPDemo v = new VisibilityHPDemo();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    v.write();
                }

            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    v.read();
                }

            }).start();

            if (v.b == 2 && v.a == 3) {
                break;
            }
        }
    }

}
