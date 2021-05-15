package pers.david.se.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @Description
 * 	去除重复数据练习
 * @author Bu Dawei
 * @date 2020年1月14日
 * @version
 */
public class RemoveDuplication {

    public RemoveDuplication() {
    }

    public static void main(String[] args) {
        f();
//		f1();
        f3();
    }


    public static void f() {
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> uniqList = new ArrayList<>(new HashSet<>(Arrays.asList(array)));
        for (String string : uniqList) {
            System.out.print(string);
        }
        System.out.print("\n");
    }

    /**
     * 先遍历原数组，然后遍历结束集，通过每个数组的元素和结果集中的元素进行比对，若相同则break。若不相同，
     * 则存入结果集。两层循环进行遍历得出最终结果。
     */
    public static void f1() {
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> result = new ArrayList<>();
        boolean flag;
        for(int i=0;i<array.length;i++){
            flag = false;
            for(int j=0;j<result.size();j++){
                if(array[i].equals(result.get(j))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) result.toArray(new String[result.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    /**
     * 通过使用indexOf方法进行判断结果集中是否存在了数组元素
     */
    public static void f2() {
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for(int i=1;i<array.length;i++){
            if(list.toString().indexOf(array[i]) == -1){
                list.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    public static void f3() {
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> list = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] == array[j]){
                    j = ++i;
                }
            }
            list.add(array[i]);
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    /**
     * 	嵌套循环，进行比较获取满足条件结果集
     */
    public static void f4(){
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        Arrays.sort(array);
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for(int i=1;i<array.length;i++){
            if(!array[i].equals(list.get(list.size()-1))){
                list.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    public static void f5() {
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        Set<String> set = new HashSet<>();
        for(int i=0;i<array.length;i++){
            set.add(array[i]);
        }
        String[] arrayResult = (String[]) set.toArray(new String[set.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

}
