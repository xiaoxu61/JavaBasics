package cn.learn.basic.Demo10Propertise;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    public   /*transient 阻止成员变量进行序列化*/int age;
    //类中，自己定义了序列号，即使源代码改变，编译器也不会重新计算序列号，导致反序列异常
    private static final long serialVersionUID = 15684948142L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [ name=" + name + ",age=" + age + "]";
    }
}
