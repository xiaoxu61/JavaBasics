package cn.learn.basic.Demo03;
/*
java.util.Calender类：日历类
Calender是一个抽象类，提供了很多操作日历字段的方法（YEAR、MONTH、DAY_OF_MONTH、HOUR ）
Calender类无法直接使用，里面有一个静态方法叫getInstance(),该方法返回了Calender类的子类对象
static Calender getInstance() 使用默认时区和语言环境获得一个日历

Calender类常用的成员方法：
    public int get(int field)：返回给定日历字段的值
    public void set(int field, int value)：将给定的日历字段设置为给定值
    public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量
    public Date getTime()：返回一个表示此Calender时间值，从历元到现在的毫秒偏移量，的Date对象
成员方法的参数：
    int field：日历类的字段，可以使用Calender类的静态成员变量获取
        public static final int YEAR = 1; 年
        public static final int MONTH = 1; 月
        public static final int DATE = 1; 年中的某一天
        public static final int DAY_OF_MONTH = 1; 月中的某一天
        public static final int HOUR = 1; 时
        public static final int MINUTE = 1; 分
        public static final int SECOND = 1; 秒
*/

import java.util.Calendar;
import java.util.Date;

public class Demo03Calender {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        demo01();
        System.out.println("===================");
        Demo02();
        System.out.println("====================");
        Demo03();
        System.out.println("====================");
        Demo04();
        System.out.println("=====================");
        Demo05();
    }

    private static void Demo05() {
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();

        born.set(Calendar.YEAR, 2019);
        born.set(Calendar.MONTH, 01);
        born.set(Calendar.DATE, 14);

        int day = born.get(Calendar.DATE);
        int day1 = now.get(Calendar.DATE);
        System.out.println(day1-day);
    }

    /*
    public Date getTime()：返回一个表示此Calender时间值，从历元到现在的毫秒偏移量，的Date对象
    把日历对象，转换为日期对象
    */
    private static void Demo04() {
        Calendar c = Calendar.getInstance();

        Date date = c.getTime();
        System.out.println(date);

    }

    /*
    public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量
    把指定的字段增加/减少指定的值
    参数：
        int field：传递指定的日历字段
        int amount：增加/减少指定的值；正数增加，负数减少
    */
    private static void Demo03() {
        //使用getInstance方法获取Calender对象
        Calendar c = Calendar.getInstance();

        //把年增加两年
        c.add(Calendar.YEAR, 2);
        //把月份减少三个月
        c.add(Calendar.MONTH, -3);


        int year =  c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//西方的月份0~11月，东方1~12月

        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

    /*
    public void set(int field, int value)：将给定的日历字段设置为给定值
    参数：
        int field：传递指定的日历字段
        int value：给定字段设置的值
    */
    private static void Demo02() {
        Calendar c = Calendar.getInstance();

        //设置年为9999年
        c.set(Calendar.YEAR, 9999);
        //设置月
        c.set(Calendar.MONTH, 9);
        //设置日
        c.set(Calendar.DATE, 9);
        //同时设置年月日，可以使用set的方法重载
        c.set(8888, 8, 8);

        int year =  c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//西方的月份0~11月，东方1~12月

        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

    /*
    public int get(int field)：返回给定日历字段的值
    参数：传递指定的日历字段（YEAR，MONTH...）
    返回值：日历字段代表的具体的值
    */
    private static void demo01() {
        //使用getInstance方法获取Calender对象
        Calendar c = Calendar.getInstance();
        int year =  c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//西方的月份0~11月，东方1~12月

        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }
}
