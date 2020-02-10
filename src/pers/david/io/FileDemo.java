package pers.david.io;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 
 * @Description
 * 	描述文件与目录的类java.io.File的Demo。
 * 	仅能描述、新建和删除、不能做修改操作。
 * 	如要修改则该用到IO流。
 * @author Bu Dawei
 * @date 2020年2月10日
 * @version
 */
public class FileDemo {

	public FileDemo() {
	}

	
	@Test
	public void FileConstructorTest() {
		File file1=new File("hello.txt");//相对路径，相对于这个class文件的所在路径
		File file2=new File("C:\\Users\\Administrator\\Desktop\\hello.txt");
		File file3=new File("C:\\Users\\Administrator\\Desktop","hello.txt");
		File file4=new File(file3,"hi.txt");
		
		System.out.println(file1);
		System.out.println(file2);
		System.out.println(file3);
		System.out.println(file4);
	}
	
	@Test
	public void FileInfo1() {
		//File对象可以指文件也可以指目录
		File file1=new File("hello.txt");
		File file2=new File("C:\\Users\\Administrator\\Desktop\\hi.txt");
	
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
		//File对象可以指文件也可以指目录
		File file1=new File("hello.txt");
		File file2=new File("C:\\Users\\Administrator\\Desktop");
		
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
		File file=new File("D:\\Downloads");
		
		String[] list=file.list();//找这个文件同级目录下的目录和文件
		for(String str:list) {
			System.out.println(str);
		}

		System.out.println("===============================");
		
		File[] files=file.listFiles();//找这个文件同级目录下的目录和文件
		for(File f:files) {
			System.out.println(f.getPath());
		}
	}
	
	@Test
	public void renameToTest() {
		File file1=new File("C:\\Users\\Administrator\\Desktop\\a.txt");
//		File file2=new File("C:\\Users\\Administrator\\Desktop\\b.txt");
//		File file2=new File("D:\\b.txt");//如果二者不在同一路径下，则会剪切过去。
		File file2=new File("D:\\a\\b.txt");//如果目标路径不存在，则会失败。
		
		//当file1在硬盘中存在，且file2在硬盘中不存在时才能成功返回true
		boolean result=file1.renameTo(file2);
		System.out.println(result);
	}
	
	/**
	 * 	文件的创建和删除
	 */
	@Test
	public void createFileTest() {
		File file=new File("D:\\a.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();//创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		file.delete();//删除文件
	}
	
	@Test
	public void createDirectoryTest() {
		File directory1=new File("D:\\a\\b\\c");
		File directory2=new File("D:\\d\\e\\f");
		
		boolean result;
		result=directory1.mkdir();//创建目录，如果上层目录不存在则创建失败
		if(result) {
			System.out.println("创建目录1成功");
		}
		result=directory2.mkdirs();//创建目录，如果上层目录不存在则连同上层目录一起创建
		if(result) {
			System.out.println("创建目录2成功");
		}
	}
}
