package cn.learn.basic.Demo25;
/*
    java.lang.StringBuilder类：字符串缓冲区，可以提高字符串的效率
    构造方法：
        StringBuilder()
            构造一个不带任何字符的字符串生成器，其初始容量为16字符
        StringBuilder(String str)构造一个字符串生成器，并初始化为指定的字符串内容

    StringBuilder的常用方法：
        public StringBuilder oppend(...)：添加任意类型数据的字符串形式，并返回当前对象自身
    StringBulider和String可以相互转换：
        String --> StringBuilder：可以使用StringBuilder的构造方法
            StringBuilder(String str)构造一个字符串生成器，并初始化为指定的字符串内容
        StringBuilder --> String：可以使用StringBuilder中的toString方法
            public String toString()：将当前StringBuilder对象转换为String对象
*/

public class Demo05StringBuilder {
    public static void main(String[] args) {
        //空参数构造方法
        StringBuilder bu1 = new StringBuilder();
        System.out.println(bu1);//空字符串
        //带字符串构造方法
        StringBuilder bu2 = new StringBuilder("abc");
        System.out.println(bu2);
        System.out.println("==================");
        //使用append方法往StringBuilder中添加数据
        //返回的是this.调用方法的对象
        StringBuilder bu3 = bu1.append("abc");
        System.out.println(bu1);
        System.out.println(bu3);
        System.out.println(bu1 == bu3);

        //使用appen方法无需接收返回值
        StringBuilder bu = new StringBuilder();
        bu.append("abc");
        bu.append(1);
        bu.append(true);
        System.out.println(bu);

        /*
        链式编程：方法返回值是一个对象，可以继续调用方法
        */
        System.out.println("abc".toUpperCase().toLowerCase().toUpperCase().toLowerCase());
        bu.append("abc").append(1).append(true).append("中");
        System.out.println(bu);
        System.out.println("==========================");

        //String --> StringBuilder
        String str = "hello";
        System.out.println(str);
        StringBuilder sbu = new StringBuilder(str);
        //往StringBuilder中添加数据
        sbu.append("world");
        System.out.println(sbu);

        //StringBuilder --> String
        String s = sbu.toString();
        System.out.println(s);
    }
}
