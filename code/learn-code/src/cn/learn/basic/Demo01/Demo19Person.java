package cn.learn.basic.Demo01;
/*
当方法的局部变量和类的成员变量重名时，根据就近原则，优先使用局部变量
如果需要访问本类方法中的成员变量，需要使用格式
this.成员变量名

"通过谁调用的方法，随就是this"

一个标准的类通常要拥有下面四个组成部分
1、所有的成员变量都要使用private关键字修饰
2、为每一个成员变量编写一对Getter/Setter方法
3、编写一个无参数的构造方法
4、编写一个全参数的构造方法

这样标准的类也叫做Java Bean

*/

public class Demo19Person {
    String name;//名字
    String name1;//另一个方法的名字
    private String name2;
    private int age;

    //参数是对方的名字
    //name是自己的名字
    public void sayHello(String who){
        System.out.println(who + "，你好！我是" + name);
    }

    public void SayHello(String name1){

        System.out.println(name1 + "，你好！我是" + name1);
        System.out.println(name1 + "，你好！我是" + this.name1);

        System.out.println(this);
    }
    //无参数构造方法
    public Demo19Person(){
        System.out.println("无参数构造方法执行了!");
    }
    //全参数构造方法
    public Demo19Person(String name2, int age){
        System.out.println("有参数构造方法执行了!");
        this.name2 = name2;
        this.age = age;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName2() {
        return name2;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
