package pers.david.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TCPDemo {
	
	@Test
	public void client() {
		Socket socket=null;
		OutputStream os=null;
		try {
			InetAddress inet=InetAddress.getByName("127.0.0.1");
			socket=new Socket(inet,8899);
			
			os=socket.getOutputStream();
			os.write("你好，我是客户端".getBytes());//传入二进制数据，可以是String的二进制数据，也可以是其他任意类型的二进制数据
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void server() {
		try {
			ServerSocket ss=new ServerSocket(8899);
			
			Socket socket=ss.accept();
			InputStream is=socket.getInputStream();
			
			
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte[] buffer=new byte[5];
			int len;
			while((len=is.read(buffer))!=-1) {
				baos.write(buffer,0,len);
			}
			System.out.println("收到了来自"+socket.getInetAddress().getHostAddress()+"的数据");
			System.out.println(baos.toString());
			
			baos.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
