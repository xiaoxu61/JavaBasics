package cn.learn.basic.Demo03;
/*
java.text.DateFormat：DateFormat 是日期/时间格式化子类的抽象类
作用：格式化（也就是日期 -> 文本）、解析（文本-> 日期）
成员方法：
    String format(Date date)：按照指定模式，格式化为符合模式的字符串
    Date parse(String source)：把符合模式的字符串，解析为Date日期
DateFormat类是一个抽象类，无法直接创建对象使用，可以使用DateFormat类的子类

java.text.SimpleDateFormat extends DateFormat
构造方法：
    SimpleDateFormat(String pattern)
        用给定模式和默认语言环境的日期格式构造符号SimpleDateFormat
    参数：
        String pattern：传递指定的模式
    模式：区分大小写y  M  d  H  m  s
                   年 月 日 时 分 秒
          写对对应的模式，会把模式替换为对应的日期和时间
          "yyyy-MM-dd HH:mm:ss"
          注意：
            模式中的字母不能更改，连接模式的符号可以改变
            "yyyy年MM月dd日 HH时mm分ss秒"
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02DateFormat {

    public static void main(String[] args) throws ParseException {
        demo01();
        System.out.println("=====================");
        demo02();
    }

    /*
    使用DateFoemat类中的方法parse，把文本解析为日期
    使用步骤：
        1、创建SimpleDateFormat对象，构造方法中传递指定的模式
        2、调用SimpleDateFormat对象中的parse，把符合构造方法中模式的字符串，解析为Date日期
        注意：
            parse方法申明了一个异常叫ParseException
            如果一个字符串和构造方法的模式不一样，那么就会抛出次异常
            调用一个抛出了异常的方法，就必须处理这个异常，要么throws继续抛出这个异常，要么try catch自己处理
    */
    private static void demo02() throws ParseException {
        //创建SimpleDateFormat对象，构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2、调用SimpleDateFormat对象中的parse，把符合构造方法中模式的字符串，解析为Date日期
        //Date parse(String source)：把符合模式的字符串，解析为Date日期
        Date date =  sdf.parse("2020-02-11 11:18:04");
        System.out.println(date);
    }

    /*
    使用DateFormat类中的方法format，把日期格式化为文本
    使用步骤：
            1、创建SimpleDateFormat对象，构造方法中传递指定的模式
            2、调用SimpleDateFormat对象中的format。按照构造方法中指定的模式。把Date日期格式化为符合模式的字符串
    */
    private static void demo01() {
        //创建SimpleDateFormat对象，构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //调用SimpleDateFormat对象中的方法format，按照构造方法中指定的模式，把Date日期转化为符合模式的字符串（文本）
        //String format(Date date) 按照指定的模式，把Date日期，格式化为符合模式的字符串
        Date date = new Date();
        String d = sdf.format(date);
        System.out.println(date);
        System.out.println(d);
    }
}
