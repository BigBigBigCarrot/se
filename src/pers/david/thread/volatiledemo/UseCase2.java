package pers.david.thread.volatiledemo;
/**
 * 
 * @Description
 * 	volatile使用场景2：可以作为刷新之前操作的触发器
 * @author Bu Dawei
 * @date 2020年3月15日
 * @version
 */
public class UseCase2 {
	int a=1;
	int b=2;
	int c=3;
	volatile boolean flag=false;
	
	public void write() {
		a=100;
		b=200;
		c=300;
		flag=true;
	}
	
	public void read() {
		while(flag) {
			System.out.println("a="+a+" b="+b+" c="+c);
		}
		
	}

	public static void main(String[] args) {
		final UseCase2 uc2=new UseCase2();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				uc2.write();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				uc2.read();
			}
		}).start();
	}

}
