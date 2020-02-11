package pers.david.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

public class FileReaderFileWriterDemo {

	public FileReaderFileWriterDemo() {
	}
	
	@Test
	public void fileReaderTest() throws URISyntaxException {
		URI uri=ClassLoader.getSystemResource("propertiesDemo.properties").toURI();
		File file=new File(uri);
		//实例化File类的对象，指明要操作的文件
		FileReader fr=null;
		//提供具体的流
		try {
			fr=new FileReader(file);
			//读入数据
			int data;
			while((data=fr.read())!=-1){
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

}
