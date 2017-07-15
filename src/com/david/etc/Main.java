package com.david.etc;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		System.out.println(args.length);
		for(String arg:args){
			System.out.println(arg);
		}
		/*
		BigDecimal a=new BigDecimal("1");
		BigDecimal b=new BigDecimal("1");
		BigDecimal c=new BigDecimal("1.0");
		
		if(a.equals(b)){
			System.out.println("a.equals(b)");
		}
		if(a.equals(c)){
			System.out.println("a.equals(c)=false");
		}
		*/
		
		/*
		String ids;
		String ids2;
		ids="12,111,2,3,554,64564";
		ids2="71";
		
		String[] idStrArray;
		idStrArray=ids.split(",");
		
		for(int i=0;i<=idStrArray.length-1;i++){
			System.out.println(idStrArray[i]);
		}
		*/
		
		/*
		String str1="中";
		System.out.println(str1.length());
		System.out.println(str1.charAt(0));
		
		String str="中文 Abc";
		String tempStr;
		System.out.println("收 件              AAAA ".length());
		*/
		
		/*
		String[][] matrix=new String[2][2];
		for(int i=0;i<=matrix.length-1;i++){
			for(int j=0;j<=matrix[].length-1;i++){
				
			}
		}
		*/
		
		/*
		Map<String[],String[]> map=new HashMap<String[],String[]>();
		
		String[] strArray=new String[3];
		strArray[0]="0";
		strArray[1]="1";
		strArray[2]="2";
		map.put(strArray, strArray);
		
		String[] strArray2=new String[3];
		strArray2[0]="0";
		strArray2[1]="1";
		strArray2[2]="2";
		
		System.out.println(map.get(strArray2));
		*/
		
		/*
		String[][][] s2D;
		s2D=new String[3][3][3];
		s2D[0][0][0]=new String();
		System.out.println(s2D.getClass().isArray());
		System.out.println(s2D[0].getClass().isArray());
		System.out.println(s2D[0][0].getClass().isArray());
		System.out.println(s2D[0][0][0].getClass().isArray());
		*/
		
		/*
		int[][][] arr = new int[1][2][3];
		arr[0][0][0]=1;
		String str = arr.toString();
		System.out.println(arr.toString());
		System.out.println(arr[0].toString());
		System.out.println(arr[0][0].toString());
		System.out.println(arr[0][0].toString());
		//System.out.println("该数组的维数：" + (str.indexOf("@")-1));
		*/
		
		/*
		Map<String,String> map2=new HashMap<String,String>();
		String str1="2967045813";
		String str2="2867045813";
		map2.put(str1, str1);
		System.out.println(map2.get(str2));
		*/
		
		/*
		Integer a,b;
		a=new Integer(1);
		a=new Integer(2);
		*/
		
		/*
		String a,b;
		a="a";
		b=a;
		a=null;
		System.out.println(a);
		System.out.println(b);
		*/
		
		/*
		String str="";
		if(str.getClass().equals(String.class)){
			System.out.println("==");
		}
		System.out.println(str.getClass().getName());
		*/
//		Map<String,Object> map=new HashMap<String,Object>();
//		System.out.println(map.get("123").toString());
	}

}
