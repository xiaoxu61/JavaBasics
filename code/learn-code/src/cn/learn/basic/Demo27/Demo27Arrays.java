package cn.learn.basic.Demo27;
/*
java.util.Arrays��һ����������صĹ��ߣ������ṩ�˴�����̬����������ʵ�����鳣���Ĳ�����

public static String toString(����)���������������ַ���������Ĭ�ϸ�ʽ��[Ԫ��1,Ԫ��2,.......]��
public static void sort(����)������Ĭ�����򣨴�С���󣩶������Ԫ�ؽ�������

��ע��
    1���������ֵ��sortĬ�ϰ��������С����
    2��������ַ�����sortĬ�ϰ�����ĸ����
    3��������Զ�������ͣ���ô����Զ��������Ҫ��Comparable����Comparator�ӿڵ�֧�֡�
*/

import java.util.Arrays;

public class Demo27Arrays {
    public static void main(String[] args) {
        int[] intArray = {40, 30, 20, 5, 8, 75};
        //��int[]���鰴��Ĭ�ϸ�ʽ����ַ���
        String inStr = Arrays.toString(intArray);
        System.out.println(inStr);//[20, 30, 40]

        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        String[] array2 = {"bbb", "aaa", "ccc"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
