package cn.learn.basic.Demo16;

/*
    调用Person的方法，调用Student方法，调用Worker方法
    类不清楚，方法也不清楚
    通过配置文件实现此功能
        运行的类名和方法名字，以键值对的形式，写在文本中
        运行哪个，读取配置文件即可

    实现步骤：
        1、准备配置文件，键值对
        2、IO流读取配置文件Reader
        3、文件中的键值对存储到集合中Properties
        4、反射获取指定类的class文件对象
        5、class文件对象，获取指定的方法
        6、运行方法
*/

import cn.learn.basic.Demo13JDBC.Demo08Properties;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo08Test {
    public static void main(String[] args) throws Exception{
        //IO读取配置文件
        InputStream r = Demo08Properties.class.getClassLoader().getResourceAsStream("config.properties");
        //创建集合对象
        Properties pro = new Properties();
        //调用集合load，传递对象流
        pro.load(r);
        r.close();
        //通过键来获取值
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //反射获取指定类的class文件对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        //获取指定的方法名
        Method method = c.getMethod(methodName);
        method.invoke(obj);
    }
}
