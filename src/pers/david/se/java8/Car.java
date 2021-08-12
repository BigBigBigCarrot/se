package pers.david.se.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Author david
 * @Description TODO
 * @Date 2021年05月15日 11:57:00
 */
public class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

//    提供一个有参构造器后，编译器就不再隐式提供无参构造器，此时使用Car::new即构造器引用的方式来引用无参构造器就会失败
//    public Car(String name){
//    }

    public static void main(String[] args) {
//        构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        final Car car = Car.create( Car::new );
        System.out.println(car);
//        等价于
        Supplier<Car> carSupplier=()->new Car();
        final Car car2 = Car.create( carSupplier );
        System.out.println(car2);

        final List< Car > cars = Arrays.asList( car,car2 );
//        静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach( Car::collide );

//        特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach( Car::repair );

//        特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

//
        List<String> names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}