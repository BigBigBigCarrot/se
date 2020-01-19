package com.david.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * 	使用线程池创建多线程
 * @author Bu Dawei
 * @date 2020年1月19日
 * @version 
 */
public class ThreadPoolDemo {

	public ThreadPoolDemo() {
	}

	public static void main(String[] args) {
		ExecutorService service =Executors.newFixedThreadPool(10);//限定最多10个线程
		
		ThreadPoolExecutor threadPoolExecutor=(ThreadPoolExecutor)service;
		
		service.execute(new MyRun5());//Runnable
		service.execute(new MyRun5());//Runnable
//		service.submit();//Callable
		
		service.shutdown();//关闭线程池
	}

}

class MyRun5 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}
