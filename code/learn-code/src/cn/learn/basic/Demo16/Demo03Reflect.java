package cn.learn.basic.Demo16;
/*
    反射获取私有的构造方法运行
    不推荐，破坏了程序的封装性，安全性
    暴力反射
*/

import java.lang.reflect.Constructor;

public class Demo03Reflect {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        //Constructor[] getDeclaredConstructors() 获取所有的构造方法，包括私有的
        /*Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }*/

        //Constructor getDeclaredConstructor(Class...c) 获取到指定参数列表的构造方法
        Constructor con = c.getDeclaredConstructor(int.class, String.class);

        //Constructor 类，父类AccessibleObject，定义方法setAccessible(bolean b)
        con.setAccessible(true);

        Object obj = con.newInstance(18, "lisi");
        System.out.println(obj);
    }
}
