package pers.david.etc;

/**
 * @Description
 * @author Bu Dawei
 * @date 2020年1月15日
 * @version 
 */
public class LogicalOperator {

	/**
	 * 
	 */
	public LogicalOperator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		f1();

	}
	/**
	 * &与&&的区别（对|同理）
	 * 相同点：逻辑运算结果相同
	 * 不同点：&前面可以确定结果后还会执行后面的语句，而&&反之
	 */
	public static void f1() {
		int num1=0;
		int num2=0;
		if(false&num1++>0) {
			System.out.println("b1");
		}
		
		if(false&&num2++>0) {
			System.out.println("b2");
		}
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
	}

}
