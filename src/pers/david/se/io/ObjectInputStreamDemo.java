package pers.david.se.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * @author Bu Dawei
 * @Description 对象流Demo
 * 1. ObjectInputStream和ObjectOutputStream
 * 2. 作用：用于存储和读取基本数据类型数据或对象的实例的处理流，
 * 可以把java的对象实例序列化以二进制文件的形式写到硬盘中，
 * 然后再读取磁盘文件反序列化生成java对象实例。
 * 3. 序列化也可以用于做深克隆，序列化一个对象然后再反序列化回路得到一个一模一样的对象实例。
 * @date 2020年2月12日
 */
public class ObjectInputStreamDemo {
    /**
     * 使用反序列化把对象实例写到磁盘
     *
     * @throws IOException
     */
    @Test
    public void f1Test() throws IOException {
        File file = new File("myObjectInstance.obj");//扩展名随便起，无所谓。
        FileOutputStream fos = new FileOutputStream(file);//用字节流输出
        ObjectOutputStream oos = new ObjectOutputStream(fos);//字节流外面套一层对象流

        oos.writeObject(new Person("张三"));
        oos.flush();

        oos.close();
    }

    /**
     * 使用反序列化把磁盘中的对象实例二进制文件读取生成一个新的实例到内存中
     *
     * @throws Exception
     */
    @Test
    public void f2Test() throws Exception {

        File file = new File("myObjectInstance.obj");//扩展名随便起，无所谓。
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = ois.readObject();
        ois.close();

        Person per = (Person) obj;
        System.out.println(per);

    }

}
