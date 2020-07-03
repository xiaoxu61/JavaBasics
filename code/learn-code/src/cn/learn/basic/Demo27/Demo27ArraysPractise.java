package cn.learn.basic.Demo27;
/*
题目：
    请使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印
*/

import java.util.Arrays;

public class Demo27ArraysPractise {
    public static void main(String[] args) {
        String str = "ssdv67ui3hfh2f87374fb478gf83v";

        //如何进行升序排列：sort
        //必须是一个数组，才能使用Arrays.sort方法
        //String --> 数组，用tocharArray
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        //需要倒序遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
