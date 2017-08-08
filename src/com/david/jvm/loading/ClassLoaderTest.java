package com.david.jvm.loading;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public ClassLoaderTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)throws Exception {
		ClassLoader myLoader=new ClassLoader(){
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try{
					String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream is=getClass().getResourceAsStream(fileName);
					if(is==null){
						return super.loadClass(name);
					}
					byte[] b=new byte[is.available()];
					is.read(b);
					return defineClass(name,b,0,b.length);
				}catch(IOException e){
					throw new ClassNotFoundException(name);
				}
			}
		};
		
		String name="com.david.vo.CompanyVO";
		Object obj=myLoader.loadClass(name).newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.david.vo.CompanyVO);
	}

}
