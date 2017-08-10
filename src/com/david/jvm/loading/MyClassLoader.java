package com.david.jvm.loading;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class MyClassLoader extends ClassLoader
{
    public static final String drive = "F:/DavidSpace/WorkSpace/javaSEworkspace/javase-practice/bin/";
//	public static final String drive = "F:/DavidSpace/Documents/etc/jvm/";

	public static final String fileType = ".class";

    public static void main(String[] args) throws Exception
    {
    	MyClassLoader loader = new MyClassLoader();
        Class<?> objClass = loader.loadClass("com.david.vo.CompanyVO", true);
//        Class<?> objClass = loader.loadClass("Test", true);
        Object obj = objClass.newInstance();
        System.out.println(objClass.getName());
        System.out.println(objClass.getClassLoader());
        System.out.println(obj.getClass().toString());
        System.out.println(obj instanceof com.david.vo.CompanyVO);
    }

    /**
     * 双亲委派模式下，类的加载首先交由父加载器执行，
     * 当加载com.david.vo.CompanyVO时，CompanyVO在classPath所以下可由com.david.vo.CompanyVO加载，就不执行此函数。
     * 当加载F:/DavidSpace/Documents/etc/jvm/Test.class (不在classPath目录下，双亲无法加载)，执行此函数
     * jvm推荐用户自定义的classLoader不重写loadClass方法，而是重写findClass方法，保证符合双亲委派模式
     */
    public Class<?> findClass(String name)
    {
    	System.out.println("execute function MyClassLoader.findClass(String name)");
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