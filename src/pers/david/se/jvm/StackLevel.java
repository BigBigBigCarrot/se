package pers.david.se.jvm;

public class StackLevel {
    public static int counter = 0;//
//	private int level = 1;
//	int a;
//	String str="";
//	BinaryTree tree=new BinaryTree(new Node(1));

    public void stackLevel() {
        counter = counter + 1;

        //基本类型
//		int a=1,b=2,c=3;
        //操作符（操作数栈）
//		int a=1+2+3+4+5+6+7;
        //对象引用(reference)
//		String s1="",s2="",s3="";

        //方法调用
//		f();
//		System.out.println("stackLevel() executed");
//		System.out.println("counter:"+counter);
        //tree.add(new Node(1));//


        //循环体
//		for(int i=0;i<=0;i++){	
//		}

//		if(level==10000){
//			return;
//		}
        stackLevel();
    }

    public void f() {

    }

    public static void main(String[] args) throws Throwable {
        StackLevel sl = new StackLevel();
        try {
            sl.stackLevel();
        } catch (StackOverflowError e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("counter:" + StackLevel.counter);
        }
    }
}
