package com.david.reflection;

public class Main {
	public static String reverse(String str){
		if(str==null||str.length()==1){
			return str;
		}
		return reverse(str.substring(1))+str.charAt(0);
	}

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		String v1="";
//		System.out.println(v1.getClass().getName());
//		String str="123456";
//		String reversedStr=Main.reverse(str);
//		System.out.println(reversedStr);
//		ClassLoader cl;
//		f1();
		f2();
		
		
	}
	
	public static void f1(){
		try{
			Class c=Class.forName("java.lang.Integer");
			
			System.out.println(c);
			System.out.println(c.getName());
			System.out.println(c.getClass().getName());
		}catch(ClassNotFoundException e){
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}
	

	public static void f2(){
		Object o=new String("");
		System.out.println(o.getClass().getName());
	}

}
