package com.david.jvm;

public class ExceptionPractice {

	public ExceptionPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(f());
	}
	
	public static int f(){
		int x;
		try{
//			x=1;
			x=2;

			if(x==1){
				throw new NullPointerException();
			}
			if(x==2){
				throw new ArrayIndexOutOfBoundsException();
			}
			
			
			return x;
		}catch(NullPointerException e){
			x=2;
			return x;
		}
		finally{
			System.out.println("execute the finally bolck");
			x=3;
			System.out.println("value of the local variable 'x' after execute the finally bolck:"+x);
//			return 3;
		}
	}

}
