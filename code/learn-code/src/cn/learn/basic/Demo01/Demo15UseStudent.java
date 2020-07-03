package cn.learn.basic.Demo01;
/*
通常情况下，一个类并不能直接使用，需要根据类创建一个对象，才能使用
  1、导包：指出需要使用的类，在什么位置
     格式：import 包名称.类名称；
     import cn.learn.basic.Demo01.Demo15Student
     对于和当前类属于同一个包的情况，可以省略导包语句不写
  2、创建
     格式：类名称 对象名 = new 类名称()
     Student stu = new Student();
  3、使用
     使用成员变量：对象名.成员变量名
     使用成员方法：对象名.成员方法名（参数）
     （也就是想用谁，就用对象名点谁）

*/

public class Demo15UseStudent {
    public static void main(String[] args) {
        //在同一目录，可以不用导包
        //不同目录下的包导入后，成员变量如何定义？
        //创建
        Demo15Student stu = new Demo15Student();
        //使用
        System.out.println(stu.name);
        System.out.println(stu.age);

        //改变对象中的成员变量值内容
        stu.name = "大肥猫";
        stu.age  = 18;
        System.out.println("===============");
        System.out.println("姓名:" + stu.name);
        System.out.println("年龄:" +stu.age);
        //使用对象的成员方法
        //对象名.成员方法名（）
        stu.eat("冠状病毒");
        stu.sleep(5);
        stu.study();
    }
}
