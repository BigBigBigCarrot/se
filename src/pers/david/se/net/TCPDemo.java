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
 * 1.使用Socket建立基于TCP协议的cline和server的交互简单demo
 * 2.启动顺序：先开启服务端监听指定的端口，然后再开启客户端向服务端发起连接。
 * 如果顺序反了，则会客户端会报错，Connection refused: connects
 *
 * @author David
 */
public class TCPDemo {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());//传入二进制数据，可以是String的二进制数据，也可以是其他任意类型的二进制数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            ServerSocket ss = new ServerSocket(8899);

            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println("收到了来自" + socket.getInetAddress().getHostAddress() + "的数据");
            System.out.println(baos.toString());

            baos.close();
            is.close();
            socket.close();//客户端关闭连接，则服务端就知道连接关闭了，会跟着关闭
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
