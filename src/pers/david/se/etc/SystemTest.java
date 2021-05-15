package pers.david.se.etc;

import java.util.Enumeration;
import java.util.Properties;

public class SystemTest {

    public SystemTest() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        getSystemProperties();
//		setSystemProperty();
    }

    public static void getSystemProperties() {
        Properties properties = System.getProperties();
        Enumeration e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String propertyName = e.nextElement().toString();
            System.out.println(propertyName);
            Object property = properties.getProperty(propertyName);
            System.out.println(property.toString() + '\n');
        }
    }

    public static void setSystemProperty() {
        System.setProperty("key1", "value1");
        System.out.println(System.getProperty("key1"));
    }
}