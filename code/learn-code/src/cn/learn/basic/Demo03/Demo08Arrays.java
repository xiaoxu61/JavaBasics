package cn.learn.basic.Demo03;
/*
    ����Ĺ����࣬��������Ĳ���
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
        ���巽�����������룬�洢����10���˿��Գɼ���
            ����������˵ĳɼ����洢���µ������У������µ�����
    */
    private static int[] pracise(int[] arr) {
        //����������
        Arrays.sort(arr);
        //����������ɼ��洢���µ�������
        int[] result = new int[3];
        System.arraycopy(arr, 0, result, 0, 3);
        return result;
    }

    /*
        static String toString(����)
            ���������ַ���
    */
    private static void function_3() {
        int[] arr = {1, 4, 7, 8, 9, 10};
        String s = Arrays.toString(arr);
        System.out.println(s);
    }

    /*
        ����Ķ�������������
        static int binarySearch(����, �����ҵ�Ԫ��)
        ����ֵ��Ԫ���������г��ֵ�����
        �������ҵ�Ԫ�ز����ڣ����ص��ǣ� (- ����� - 1)
    */
    private static void function_2() {
        int[] arr = {1, 4, 7, 8, 9, 10};
        int index = Arrays.binarySearch(arr, 7);
        System.out.println(index);
        index = Arrays.binarySearch(arr, 15);
        System.out.println(index);
    }

    /*
        static void sort(����)
        ��������������
    */
    private static void function_1() {
        int[] arr = {3, 5, 1, 8, 6, 83, 1};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
