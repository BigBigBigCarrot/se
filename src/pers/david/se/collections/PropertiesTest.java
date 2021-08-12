package pers.david.se.collections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.junit.Test;

public class PropertiesTest {

    public PropertiesTest() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
    }

    /**
     * load *.properties
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void load() throws FileNotFoundException, IOException, URISyntaxException {
        URI uri = this.getClass().getResource("Test.properties").toURI();
        File file = new File(uri);

        Properties pps = new Properties();
        pps.load(new FileInputStream(file));
        Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
        while (enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }
    }

    @Test
    public void loadFromXML() throws URISyntaxException, InvalidPropertiesFormatException, FileNotFoundException, IOException {

        URI uri = this.getClass().getResource("TestPropertiesFile.xml").toURI();
        File file = new File(uri);

        Properties pps = new Properties();
        pps.loadFromXML(new FileInputStream(file));
        Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
        while (enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }
    }

}
