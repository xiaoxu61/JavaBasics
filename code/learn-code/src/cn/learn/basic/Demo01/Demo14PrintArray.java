package cn.learn.basic.Demo01;
/*
  ������̣�����Ҫʵ��һ�����ܵ�ʱ��ÿһ������Ĳ��趼Ҫ������Ϊ����ϸ����ÿһ��ϸ��
  ������󣺵���Ҫʵ��һ�����ܵ�ʱ�򣬲����ľ���Ĳ��裬������һ�����иù��ܵ��ˣ�����������

*/

import java.util.Arrays;

public class Demo14PrintArray {
    public static void main(String[] args) {
        int[] array = {10, 2, 5, 6};

        //Ҫ���ӡ��ʽΪ��[10,2,5,6]
        //ʹ���������
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                System.out.println(array[i] + "]");
            }else {
                System.out.print(array[i] + ", ");
            }
        }
        //ʹ���������
        //��һ��JDK�������ṩ�õ�Arrays��
        //������һ��toString������ֱ�Ӿ��ܰ���������Ҫ�ĸ�ʽ�ַ���
        System.out.println(Arrays.toString(array));

    }
}
