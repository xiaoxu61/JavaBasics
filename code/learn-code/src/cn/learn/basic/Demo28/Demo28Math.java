package cn.learn.basic.Demo28;
/*
java.util.Math������ѧ��صĹ����࣬�����ṩ�˴����ľ�̬�������������ѧ������صĲ���

public static double abs(double num)����ȡ����ֵ
public static double ceil(double num)������ȡ��
public static double floor(double num)������ȡ��
public static lang round(double num)����������

Math.PI������Ƶ�Բ���ʳ�����double��
*/

public class Demo28Math {
    public static void main(String[] args) {
        //��ȡ����ֵ
        System.out.println(Math.abs(3.14));
        System.out.println(Math.abs(0));
        System.out.println(Math.abs(-2.5));
        System.out.println("=================");

        //����ȡ��
        System.out.println(Math.ceil(3.1));
        System.out.println("==================");

        //����ȡ��
        System.out.println(Math.floor(3.9));
        System.out.println(Math.floor(31.0));
        System.out.println("====================");

        //��������
        System.out.println(Math.round(20.4));
        System.out.println(Math.round(20.5));
    }
}
