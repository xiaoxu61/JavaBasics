package cn.learn.basic.Demo26;
/*
如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类，多个对象共享一份数据
*/

import cn.learn.ClassDefine.Student;

public class Demo26StaticField {
    public static void main(String[] args) {
        Student one = new Student("郭靖",15);
        one.setRoom("105教室");
        System.out.println("姓名：" + one.getName() + ",年龄：" + one.getAge()
                + "，学号：" + one.getId() + ",班级：" + one.getRoom());

        Student two = new Student("郭靖1",151);
        System.out.println("姓名：" + two.getName() + ",年龄：" + two.getAge()
                + "，学号：" + two.getId() + ",班级：" + two.getRoom());
    }
}
