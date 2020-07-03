package cn.learn.basic.Demo25;
/*
正则表达式规则匹配练习：
规则：
    1、"[0-9]{6,12}",长度为6位到12位的数字
    2、"1[34578][0-9]{9}"，十一位的手机号码，第2位为34578中一个，后面9位为0到9之间任意数字
    3、"a*b"，在多个a或零个a后面有个b，b必须为最后一个字符

String类三个和正则表达式相关的方法：
    boolean matches(String 正则的规则)
    "abc".matches("[a]") 匹配成功返回true

    String[] split(String 正则的规则)
    "abc".split("a")使用规则将字符串进行切割

    String replaceAll(String 正则规则, String 字符串)
    "abc0123".replcaeAll("[\\d]", "#")
    安装正则的规则，替换字符串
*/

public class Demo01Pattern {
    public static void main(String[] args) {
        checkQQ();
        checkPhone();
        split_1();
        split_2();
        replace_1();
        check_Email();
    }
    /*
       检查邮件地址是否合法，规则：
            123456@qq.com
            mymail@sina.com
            nimail@163.com
            wodemail@yahoo.com

            @前，包含数字字母下划线，个数未知，不能少于一个
            @后 . 前面，数字字母，个数不少于一个
            . 后面  字母
    */
    private static void check_Email() {
        String email = "abc133@sina.com.cn";
        boolean b = email.matches("[a-zA-Z0-9]+@[0-9a-z]+(\\.[a-z])+");
        System.out.println(b);
    }

    /*
        Hello12345World6789012 将所有数字替换掉
        String类方法replaceAll（正则规则，替换后的新字符串）
    */
    private static void replace_1() {
        String str = "Hello12345World6789012";

        String str1 = str.replaceAll("[\\d]", "#");
        String str2 = str.replaceAll("[\\d]+", "#");
        System.out.println(str1);
        System.out.println(str2);
    }

    /*
        String类方法split对字符串进行切割
        192.168.105.27 按照.进行切割字符串
    */
    private static void split_2() {
        String ip = "192.168.105.27";
        String[] IPArr = ip.split("\\.+");
        for (int i = 0; i < IPArr.length; i++) {
            System.out.println(IPArr[i]);
        }
    }

    /*
        String类方法，split对字符串进行切割
        12-25-36-49 按照-对字符串进行切割
    */
    private static void split_1() {
        String str = "12-25-36-49";
        String[] split = str.split("-");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        String str1 = "ads  cd5 5s4              df54      sd";
        String[] str1Arr = str1.split(" +");
        for (int i = 0; i < str1Arr.length; i++) {
            System.out.println(str1Arr[i]);
        }
    }

    /*
        手机号码1开头，可以是34578，0-9位固定11位
    */
    private static void checkPhone() {
        String telNumber = "1335756852";
        boolean matches = telNumber.matches("1[34578][\\d]{9}");
        System.out.println(matches);
    }

    /*
        检查QQ号码是否合法
        0不能开头，全数字，位数5，10位
    */
    public static void checkQQ(){
        String QQ = "122234";
        //检查QQ号码和规则是否匹配，String类的方法matches
        boolean b = QQ.matches("[1-9][\\d]{4,9}");
        System.out.println(b);
    }
}
