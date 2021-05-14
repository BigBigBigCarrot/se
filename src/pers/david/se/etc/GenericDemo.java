package pers.david.se.etc;

import java.util.ArrayList;
import java.util.Arrays;
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
    /**
     * 泛型方法调用示例
     */
    public void genericMethodTest() {
        Integer[] arr= {1,2,3};
        List<Integer> list=copyFromArrayToList(arr);
        System.out.println(list);
    }

    /**
     * 通配符示例
     * @param list：可以是List<Integer> 、List<String>等
     */
    public void print(List<?> list) {
        System.out.println(list);
    }

    public void print2(List<? extends Integer> list) {
        System.out.println(list);
    }

    @Test
    public void printTest() {
        List<Integer> list1=Arrays.asList(1,2,3,4);
        List<String> list2=Arrays.asList("a","b","c","d");
        List list3=Arrays.asList(1.1,2.2,3,4);
        print(list1);
        print(list2);
        print(list3);
    }

}

class Father<T1,T2>{
}

/**
 *
 * @Description
 * 	子类不保留父类的泛型
 * 	1)没有类型 擦除
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

/**
 *
 * @Description
 * 	要求A必须是继承Number，B必须实现Comparable接口
 */
class C1<A extends Number,B extends Comparable>{
}