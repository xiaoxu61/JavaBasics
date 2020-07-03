package cn.learn.ClassDefine;

public class MyClass {
    int num;//成员变量
    static int numStatic;//静态变量
    public void method(){
        System.out.println("这是一个成员方法。");
        System.out.println(num);//没报错，说明成员变量可以访问成员变量
        System.out.println(numStatic);//成员方法可以访问静态变量
    }

    public static void methodStatic(){
        System.out.println("这是一个静态方法");
        System.out.println(numStatic);//静态方法可以访问静态变量
//        System.out.println(num);//静态不能直接访问非静态，错误写法
    }
}
