package pers.david.se.io;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -167022683232173910L;
    //serialVersionUID：用来表示当前类的版本，如果不显示给出，那么将由java自动生成，
    //java根据这个字段来判断对象序列化时的版本与当前要序列化的版本是否一致，即在这个对象所属的类序列化后，这个类的声明有没有本修改过。
//	private static final long serialVersionUID = -1L;

    private String name;
//	private String email;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }

}
