package cn.learn.basic.Demo16;
/*
    通过反射获取class文件中的构造方法，运行构造方法
    运行构造方法，创建对象
        获取class文件对象
        从class文件对象中，获取需要的成员
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo02Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        //使用class文件对象，获取类中的构造方法
        //Constructor[] getConstructors() 获取class文件对象中的所有公共的构造方法
        /*Constructor[] cons = c.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }*/

        /*//获取指定的构造方法，空参数的构造方法
        Constructor con = c.getConstructor();
        System.out.println(con);
        //运行空参数构造方法，Constructor类方法 newInstance() 运行获取到的构造方法
        Object o = con.newInstance();
        System.out.println(o);*/

        //获取带有String，int参数的构造方法
        //Constructor<T> getConstructor(Class<?>...parameterTypes)
        //Class<?>...parameterTypes  传递要获取的构造方法相对应的参数列表
        /*Constructor con = c.getConstructor(String.class, int.class);
        System.out.println(con);
        //运行构造方法
        // T newInstance(Object...initargs) 运行构造方法后，传递的实际参数
        Object obj = con.newInstance("张三", 20);
        System.out.println(obj);*/

        /*
            反射获取构造方法并运行，有快捷点的方式
            前提：
                被反射的类，必须有空参数构造方法
                构造方法权限必须public

            Class类中定义的方法，T newInstance() 直接创建被反射类的对象实例
        */
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
