package cn.learn.basic.Demo24;
/*
����һ�����飬�����洢3��Person����

������һ��ȱ�㣬һ�������������������䳤�Ȳ����Է����ı�

*/

public class Demo24Array {
    public static void main(String[] args) {
        //���ȴ���һ�����飬����Ϊ3�������������person����
        Demo24Person[] array = new Demo24Person[3];

        Demo24Person one = new Demo24Person("�����Ȱ�",18);
        Demo24Person two = new Demo24Person("�������",20);
        Demo24Person three = new Demo24Person("�������",1800);

        array[0] = one;
        array[1] = two;
        array[2] = three;
        System.out.println(array[0]);//��ֵַ
        System.out.println(array[1]);//��ֵַ
        System.out.println(array[2]);//��ֵַ

        System.out.println(array[1].getName());
    }
}
