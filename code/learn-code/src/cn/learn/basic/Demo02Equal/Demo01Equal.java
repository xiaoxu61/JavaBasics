package cn.learn.basic.Demo02Equal;

import java.util.ArrayList;

public class Demo01Equal {
    public static void main(String[] args) {
        /*
        person类默认继承了Object类，所以可以用Object类的equal方法
        boolean equal(Object obj)指示其他某个对象是否与此相等
        eaqual方法源代码：
            public boolean equal(Object obj) {
                return (this == obj)
            }
            this是谁？哪个对象调用的方法，方法中的this就是那个对象
            obj是谁？传递过来的参数
        参数：
            Object obj：可以传递任意对象
            == 比较运算符，返回的是一个布尔值
            基本数据类型：比较的是值
            引用数据类型：比较的是两个对象的地址值
        */
        Person one = new Person("迪丽热巴", 19);
        Person two = new Person("迪丽热巴", 19);
        Person three = new Person("古力娜扎", 20);
        System.out.println("one" + one);
        System.out.println("two" + two);
        boolean equals = one.equals(two);
        System.out.println(equals);

        ArrayList<String> list = new ArrayList<>();

        boolean b = one.equals(list);
        System.out.println(b);

        System.out.println(one.equals(one));

    }
}
