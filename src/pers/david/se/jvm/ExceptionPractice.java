package pers.david.se.jvm;

public class ExceptionPractice {

    public ExceptionPractice() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        System.out.println(f());
        f2();
    }

    public static int f() {
        int x;
        try {
//			x=1;
            x = 2;

            if (x == 1) {
                throw new NullPointerException();
            }
            if (x == 2) {
                throw new ArrayIndexOutOfBoundsException();
            }


            return x;
        } catch (NullPointerException e) {
            System.out.println("execute the catch bolck");
            x = 2;
            return x;
        } finally {
            System.out.println("execute the finally bolck");
            x = 3;
            System.out.println("value of the local variable 'x' after execute the finally bolck:" + x);
//			return 3;
        }
    }

    /**
     * 对可能出现的异常不做catch，而是抛出给方法的调用者
     *
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void f2() throws ArrayIndexOutOfBoundsException {
        int[] a = {1};
        a[1]++;
        /**
         * 如果有catch中对应的异常被抛出，则先执行catch，然后再执行finally
         * 不管有没有执行catch，finally都会在最后被执行
         * finally后面的代码不会被执行
         */
    }

}
