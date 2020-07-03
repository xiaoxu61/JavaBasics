package cn.learn.basic.Demo25;
/*
题目：
定义一个方法，把数组{1，2，3}按照指定格式拼接成一个字符串，格式参照如下：[World1#World2#World3]

分析：
1、首先准备一个int[] 数组，内容是1、2、3
2、定义一个方法，用来将数组变成字符串
三要素：
返回类型：String
方法名称：fromArrayToString
参数列表：int[]
3、格式[World1#World2#World3]
用到for循环、字符串拼接、每个元素都有一个World字样、分隔使用的是#、区分一下是不是最后一个
4、调用方法、得到返回值，并打印结果

题目：
键盘输入一个字符串，并且统计其中各种字符出现的次数
种类有：大写字母、小写字母、数字、其他

思路：
1、键盘输入，Scanner
2、键盘输入字符串 String str = sc.next()；
3、定义四个变量，分别代表四种字符各自出现的次数
4、需要对字符串一个字、一个字检查，String --> char[], 方法就是toCharArray()
5、遍历char[] 字符数组，对当前字符的种类进行判断，并且用四个变量进行++动作
6、打印输出四个变量，分别代表四种字符出现次数
*/

import java.util.Scanner;

public class Demo25StringPractise {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        String str = fromArrayToString(array);
        System.out.println(str);
        System.out.println("====================");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int countUpper = 0;//大写字符
        int countLower = 0;//小写字符
        int countNumber = 0;//数字
        int countOther = 0;//其他字符

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if ('A' <= ch && ch <= 'Z'){   //char类型在发生数学运算时，会自动转换为int类型
                countUpper++;
            }else if ('a' <= ch && ch <= 'z'){
                countLower++;
            }else if ('0' <= ch && ch <= '9'){
                countNumber++;
            }else{
                countOther++;
            }
        }
        System.out.println("大写字母有：" + countUpper);
        System.out.println("小写字母有：" + countLower);
        System.out.println("数字有：" + countNumber);
        System.out.println("其他字符有：" + countOther);
    }

    public static String fromArrayToString(int[] array){
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1){
                str += "World" + array[i] + "]";
            }else{
                str += "World" + array[i] + "#";
            }
        }
        return str;
    }
}
