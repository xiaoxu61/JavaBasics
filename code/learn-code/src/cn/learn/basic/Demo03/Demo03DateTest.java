package cn.learn.basic.Demo03;
/*
    计算活了多少天
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo03DateTest {
    public static void main(String[] args) throws ParseException {
        demo01();
        demo02();
    }
    /*
        闰年计算
        日历设置到指定年份的3月1日，add向前偏移一天，获取天数，29闰年
    */
    private static void demo02() {
        Calendar c = Calendar.getInstance();
        //将日历，设置指定的年的3月1日
        c.set(3000, 2, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

    private static void demo01() throws ParseException {
        System.out.println("请输入你的出生日期yyyy-MM-dd");
        //获取出生日期
        String dayString = new Scanner(System.in).next();
        //将字符串日期转为Date对象
        //创建SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dayString);

        //获取今天日期对象
        Date today = new Date();
        //两个日期转为毫秒值
        long born = date.getTime();
        long now = today.getTime();
        long second = now - born;
        if (second <= 0){
            System.out.println("你还没出生呢");
        }else {
            System.out.println(second / 1000 / 60 / 60 / 24);
        }
    }
}
