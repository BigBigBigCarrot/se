package pers.david.se.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 下载网络资源的demo
 *
 * @author David
 */
public class URLDemo2 {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("D:\\baiduIcon.png");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        is.close();
        fos.close();
        urlConnection.disconnect();
    }

}
