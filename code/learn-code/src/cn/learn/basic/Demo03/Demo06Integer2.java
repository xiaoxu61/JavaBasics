package cn.learn.basic.Demo03;
/*
基本类型和字符串之间的相互转换
    基本类型 --> 字符串（String）
        1、基本类型值 + ""  最简单的方法（工作中常用）
        2、包装类的静态方法toString(参数)，不是Object类的toString()重载
            static String toString(int i)返回一个表示指定整数的 String 对象
        3、String 的静态方法，valueOf(参数)
            static String valueOf(int i) 返回int参数的字符串表示形式
    字符串(String) --> 基本类型
        包装类的静态方法parseXXX("字符串")
            Integer类：static int parseInt(String s)
            Double类：static double parseDouble(String s)
*/

public class Demo06Integer2 {
    public static void main(String[] args) {
        //基本类型 --> 字符串
        int i1 = 100;
        String s1 = i1 + "";
        System.out.println(s1);

        String s2 = Integer.toString(100);
        //toString(int ,int 进制),将int整数，转成指定进制数
        String s21 = Integer.toString(5,2);
        System.out.println(s2 + 200);
        System.out.println(s21);

        String s3 = String.valueOf(100);
        System.out.println(s3 + 300);

        //字符串(String) --> 基本类型
        int i = Integer.parseInt(s1);
        System.out.println(i + 10);

        int in2 = Integer.parseInt("110", 2);
        //radix：基数，110，2含义，前面数字是二进制，但是方法parseInt运行结果是十进制的
        System.out.println(in2);

//        int a = Integer.parseInt("a");//数据异常
    }
}
