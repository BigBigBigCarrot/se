package com.david.jvm.loading;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
	public static final String classPath = "F:/DavidSpace/WorkSpace/javaSEworkspace/javase-practice/bin/";// src
//	 public static final String classPath = "F:/DavidSpace/Documents/etc/jvm/";

	public static final String fileType = ".class";

	public static void main(String[] args) throws Exception {
		String qualifiedName = "com.david.vo.CompanyVO";
//		 String qualifiedName="Test";
		MyClassLoader loader = new MyClassLoader();
		Class<?> objClass = loader.loadClass(qualifiedName, true);
		Object obj = objClass.newInstance();
		System.out.println(objClass.getName());
		System.out.println(objClass.getClassLoader());
		System.out.println(obj.getClass().toString());
		System.out.println(obj instanceof com.david.vo.CompanyVO);

	}

	/**
	 * 双亲委派模式下，类的加载首先交由父加载器执行，
	 * 当加载com.david.vo.CompanyVO时，CompanyVO在classPath所以下可由com
	 * .david.vo.CompanyVO加载，就不执行此函数。
	 * 当加载F:/DavidSpace/Documents/etc/jvm/Test.class
	 * (不在classPath目录下，双亲无法加载)，执行此函数
	 * jvm推荐用户自定义的classLoader不重写loadClass方法，而是重写findClass方法，保证符合双亲委派模式
	 */
	public Class<?> findClass(String name) {
		System.out
				.println("execute function MyClassLoader.findClass(String name)");
		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length);
	}

	public byte[] loadClassData(String name) {
		String url = classPath + name.replace(".", "/") + fileType;
		FileInputStream fis = null;
		byte[] data = null;
		try {
			File file = new File(url);
			fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int ch = 0;
			while ((ch = fis.read()) != -1) {
				baos.write(ch);
			}
			fis.close();
			data = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

//	/**
//	 * 绕过双亲委派模式
//	 */
//	protected Class<?> loadClass(String name, boolean resolve)
//			throws ClassNotFoundException {
//		synchronized (getClassLoadingLock(name)) {
//			// First, check if the class has already been loaded
//			Class c = findLoadedClass(name);
//			if (c == null) {
//				c = findClass(name);
//			}
//			if (resolve) {
//				resolveClass(c);
//			}
//			return c;
//		}
//	}
}