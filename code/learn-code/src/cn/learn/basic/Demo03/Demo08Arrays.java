package cn.learn.basic.Demo03;
/*
    数组的工具类，包含数组的操作
    java.util.Arrays
*/

import java.util.Arrays;

public class Demo08Arrays {
    public static void main(String[] args) {
        function_1();
        System.out.println("===========");
        function_2();
        System.out.println("==========");
        function_3();
        System.out.println("==========");
        int[] arr = {56, 65, 59, 72, 89, 95, 11, 6, 100, 50};
        int[] list = pracise(arr);
        System.out.println(Arrays.toString(list));
    }
    /*
        定义方法，接收输入，存储的是10个人考试成绩，
            将最后三个人的成绩，存储到新的数组中，返回新的数组
    */
    private static int[] pracise(int[] arr) {
        //对数组排序
        Arrays.sort(arr);
        //将最后三个成绩存储到新的数组中
        int[] result = new int[3];
        System.arraycopy(arr, 0, result, 0, 3);
        return result;
    }

    /*
        static String toString(数组)
            将数组变成字符串
    */
    private static void function_3() {
        int[] arr = {1, 4, 7, 8, 9, 10};
        String s = Arrays.toString(arr);
        System.out.println(s);
    }

    /*
        数组的二分搜索法查找
        static int binarySearch(数组, 被查找的元素)
        返回值：元素在数组中出现的索引
        若被查找的元素不存在，返回的是： (- 插入点 - 1)
    */
    private static void function_2() {
        int[] arr = {1, 4, 7, 8, 9, 10};
        int index = Arrays.binarySearch(arr, 7);
        System.out.println(index);
        index = Arrays.binarySearch(arr, 15);
        System.out.println(index);
    }

    /*
        static void sort(数组)
        对数组升序排列
    */
    private static void function_1() {
        int[] arr = {3, 5, 1, 8, 6, 83, 1};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
