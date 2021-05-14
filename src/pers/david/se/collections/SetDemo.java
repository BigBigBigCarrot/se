package pers.david.se.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 *
 * @Description
 * @author Bu Dawei
 * @date 2020年1月20日
 * @version
 */
public class SetDemo {

    public SetDemo() {
    }


    public static void main(String[] args) {

    }

    /**
     * 	1.	HashSet：基于HashMap存储，遍历是的无序，与插入顺序和元素值无关（存储的元素是以key的形式存在map里面，所有map里面的value都是同一个对象。取元素的时候是取key）
     * 	2.	LinkedHashSet：继承自HashSet，按插入顺序遍历
     * 	3.	TreeSet：基于TreeMap实现，按元素值升序遍历，底层使用红黑树存储
     */
    @Test
    public void comparison() {
        Set<Integer> hashSet=new HashSet();
        hashSet.add(7);
        hashSet.add(17);
        hashSet.add(1);
        hashSet.add(8);
        hashSet.add(3);
        System.out.println(hashSet.toString());//[17, 1, 3, 7, 8]，遍历是的无序，与插入顺序和元素值无关

        Set<Integer> linkedHashSet=new LinkedHashSet();
        linkedHashSet.add(7);
        linkedHashSet.add(17);
        linkedHashSet.add(1);
        linkedHashSet.add(8);
        linkedHashSet.add(3);
        System.out.println(linkedHashSet.toString());//[7, 17, 1, 8, 3]，按插入顺序遍历

        Set<Integer> treeSet=new TreeSet();
        treeSet.add(7);
        treeSet.add(17);
        treeSet.add(1);
        treeSet.add(8);
        treeSet.add(3);
        System.out.println(treeSet.toString());//[1, 3, 7, 8, 17]，按元素值升序遍历
    }

    /**
     * TreeSet会调用compareTo方法进行降序排序
     */
    @Test
    public void treeSetDemo() {
        TreeSet<Integer> ts=new TreeSet();
        ts.add(5);
        ts.add(3);
        ts.add(2);
//		ts.add("a");//不能添加不同类的对象实例
        //TreeSet会调用compareTo方法进行升序排序
        Iterator it=ts.iterator();
        while (it.hasNext()) {
            Integer type = (Integer) it.next();
            System.out.println(type);
        }
    }

}
