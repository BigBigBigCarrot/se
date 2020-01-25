package pers.david.etc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{
//		load();
		loadFromXML();
	}
	
	/**
	 * load *.properties
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void load() throws FileNotFoundException, IOException {
		String userDir=System.getProperties().getProperty("user.dir");
//		System.out.println(dir);
		String filePath=userDir+"\\bin\\com\\david\\etc\\Test.properties";
		
		Properties pps = new Properties();
		pps.load(new FileInputStream(filePath));
		Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}
	}
	
	public static void loadFromXML() throws FileNotFoundException, IOException{
		String userDir=System.getProperties().getProperty("user.dir");
//		System.out.println(dir);
		String filePath=userDir+"\\bin\\com\\david\\etc\\TestPropertiesFile.xml";
		
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
