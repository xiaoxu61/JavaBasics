package cn.learn.basic.Demo16;
/*
    定义集合类，泛型String
    要求向集合中添加Integer类型

    反射方式，获取除集合ArrayList类的class文件对象
    通过class文件对象，调用add方法

*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo07Reflect {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> array = new ArrayList<>();
        array.add("a");
        //反射方式，获取除集合ArrayList类的class文件对象
        Class c = array.getClass();
        //获取ArrayList.class文件中的方法add
        Method method = c.getMethod("add", Object.class);
        System.out.println(method);

        //使用invoke运行ArrayList方法add
        method.invoke(array, 150);
        method.invoke(array, 10);
        method.invoke(array, 1500);

        System.out.println(array);
    }
}
