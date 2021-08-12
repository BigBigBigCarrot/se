package pers.david.se.collections;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @author Bu Dawei
 * @Description 注意：Map接口不继承自Collection接口
 * @date 2020年1月20日
 */
public class MapDemo {

    public MapDemo() {
    }

    public static void main(String[] args) {

    }

    /**
     * HashMap、LinkedHashMap、TreeMap的比较
     * HashMap：不一定按插入顺序遍历
     * LinkedHashMap：按插入顺序遍历
     * TreeMap：按key值降序排列遍历
     */
    @Test
    public void comparison() {
        Set<String> set;
        Map<String, Integer> hashMap = new HashMap();
        Map<String, Integer> linkedHashMap = new LinkedHashMap();

        hashMap.put("a", 3);
        hashMap.put("1", 2);
        hashMap.put("0", 6);
        System.out.println(hashMap.toString());//{0=6, a=3, 1=2}，不一定按插入顺序遍历
        set = hashMap.keySet();
        System.out.println(set.toString());//[0, a, 1]
        for (Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.print(entry.getKey() + "\t");
        }
        System.out.print("\n");

        linkedHashMap.put("a", 3);
        linkedHashMap.put("1", 2);
        linkedHashMap.put("0", 6);
        System.out.println(linkedHashMap.toString());//{0=6, a=3, 1=2}，按插入顺序遍历
        set = linkedHashMap.keySet();
        System.out.println(set.toString());//[a, 1, 0]

        Map<String, Integer> treeMap = new TreeMap();

        treeMap.put("a", 3);
        treeMap.put("1", 2);
        treeMap.put("0", 6);
        treeMap.put("-1", 1);
        System.out.println(treeMap.toString());//{-1=1, 0=6, 1=2, a=3}
    }


    @Test
    public void propertiesDemo() {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            String fileURI = getClass().getResource("/") + "/propertiesDemo.properties";
            fis = new FileInputStream(fileURI.replace("file:/", ""));
            pros.load(fis);

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            String pattern = "name:{0} \t password:{1}";
            System.out.println(MessageFormat.format(pattern, name, password));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void pathTest() {
        System.out.println(getClass().getResource("/"));//file:/D:/ITSpace/WorkSpace/JavaSE_WorkSpace/javase-practice/bin/

    }

}
