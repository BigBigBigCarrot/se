package pers.david.se.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 1.使用Socket建立cline和server的交互简单demo
 * 2.启动顺序：先开启服务端监听指定的端口，然后再开启客户端向服务端发起连接。
 * 	如果顺序反了，则会客户端会报错，Connection refused: connects
 * @author David
 *
 */
public class TCPDemo3 {
	
	@Test
	public void client() {
		Socket socket=null;
		OutputStream os=null;
		try {
			InetAddress inet=InetAddress.getByName("127.0.0.1");
			socket=new Socket(inet,8899);
			
			os=socket.getOutputStream();
			os.write("你好，我是客户端".getBytes());//传入二进制数据，可以是String的二进制数据，也可以是其他任意类型的二进制数据
			
			socket.shutdownOutput();//告诉服务端，客户端的输出流传完了，接下来开始干别的，这样服务端才不会一直阻塞等着接收来自客户端的输出流数据
				//最先的demo中，客户端传完数据后直接关闭socket，所以服务端知道传输完了，但本例中客户端向服务端传输玩数据后还要接收来自服务端的数据，
				//所以需要告诉服务端来自客户端的数据传输完成，服务端才会停止接收数据，并开始向客户端发送数据。
			//recieve data from the server
			InputStream is=socket.getInputStream();
			
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte[] buffer=new byte[5];
			int len;
			while((len=is.read(buffer))!=-1) {
				baos.write(buffer,0,len);
			}
			System.out.println("收到了来自"+socket.getInetAddress().getHostAddress()+"的数据");
			System.out.println(baos.toString());
			
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
			
			//server sent data to the client
			OutputStream os=null;
			os=socket.getOutputStream();
			os.write("你好，我是server".getBytes());
			
			baos.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
