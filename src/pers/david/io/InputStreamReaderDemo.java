package pers.david.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 
 * @Description
 * 	转换流的Demo
 * 	InputStreamReader：将一个字节的输入流转换为字符的输入李
 * 	OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 * 	作用：提供字节流与字符流之间的转换
 * 	解码与编码：
 * 		解码：字节、字节数组--->字符数组、字符串
 * 		编码：字符数组、字符串--->字节、字节数组
 * 	字符集
 * @author Bu Dawei
 * @date 2020年2月11日
 * @version
 */
public class InputStreamReaderDemo {

	public InputStreamReaderDemo() {
	}
	
	/**
	 * 	用字节流读入文本文件然后转换为字符流再在内存中显示
	 * @throws IOException
	 */
	@Test
	public void simpleDemoTest() throws IOException {
		FileInputStream fis=new FileInputStream("hi.txt");//用字节流读取文件
		
		InputStreamReader isr=new InputStreamReader(fis);//用转换流把字节流转换为字符流，默认字符集编码为UTF-8
//		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");//指定字符集编码
//		InputStreamReader isr=new InputStreamReader(fis,"gbk");//指定字符集编码
		 char[] cbuf=new char[20];
		 int len;
		 while((len=isr.read(cbuf))!=-1) {
			 String str=new String(cbuf,0,len);
			 System.out.println(str);
		 }
		 isr.close();
	}
	

	/**
	 * 	利用转换流把UTF-8编码的文本文件转换为GBK编码的文本文件
	 * @throws IOException 
	 */
	@Test
	public void simpleDemoTest2() throws IOException {
		File file1=new File("hi.txt");
		File file2=new File("hi_gbk.txt");
		
		FileInputStream fis=new FileInputStream(file1);
		FileOutputStream fos=new FileOutputStream(file2);
		
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
		
		char[] cbuf=new char[20];
		int len;
		while((len=isr.read(cbuf))!=-1) {
			osw.write(cbuf, 0, len);
		}
		osw.close();
		isr.close();
	}

}
