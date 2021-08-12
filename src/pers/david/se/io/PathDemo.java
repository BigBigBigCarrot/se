package pers.david.se.io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

public class PathDemo {

    public PathDemo() {
    }

    public static void main(String[] args) {
        //相对于工程的根目录，不含包路径，不含什么bin或者targer之类的
        //D:\ITSpace\WorkSpace\JavaSE_WorkSpace\javase-practice\pokemon.txt
        File file1 = new File("pokemon.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /**
     * 获取当前class同路径下的文件
     */
    @Test
    public void f3() {
        URI uri = null;
        try {
            uri = this.getClass().getResource("pokemon.txt").toURI();//获取当前class同路径下的指定文件名的文件的uri
            //file:/D:/ITSpace/WorkSpace/JavaSE_WorkSpace/javase-practice/bin/pers/david/io/pokemon.txt
            System.out.println(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (uri != null) {
            File file = new File(uri);//用的是入参为URI类型的构造器，根据uri创建文件对象实例
            System.out.println(file.exists());//true
        }

    }

    /**
     * 获取classpath路径下的文件
     *
     * @throws URISyntaxException
     */
    @Test
    public void f4() throws URISyntaxException {
        //获取classpath的URL
        URL url = ClassLoader.getSystemResource("");
        // "file:/D:/ITSpace/WorkSpace/JavaSE_WorkSpace/javase-practice/bin/"
        System.out.println(url);


        //获取classpath下的指定文件的URL
        URL fileUrl = ClassLoader.getSystemResource("propertiesDemo.properties");
        // "file:/D:/ITSpace/WorkSpace/JavaSE_WorkSpace/javase-practice/bin/propertiesDemo.properties"
        System.out.println(fileUrl);

        File file = new File(fileUrl.toURI());//用的是入参为URI类型的构造器
        System.out.println(file.exists());//true
    }

    @Test
    public void f1() {
        //相对于工程的根目录，不含包路径，不含什么bin或者targer之类的（不推荐）
        File file = new File("pokemon.txt");
        // "/D:\\ITSpace\\WorkSpace\\JavaSE_WorkSpace\\javase-practice\\pokemon.txt"
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());//false
    }

    @Test
    public void f2() throws URISyntaxException {
        //获取当前类class文件的完整URI路径，。不包括自己。
        // "file:/D:/ITSpace/WorkSpace/JavaSE_WorkSpace/javase-practice/bin/pers/david/io/"
        System.out.println(this.getClass().getResource("").toString());

        //效果同this.getClass().getResource("").toString()
        // "file:/D:/ITSpace/WorkSpace/JavaSE_WorkSpace/javase-practice/bin/pers/david/io/"
        System.out.println(this.getClass().getResource("").toURI().toString());

        // "/D:/ITSpace/WorkSpace/JavaSE_WorkSpace/javase-practice/bin/pers/david/io/"
        System.out.println(this.getClass().getResource("").getPath());

    }


    @Test
    public void f5() {
        String userDir = System.getProperties().getProperty("user.dir");
        // "D:\ITSpace\WorkSpace\JavaSE_WorkSpace\javase-practice"
        System.out.println(userDir);
    }

}
