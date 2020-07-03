package cn.learn.basic.Demo25;
/*
��Ŀ��
����һ��������������{1��2��3}����ָ����ʽƴ�ӳ�һ���ַ�������ʽ�������£�[World1#World2#World3]

������
1������׼��һ��int[] ���飬������1��2��3
2������һ���������������������ַ���
��Ҫ�أ�
�������ͣ�String
�������ƣ�fromArrayToString
�����б�int[]
3����ʽ[World1#World2#World3]
�õ�forѭ�����ַ���ƴ�ӡ�ÿ��Ԫ�ض���һ��World�������ָ�ʹ�õ���#������һ���ǲ������һ��
4�����÷������õ�����ֵ������ӡ���

��Ŀ��
��������һ���ַ���������ͳ�����и����ַ����ֵĴ���
�����У���д��ĸ��Сд��ĸ�����֡�����

˼·��
1���������룬Scanner
2�����������ַ��� String str = sc.next()��
3�������ĸ��������ֱ���������ַ����Գ��ֵĴ���
4����Ҫ���ַ���һ���֡�һ���ּ�飬String --> char[], ��������toCharArray()
5������char[] �ַ����飬�Ե�ǰ�ַ�����������жϣ��������ĸ���������++����
6����ӡ����ĸ��������ֱ���������ַ����ִ���
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

        int countUpper = 0;//��д�ַ�
        int countLower = 0;//Сд�ַ�
        int countNumber = 0;//����
        int countOther = 0;//�����ַ�

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if ('A' <= ch && ch <= 'Z'){   //char�����ڷ�����ѧ����ʱ�����Զ�ת��Ϊint����
                countUpper++;
            }else if ('a' <= ch && ch <= 'z'){
                countLower++;
            }else if ('0' <= ch && ch <= '9'){
                countNumber++;
            }else{
                countOther++;
            }
        }
        System.out.println("��д��ĸ�У�" + countUpper);
        System.out.println("Сд��ĸ�У�" + countLower);
        System.out.println("�����У�" + countNumber);
        System.out.println("�����ַ��У�" + countOther);
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
