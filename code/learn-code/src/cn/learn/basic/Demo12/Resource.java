package cn.learn.basic.Demo12;
/*
    定义资源类，有2个成员变量
    name，sex
    同时有2个线程，对资源中的变量操作
    一个对name，sex赋值
    一个对name，sex做变量的打印输出
*/

public class Resource {
    public String name;
    public String sex;
    public boolean flag = false;
}
