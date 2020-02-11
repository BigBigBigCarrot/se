package pers.david.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

public class FileReaderFileWriterDemo {

	public FileReaderFileWriterDemo() {
	}
	
	/**
	 * 读取文本文件到内存
	 * @throws URISyntaxException
	 */
	@Test
	public void fileReaderTest() throws URISyntaxException {
		URI uri=ClassLoader.getSystemResource("propertiesDemo.properties").toURI();
		File file=new File(uri);
		//实例化File类的对象，指明要操作的文件
		FileReader fr=null;
		//提供具体的流
		try {
			fr=new FileReader(file);//FileReader也是一种流，用于读取文本文件
			//读入数据
			int data;
			while((data=fr.read())!=-1){//每次只读一个字符，如果读完了就返回-1（反复读取磁盘，效率低，不推荐）
				System.out.print((char)data);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null) {
					//关闭流
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 读取文本文件到内存
	 * @throws URISyntaxException
	 */
	@Test
	public void fileReaderTest2() throws URISyntaxException {
		URI uri=ClassLoader.getSystemResource("propertiesDemo.properties").toURI();
		File file=new File(uri);
		//实例化File类的对象，指明要操作的文件
		FileReader fr=null;
		//提供具体的流
		try {
			fr=new FileReader(file);//FileReader也是一种流，用于读取文本文件
			//读入数据
			char[] cbuf=new char[5];//用于承接从流中写过来的数据，一次5个字符
			int len;//记录本次写到cbuf的字符有几个，-1表示写完了，没有数据
			while((len=fr.read(cbuf))!=-1){//最多读5个字符（也有可能不够5个），如果读完了就返回-1（推荐写法）
				System.out.print(cbuf);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null) {
					//关闭流
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 把内存中的数据写入到磁盘中的文本文件。
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	@Test
	public void fileWriterTest() throws URISyntaxException, IOException {
		//1. 提供File类对象，指明写出的文件
		File file=new File("hi.txt");//文件在本工程的根目录
//		File file=new File("D://hi.txt");//
		//2. 创建一个输出流，用于把内存的数据输出到指定额File中
		FileWriter fw=new FileWriter(file);//默认文件不存在就创建，存在就替换内容
//		FileWriter fw=new FileWriter(file,true);//文件不存在就创建，存在就在后面append
		//3. 输出数据
		fw.write("greeting ");
		fw.write("human\n");
		fw.write("本文件来自输入输出流的demo");
		//4. 关闭流
		fw.close();
	}


	/**
	 * 复制文本文件到新文件
	 * @throws IOException 
	 */
	@Test
	public void fileReaderFileWriterTest() {
		//创建File类的对象，指明读入的源文件和写出的目标文件
		File srcFile=new File("hi.txt");
		File destFile=new File("hi2.txt");
		//创建输入流和输出流
		FileReader fr=null;
		FileWriter fw=null;
		try {
			fr = new FileReader(srcFile);
			 fw=new FileWriter(destFile);
			//数据的读入和写出
			char[] cbuf=new char[3];
			int len;//记录每次读入到cbuf的字符的个数
			while((len=fr.read(cbuf))!=-1) {//每次用输入流读取len个字符
				fw.write(cbuf,0,len);//每次用输出流写出len个字符
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//关闭输入流和输出流
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
