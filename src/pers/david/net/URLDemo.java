package pers.david.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=630");

		System.out.println(url.getProtocol());

		System.out.println(url.getHost());
		
		System.out.println(url.getPort());
		
		System.out.println(url.getPath());
		
		System.out.println(url.getFile());
		
		System.out.println(url.getQuery());
	}

}
