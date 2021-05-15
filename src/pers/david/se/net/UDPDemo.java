package pers.david.se.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

/**
 * UDP协议
 * @author David
 *
 */
public class UDPDemo {
	
	@Test
	public void sender() throws IOException {
		DatagramSocket datagramSocket=new DatagramSocket();
		
		byte[] data="haha".getBytes();
		
		InetAddress inet=InetAddress.getLocalHost();
		DatagramPacket packet=new DatagramPacket(data, 0, data.length,inet,9090);//创建一个数据包
		
		datagramSocket.send(packet);
		datagramSocket.close();
	}
	
	@Test
	public void receiver() throws IOException {
		DatagramSocket datagramSocket=new DatagramSocket(9090);
		
		byte[] buffer=new byte[100];
		DatagramPacket packet=new DatagramPacket(buffer, 0, buffer.length);//创建一个数据包
		
		datagramSocket.receive(packet);
		
		System.out.println(new String(packet.getData(),0,packet.getLength()));
		
		datagramSocket.close();
	}
}
