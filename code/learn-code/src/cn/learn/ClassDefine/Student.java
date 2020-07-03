package cn.learn.ClassDefine;

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

public class Student{
    //成员变量
    private int id;//学号
    private static int idCounter = 0;//学号计数器，每当new了一个新对象的时候，计数器++
    private String name; //姓名
    private int age;     //年龄
    private static String room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        Student.room = room;
    }

    public Student() {
        this.id = ++idCounter;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //成员方法
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
    public void study(){
        System.out.println("Study");
    }


}

