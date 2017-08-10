package com.david.jvm.loading;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class MyClassLoader extends ClassLoader
{
    public static final String drive = "F:/DavidSpace/WorkSpace/javaSEworkspace/javase-practice/bin/com/david/vo/";
//	public static final String drive = "F:/DavidSpace/Documents/etc/jvm/";

	public static final String fileType = ".class";

    public static void main(String[] args) throws Exception
    {
    	MyClassLoader loader = new MyClassLoader();
        Class<?> objClass = loader.loadClass("CompanyVO", true);
//        Class<?> objClass = loader.loadClass("Test", true);
        Object obj = objClass.newInstance();
        System.out.println(objClass.getName());
        System.out.println(objClass.getClassLoader());
        System.out.println(obj.getClass().toString());
    }

    public Class<?> findClass(String name)
    {
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);
    }
    public byte[] loadClassData(String name)
    {
        FileInputStream fis = null;
        byte[] data = null;
        try
        {
            fis = new FileInputStream(new File(drive + name + fileType));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = fis.read()) != -1)
            {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }
}