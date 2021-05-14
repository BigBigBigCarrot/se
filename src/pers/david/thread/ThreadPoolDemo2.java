package pers.david.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo2 {
	public static void main(String[] args) {
        final int threadNum=2;
		//设定该线程池最多只能同时有两个线程在跑
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

        Future<?> submit1 = executorService.submit(() -> {
            System.out.println("thread 1 begin to run ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1 stop");
        });
        Future<?> submit2 = executorService.submit(() -> {
            System.out.println("thread 2 begin to run");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2 stop");
        });
		//执行到这里时，submit1和submit还在sleep，即目前线程池里面还有两个线程在跑，所以
		//当前想线程请求线程跑submit3会在队列里等待？直到线程池有空闲线程资源为止。
        Future<?> submit3 = executorService.submit(() -> {
            System.out.println("thread 3 begin to run");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 3 stop");
        });

		//使用submit1.isDone()查看submit1的任务是否结束，期望结果为false
        System.out.println(submit1.isDone());
        try {
			//submit1.get();阻塞，直到submit1的任务结束为止，
			//如果没有submit1.get();，则有可能
            submit1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
		//由于在上面使用 submit1.get();，所以此处期望结果为true
        System.out.println(submit1.isDone());
    }

}
