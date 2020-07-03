package cn.learn.basic.Demo01;
/*
创建对象的标准格式：
类名称 对象名 = new 类名称();

匿名对象就是只有右边的对象，没有左边的名字个赋值运算符
new 类名称()

注意事项：匿名对象只能使用唯一的一次，下次创建不得不再创建一个新对象
使用建议，如果确定有一个对象只需要使用唯一的一次，可以使用匿名对象

*/

import java.util.Scanner;

public class Demo21Anonymous {
    public static void main(String[] args) {
        //左边的one就是对象的名字
        Demo21Person one = new Demo21Person();
        one.name = "高圆";
        one.showname();

        //匿名对象
        new Demo21Person().name = "低扁";
        new Demo21Person().showname();
        //键盘的使用
        //普通使用
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println("普通使用输入的数字" + num);
        //匿名使用
        int num1 = new Scanner(System.in).nextInt();
        System.out.println("匿名输入数字为" + num1);
        System.out.println("==========================");
        //使用匿名对象来传参
        //methodParam(new Scanner(System.in));
        //使用匿名对象返回参数
        Scanner sc = methodReturn();
        int num = sc.nextInt();
        System.out.println("输入的是：" + num);

    }
    public static void methodParam(Scanner sc){
        System.out.println("输入一个数：");
        int num = sc.nextInt();
        System.out.println("输入的是" + num);
    }

    public static Scanner methodReturn(){
        return new Scanner(System.in);
    }

}
