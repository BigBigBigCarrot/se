package pers.david.se.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Bu Dawei
 * @Description 描述文件与目录的类java.io.File的Demo。 仅能描述、新建和删除、不能做修改操作。 如要修改则该用到IO流。
 * @date 2020年2月10日
 */
public class FileDemo {

    public FileDemo() {
    }

    public static void main(String[] args) {
        File file = new File("hellooooooo.txt");// 相对路径，相对于当前工程的根目录，不含所在包的路径。（不推荐）
        // 开发中也不对应编译后的target或者bin路径，如果打包编译后那肯定是相对于打包编译后的根目录
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void seperatorTest() {
        // 不同操作系统的路径分隔符可能不一样，用File.separator最保险。
        System.out.println(File.separator);
    }

    /**
     * 获取当前class文件同路径下的指定文件的File对象实例
     *
     * @throws URISyntaxException
     */
    @Test
    public void f1() throws URISyntaxException {
        URI uri = this.getClass().getResource("pokemon.txt").toURI();
        File file = new File(uri);
        System.out.println(file.exists());// true
        // "D:\ITSpace\WorkSpace\JavaSE_WorkSpace\javase-practice\bin\pers\david\io\pokemon.txt"
        System.out.println(file.getAbsolutePath());
    }

    /**
     * 获取当前classpath路径下的指定文件的File对象实例
     *
     * @throws URISyntaxException
     */
    @Test
    public void f2() throws URISyntaxException {
        URI uri = this.getClass().getClassLoader().getSystemResource("propertiesDemo.properties").toURI();
        File file = new File(uri);
        System.out.println(file.exists());// true
        // "D:\ITSpace\WorkSpace\JavaSE_WorkSpace\javase-practice\bin\propertiesDemo.properties"
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void FileConstructorTest() {
        File file1 = new File("hello.txt");// 相对路径，相对于当前工程的根目录，不含所在包的路径。（不推荐）
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\hello.txt");
        File file3 = new File("C:\\Users\\Administrator\\Desktop", "hello.txt");
        File file4 = new File(file3, "hi.txt");

        System.out.println(file1.getAbsolutePath());

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
    }

    @Test
    public void FileInfo1() {
        // File对象可以指文件也可以指目录
        File file1 = new File("hello.txt");// （不推荐）
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void FileInfo2() {
        // File对象可以指文件也可以指目录
        File file1 = new File("hello.txt");// （不推荐）
        File file2 = new File("C:\\Users\\Administrator\\Desktop");

        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println("===============================");

        System.out.println(file2.isFile());
        System.out.println(file2.isDirectory());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }

    @Test
    public void DirectoryTest() {
        File file = new File("D:\\Downloads");

        String[] list = file.list();// 找这个文件同级目录下的目录和文件
        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("===============================");

        File[] files = file.listFiles();// 找这个文件同级目录下的目录和文件
        for (File f : files) {
            System.out.println(f.getPath());
        }
    }

    @Test
    public void renameToTest() {
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\a.txt");
//		File file2=new File("C:\\Users\\Administrator\\Desktop\\b.txt");
//		File file2=new File("D:\\b.txt");//如果二者不在同一路径下，则会剪切过去。
        File file2 = new File("D:\\a\\b.txt");// 如果目标路径不存在，则会失败。

        // 当file1在硬盘中存在，且file2在硬盘中不存在时才能成功返回true
        boolean result = file1.renameTo(file2);
        System.out.println(result);
    }

    /**
     * 文件的创建和删除
     */
    @Test
    public void createFileTest() {
        File file = new File("D:\\a.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();// 创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        file.delete();// 删除文件
    }

    @Test
    public void createDirectoryTest() {
        File directory1 = new File("D:\\a\\b\\c");
        File directory2 = new File("D:\\d\\e\\f");

        boolean result;
        result = directory1.mkdir();// 创建目录，如果上层目录不存在则创建失败
        if (result) {
            System.out.println("创建目录1成功");
        }
        result = directory2.mkdirs();// 创建目录，如果上层目录不存在则连同上层目录一起创建
        if (result) {
            System.out.println("创建目录2成功");
        }
    }

    public static ArrayList<File> getFiles(String filePath) {
        ArrayList<File> files = new ArrayList<File>();
        File file = new File(filePath);
        File[] tempLists = file.listFiles();
        for (int i = 0; i < tempLists.length; i++) {
            if (tempLists[i].isFile()) {
                files.add(tempLists[i]);
            }
        }
        return files;
    }

    @Test
    public void getAllFileNameTest() throws URISyntaxException {
//		ArrayList<File> files=getFiles("E:\\DavidSpace\\workspace\\sts\\minielectric-ebike-gate\\minielectric-gate\\logs");
//		for (Iterator iterator = files.iterator(); iterator.hasNext();) {
//			File file = (File) iterator.next();
//			System.out.println(file.getName());
//		}
        URI uri = this.getClass().getClassLoader().getSystemResource("propertiesDemo.properties").toURI();
        System.out.println(uri.getPath());
    }

    public static String readLog(String filePath) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
            br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String lineContentStr;
            while ((lineContentStr = (br.readLine())) != null) {
                sb.append(lineContentStr);
            }
            br.close();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "读取失败";
    }

    @Test
    public void readLogTest() {
        String filePath = "E:\\DavidSpace\\workspace\\sts\\minielectric-ebike-gate\\minielectric-gate\\logs\\error.2020-06-19.log";
        String content = readLog(filePath);
        System.out.println(content);
    }
}
