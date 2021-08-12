package pers.david.se.thread;

/**
 * @author Bu Dawei
 * @Description 进程同步：生产者与消费者
 * @date 2020年1月18日
 */
public class ConsumerAndProducter {

    public ConsumerAndProducter() {
    }

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");

        p1.start();
        c1.start();
        System.out.println("end");
    }

}

class Clerk {

    private int productNum = 0;

    public synchronized void produce() {//锁为当前的示例对象
        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + " 生产了第" + productNum + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + " 消费了第" + productNum + "个产品");
            productNum--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println(getName() + " producing...");
        while (true) {
            clerk.produce();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println(getName() + " consuming...");
        while (true) {
            clerk.consume();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
