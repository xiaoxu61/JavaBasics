package cn.learn.basic.Demo27;
/*
java.util.Arrays是一个与数组相关的工具，里面提供了大量静态方法，用来实现数组常见的操作。

public static String toString(数组)：将参数数组变成字符串（按照默认格式：[元素1,元素2,.......]）
public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序

备注：
    1、如果是数值，sort默认按照升序从小到大
    2、如果是字符串，sort默认按照字母升序
    3、如果是自定义的类型，那么这个自定义的类需要用Comparable或者Comparator接口的支持。
*/

import java.util.Arrays;

public class Demo27Arrays {
    public static void main(String[] args) {
        int[] intArray = {40, 30, 20, 5, 8, 75};
        //将int[]数组按照默认格式变成字符串
        String inStr = Arrays.toString(intArray);
        System.out.println(inStr);//[20, 30, 40]

        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        String[] array2 = {"bbb", "aaa", "ccc"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
