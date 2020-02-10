package pers.david.collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

public class PropertiesTest {

	public PropertiesTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{
	}
	
	/**
	 * load *.properties
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void load() throws FileNotFoundException, IOException {
		String userDir=System.getProperties().getProperty("user.dir");
//		System.out.println(dir);
		String filePath=userDir+"\\bin\\pers\\david\\collections\\Test.properties";
		
		Properties pps = new Properties();
		pps.load(new FileInputStream(filePath));
		Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}
	}
	
	@Test
	public void loadFromXML() throws FileNotFoundException, IOException{
		String userDir=System.getProperties().getProperty("user.dir");
//		System.out.println(dir);
		String filePath=userDir+"\\bin\\pers\\david\\collections\\TestPropertiesFile.xml";
		
		Properties pps = new Properties();
		pps.loadFromXML(new FileInputStream(filePath));
		Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}
	}

}
