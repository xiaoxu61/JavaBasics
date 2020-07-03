package cn.learn.basic.Demo01;
/*
  定义一个类，用来模拟“学生”事务
  属性（是什么）
     姓名
     年龄
  行为（能做什么）
     吃饭
     睡觉
     学习
  对应到Jave的类当中：

  成员变量：
     String name
     int age
  成员方法
     public void eat(){}
     public void sleep(){}
     public void study(){}

注意事项：
   1、成员变量是直接定义在类当中，在方法外边
   2、成员方法不要写在static关键字

*/

public class Demo15Student {
    //成员变量
    String name; //姓名
    int age;     //年龄
    //成员方法
    public void eat(String what){
        System.out.println("吃"+ what);
    }
    public void sleep(int hour){
        System.out.println("一觉睡"+ hour + "小时");
    }
    public void study(){
        System.out.println("Study");
    }

}
