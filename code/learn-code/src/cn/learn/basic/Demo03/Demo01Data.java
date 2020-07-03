package cn.learn.basic.Demo03;
/*
    java.util.Data：表示日期和时间的类
    类 Date 表示特定的瞬间，精确到毫秒。
    毫秒：千分之一秒
    特定瞬间：一个时间点，一刹时间

    毫秒值的作用：可以对时间和日期进行计算
    2099-01-03到2088-01-01中间共有多少天
    可以日期转换为毫秒进行计算，把毫秒转换为日期

    把当前日期转换为毫秒：
        当前日期2088-01-01
        时间原点：1970 年 1 月 1 日 00:00:00（英国格林威治时间）
        就是计算当前日期到时间原点之间一共经历了多少毫秒，1581303961895
    把毫秒转换为日期：
        1 天 = 24 × 60 × 60 = 86400 秒 = 86400 * 1000 毫秒
    注意：
        中国属于东八区，会把时间增加八个小时1970 年 1 月 1 日 08:00:00
*/
import java.util.Date;
public class Demo01Data {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//获取当前系统时间一共到1970 年 1 月 1 日 00:00:00经历了多少毫秒
        demo01();
        demo02();
        demo03();
        System.out.println("=========");
        demo04();
    }
    /*
        Date类方法setTime(long)传递毫秒值
        将日期对象，设置到指定毫秒值上
        毫秒值转成日期对象
    */
    private static void demo04() {
        Date date = new Date();
        System.out.println(date);
        date.setTime(0);
        System.out.println(date);
    }

    /*
        long getTime()把日期转换为毫秒
        返回自1970 年 1 月 1 日 00:00:00 GMT 以此以来Data对象表示的毫秒
    */
    private static void demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);

    }
    /*
        Data类带参数构造方法
        Data(lang data)：传递毫秒值，把毫秒值转换为Data日期
    */
    private static void demo02() {
        Date date = new Date(0L);
        System.out.println(date);

        date = new Date(1581303961895L);
        System.out.println(date);
    }
    /*
    Data类的空参数构造方法
    Data()获取当前系统的时间和日期
    */
    private static void demo01() {
        Date date = new Date();
        System.out.println(date);
    }

}
