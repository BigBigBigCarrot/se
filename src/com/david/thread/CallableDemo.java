package com.david.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 
 * @Description 实现Callable接口的方式创建多线程 优点： 1. call()有返回值，且支持泛型 2.
 *              call()可以抛出异常，被外面的操作捕获，获取异常信息
 * @author Bu Dawei
 * @date 2020年1月19日
 * @version
 */
public class CallableDemo {

	public CallableDemo() {
	}

	public static void main(String[] args) {
		// 2.创建Callable接口实现对象
		MyCall myCall = new MyCall();
		// 3.将Callable接口实现对象实例传递到FutureTask构造器中，创建FutureTask对象实例
		FutureTask<Integer> futureTask = new FutureTask(myCall);
		// 4.将FutureTask对象实例赋给一个线程，启动线程
		new Thread(futureTask).start();
		try {
			// 5.使用get()方法获取返回值（不必须）
			Integer sum = futureTask.get();
			System.out.println(sum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * 
 * @Description 1.实现Callable接口
 * @author Bu Dawei
 * @date 2020年1月19日
 * @version
 */
class MyCall implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println("sum:" + i);
				sum += i;
			}
		}
		return sum;
	}
}
