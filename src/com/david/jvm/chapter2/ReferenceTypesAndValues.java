package com.david.jvm.chapter2;

import java.text.MessageFormat;
import java.util.Formatter;


/**
 * JVM-Specification-chapter2-2.4. Reference Types and Values
 * JVM-Specification数组部分介绍截取：
 	 * An array type consists of a component type with a single dimension 
	 * (whose length is not given by the type). 
	 * The component type of an array type may itself be an array type. 
	 * If, starting from any array type, one considers its component type, and then 
	 * (if that is also an array type) the component type of that type, and so on, 
	 * eventually one must reach a component type that is not an array type; 
	 * this is called the element type of the array type. 
	 * The element type of an array type is necessarily either a primitive type, or a class type, or an interface type.
 * 大致理解：
 	 * 所有数组不论几维，都是基于一维数组实现的，数组中的每个部分称为component type
	 * 数组中的component type可以是数组类型，也可以是基础数据类型、对象、接口（当component type为基础数据类型、对象、接口时，称作element type ）
	 * 当数组中的component type为element type时，即为一维数组
	 * 当数组中的component type也是数组时，即为多维数组
 * @author david
 *
 */
public class ReferenceTypesAndValues {

	public ReferenceTypesAndValues() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
//		arrayTest1();
		arrayTest2();
	}
	
	/**
	 * 行数确定，每行的列数不确定的二维数组
	 */
	public static void arrayTest1(){
		
		/**
		 * 二维数组，在声明时即告诉jvm所需分配的空间为2行2列
		 * 引用指向一个一维数组，一维数组中的component type为一维数组
		 */
		String[][] strArray=new String[2][2];
		
		/**
		 * 声明一个二维数组，其中引用指向一个一维数组，指定一维数组长度为2，数组中的component type为一维数组，长度未指定
		 */
		String[][] strArbitraryArray=new String[2][];
		strArbitraryArray[0]=new String[2];
		strArbitraryArray[1]=new String[3];
		for (int i = 0; i < strArbitraryArray.length; i++) {
			for (int j = 0; j < strArbitraryArray[i].length; j++) {
				strArbitraryArray[i][j]="[{0}][{1}]";
				strArbitraryArray[i][j]=MessageFormat.format(strArbitraryArray[i][j],i,j);
				System.out.println(strArbitraryArray[i][j]);
			}
		}
	}
	
	/**
	 * 数组getClass
	 */
	public static void arrayTest2(){
		String str="";
		String[] strArray1=new String[1];
		String[][] strArray2=new String[1][];
		System.out.println(str.getClass().getName());
		System.out.println(strArray1.getClass().getName());
		System.out.println(strArray2.getClass().getName());
	}

}
