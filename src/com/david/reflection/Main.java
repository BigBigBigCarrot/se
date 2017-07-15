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
		
		try{
			//获取代表"java.lang.Integer"的Class对象的引用（instance）
			//获取不到时抛出ClassNotFoundException
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

}
