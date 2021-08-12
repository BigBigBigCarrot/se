package pers.david.se.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 文件传输demo
 *
 * @author David
 */
public class TCPDemo2 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            os = socket.getOutputStream();
            fis = new FileInputStream(new File("hi.txt"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                socket.close();
                if (fis != null) {
                    fis.close();
                }
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
            FileOutputStream fos = new FileOutputStream(new File("D:\\copy.txt"));


            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
//			ByteArrayOutputStream baos=new ByteArrayOutputStream();
//			byte[] buffer=new byte[5];
//			int len;
//			while((len=is.read(buffer))!=-1) {
//				baos.write(buffer,0,len);
//			}
//			System.out.println("收到了来自"+socket.getInetAddress().getHostAddress()+"的数据");
//			System.out.println(baos.toString());

            is.close();
            socket.close();
            is.close();
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
