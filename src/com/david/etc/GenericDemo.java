package com.david.etc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @Description
 * 	泛型Generic 的demo
 * @author Bu Dawei
 * @date 2020年1月22日
 * @version 
 */
public class GenericDemo {

	public GenericDemo() {
	}

	public static void main(String[] args) {

	}
	
	/**
	 * 	定义了一个泛型方法，返回值是List<E>
	 * 	泛型方法可以是静态的
	 * 	泛型参数是在调用方法时确定的
	 * @param <E>
	 * @param arr
	 * @return
	 */
	public <E> List<E> copyFromArrayToList(E[] arr){
		List<E> list=new ArrayList<E>();
		for(E e:arr) {
			list.add(e);
		}
		return list;
	}
	
	@Test
	public void genericMethodTest() {
		Integer[] arr= {1,2,3};
		List<Integer> list=copyFromArrayToList(arr);
		System.out.println(list);
	}
}

class Father<T1,T2>{
}

/**
 * 
 * @Description
 * 	子类不保留父类的泛型
 * 	1)没有类型 擦除
 * @author Bu Dawei
 * @date 2020年1月22日
 * @param <A>
 * @param <B>
 */
class Son1<A,B>extends Father{//等价于class Son extends Father<Object,Object>
}
/**
 * 
 * @Description
 * 	具体类型
 */
class Son2<A,B>extends Father<Integer,String>{//等价于class Son extends Father<Object,Object>
}
/**
 * 
 * @Description
 * 	子类全部保留父类的泛型
 */
class Son3<T1,T2,A,B>extends Father<T1,T2>{//等价于class Son extends Father<Object,Object>
}
/**
 * 
 * @Description
 * 	部分保留父类的泛型
 */
class Son4<T2,A,B>extends Father<Integer,T2>{//等价于class Son extends Father<Object,Object>
}

class C1<A extends Number,B extends Comparable>{
 }
