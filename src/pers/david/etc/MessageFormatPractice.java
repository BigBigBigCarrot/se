package pers.david.etc;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MessageFormatPractice {

	public MessageFormatPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		formatPractice();
		
//		System.out.println(sum(1,2,3,4,5));
//		Integer[] integerArray={6,7,8,9,10};
//		System.out.println(sum(integerArray));
//		List<Integer> integerList=new ArrayList<Integer>();
//		integerList.add(11);
//		integerList.add(12);
//		integerList.add(13);
//		System.out.println(sum(integerList));
	}
	
	public static void formatPractice(){
//		String str="This is the Large Hadron Collider";
		String str="This is the {0} {1} {2}";
		System.out.println(str);
		str=MessageFormat.format(str, "Large","Hadron","Collider");
		System.out.println(str);
	}
	
	/**
	 * 此种参数写法(T ... arguments)只适用于多个参数或数组，不能适用于List
	 * @param arguments
	 * @return
	 */
	public static Integer sum(Integer ... arguments){
		Integer sum=0;
		for (Integer i : arguments) {
			sum=sum+i;
		}
		return sum;
	}

}
