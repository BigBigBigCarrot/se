package com.david.etc;

import java.util.Timer;
import java.util.TimerTask;

public class TimerPractice {

	public TimerPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		f1();
	}
	
	public static void f1(){
		Timer timer=new Timer();
		timer.schedule(new MyTimerTask1(), 2000);
	}
	
	static class MyTimerTask1 extends TimerTask {  
        public void run() {
            System.out.println("run");  
        }  
    } 

}
