package pers.david.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 
 * @Description
 * 	缓冲流Demo。
 * 	常见缓冲流：
 * 		BufferedInputStream
 * 		BufferedOutputStream
 * 		BufferedReader
 * 		BuffeedrWriter
 * 	作用：提高流的读取、写入速度。
 * 	说明：缓冲流是处理流的一种，在被处理流的基础上套了一层，
 * 		且自带有缓冲区，当缓冲区满了才会把缓冲区的数据写过去，所以速度比较快。
 * 		如果没有缓冲区，频繁的读一下写一下，速度会很慢。
 * 		如果一口气读完，内存可能会爆。
 * @author Bu Dawei
 * @date 2020年2月11日
 * @version
 */
public class BufferDemo {

	public BufferDemo() {
	}
	
	@Test
	public void BufferedStreamTest() {
		long start=System.currentTimeMillis();
		
		//1 创建文件对象实例
		File srcFile=new File("hi.txt");
		File destFile=new File("hi_copy.txt");
		//2 创建流
		//2.1 创建节点流
		FileInputStream fis;
		try {
			fis = new FileInputStream(srcFile);
			FileOutputStream fos=new FileOutputStream (destFile);
			//2.2 创建缓冲流
			BufferedInputStream bis=new BufferedInputStream(fis);
			BufferedOutputStream bos=new  BufferedOutputStream(fos);
			//3 复制的细节：读取、写入
			byte[] buffer=new byte[10];
			int len;
			while((len=bis.read(buffer))!=-1) {
				bos.write(buffer, 0, len);
//				bos.flush();//手动调用刷新缓冲区-即把Buffered流的缓冲区中的数据写过去
					//不用显示调用，缓冲区满后会自动刷新数据
			}
			//关闭流
			bos.close();
			bis.close();
			//说明：关闭外层流的同时、内层的流也会自动进行关闭。
//			fos.close();
//			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		System.out.println("共耗时： "+(end-start));//文件要稍微大一点才能看出效果
	}
	

	@Test
	public void BufferedReaderBufferedWriter() {

		long start=System.currentTimeMillis();
		
		//1 创建文件对象实例
		File srcFile=new File("hi.txt");
		File destFile=new File("hi_copy.txt");
		//2 创建流
		//2.1 创建节点流
		FileReader fr;
		FileWriter fw;
		try {
			fr = new FileReader(srcFile);
			fw = new FileWriter(destFile);
			//2.2 创建缓冲流
			BufferedReader br=new BufferedReader(fr);
			BufferedWriter bw=new  BufferedWriter(fw);
			//3 复制的细节：读取、写入
			String str;
			while((str=br.readLine())!=null) {
				bw.write(str);
				bw.write('\n');//手动加上换行符，最后复制的文件会多一个换行符。也可以不用readLine方法。
//				bos.flush();//手动调用刷新缓冲区-即把Buffered流的缓冲区中的数据写过去
					//不用显示调用，缓冲区满后会自动刷新数据
			}
			//关闭流
			bw.close();
			br.close();
			//说明：关闭外层流的同事、内层的流也会自动尽心关闭。
//			fos.close();
//			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		System.out.println("共耗时： "+(end-start));//文件要稍微大一点才能看出效果
	}

}
