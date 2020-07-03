package cn.learn.basic.Demo26;
/*
静态代码块的格式是：
    public class 类名称{
          static{
          //静态代码块的内容
          }
    }
特点：当第一次执行用到本类时，静态代码块执行唯一的一次
静态内容时优先于非静态，所以静态代码块比构造方法执行

静态代码块的典型用途：
   用来一次性的对静态成员变量进行赋值
*/

import cn.learn.ClassDefine.StaticPerson;

public class Demo26Static {
    public static void main(String[] args) {
        StaticPerson one = new StaticPerson();
        StaticPerson two = new StaticPerson();
    }
}
