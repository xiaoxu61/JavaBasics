package cn.learn.basic.Demo27;
/*
��Ŀ��
    ��ʹ��Arrays��ص�API����һ������ַ����е������ַ��������У��������ӡ
*/

import java.util.Arrays;

public class Demo27ArraysPractise {
    public static void main(String[] args) {
        String str = "ssdv67ui3hfh2f87374fb478gf83v";

        //��ν����������У�sort
        //������һ�����飬����ʹ��Arrays.sort����
        //String --> ���飬��tocharArray
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        //��Ҫ�������
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
