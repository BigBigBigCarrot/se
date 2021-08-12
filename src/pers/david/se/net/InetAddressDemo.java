package pers.david.se.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

    public static void main(String[] args) {
        try {
            InetAddress inet1;//用于描述一个IP的对象实例，可以指定具体的IP地址，或者给定域名后到网络上去解析获取其对应的IP
            inet1 = InetAddress.getByName("192.168.10.14");//192.168.10.14
            System.out.println(inet1);

            //若输入网址，则会会到网络上去解析网址对应的ip地址（需联网，有延迟）
            InetAddress inet2;
            inet2 = InetAddress.getByName("www.qq.com");//14.18.175.154
            System.out.println(inet2);

//			InetAddress inet3;
//			inet3 = InetAddress.getByName("14.18.175.154");
//			System.out.println(inet3.getHostName());
//			System.out.println(inet3.getHostAddress());

            InetAddress inet4;
            inet4 = InetAddress.getByName("localhost");//127.0.0.1
            System.out.println(inet4);

            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
