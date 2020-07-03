package cn.learn.basic.Demo16;
/*
    通过反射，获取有参数的构造方法并运行
    方法getConstructor，传递可以构造方法相对于的参数列表即可
*/

import java.lang.reflect.Method;

public class Demo06Reflect {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.learn.basic.Demo16.Person");
        Object obj = c.newInstance();

        Method method = c.getMethod("sleep", String.class, int.class, double.class);

        method.invoke(obj, "休眠", 100, 888.99);

    }
}
