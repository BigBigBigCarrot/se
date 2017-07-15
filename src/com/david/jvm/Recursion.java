package com.david.jvm;

public class Recursion {
	private static long f(long n){
		if(n<0){
			return 0;
		}
		if(n==0||n==1){
			return n;
		}
		return n*f(n-1);
	}

	public Recursion() {
	}
	
	public static void main(String[] args){
		long result=Recursion.f(20);
		System.out.println(result);
	}
	
	

}
