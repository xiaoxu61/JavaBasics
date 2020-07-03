package cn.learn.basic.Demo24;
/*
1、自定义四个学生对象，添加到集合并遍历

思路：
    1、自定义Student学生类，四个部分
    2、创建一个集合，用来存储学生对象，泛型：<Student>
    3、根据类，创建四个学生对象
    4、将四个学生对象添加到集合中：add
    5、遍历集合：for、size、get

2、定义以指定格式打印集合的方法（ArrayList类型作为参数），使用{}括起来集合，使用@分隔每个元素
   格式参照{元素@元素@元素}

*/

import cn.learn.ClassDefine.Student;

import java.util.ArrayList;

public class Demo24ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student one = new Student("洪七公",50);
        Student two = new Student("洪七爷",26);
        Student three = new Student("洪金宝",20);
        Student four = new Student("洪四爷",10);
        //添加人口
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        //遍历人口
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("小子：" + stu.getName() + ",芳龄：" + stu.getAge());
        }
        System.out.println("==========================");
        System.out.println(list);
        printAarrayList(list);
    }
    /*
    定义方法的三要素
        返回值类型：只是进行打印而已，没有运算，没有结果，所以用void
        方法名称：printArraylist
        参数列表：ArrayList
    */
    public static void printAarrayList(ArrayList<Student> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            Student temp = list.get(i);
            if(i < list.size() - 1){
                System.out.print(temp.getName() + "@");
            }else{
                System.out.println(temp.getName() + "}");
            }
        }
    }
}
