package pers.david.se.thread.volatiledemo;

/**
 * @author Bu Dawei
 * @Description 研究多线程下变量访问的不可见性现象
 * @date 2020年3月12日
 */
public class VisibilityDemo1 {

    /**
     * 效果：main线程读取的flag的值不是最新的被其他线程修改过的值
     * 原因：共享变量存放在主内存中，每个线程使用共享变量会拷贝一份副本到自己的工作内存中，如果修改了会再把修改的值写到主内存中，
     * 可能存在有线程中使用的共享变量的值不是最新的，比如本例中的main方法线程中如果不做特殊处理，不会去读取最新的值。
     *
     * @param args
     */
    //线程1：主线程
    public static void main(String[] args) {
        MyThreadV t = new MyThreadV();
        t.start();

        while (true) {
            if (t.isFlag()) {
                System.out.println("main： flag=" + t.isFlag());
            }
        }
    }
}

class MyThreadV extends Thread {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;//修改共享成员变量
        System.out.println("MyThreadV.run： flag=" + flag);

    }

    public boolean isFlag() {
        return flag;
    }
}