package cn.learn.basic.Demo01;
/*
��������ı�׼��ʽ��
������ ������ = new ������();

�����������ֻ���ұߵĶ���û����ߵ����ָ���ֵ�����
new ������()

ע�������������ֻ��ʹ��Ψһ��һ�Σ��´δ������ò��ٴ���һ���¶���
ʹ�ý��飬���ȷ����һ������ֻ��Ҫʹ��Ψһ��һ�Σ�����ʹ����������

*/

import java.util.Scanner;

public class Demo21Anonymous {
    public static void main(String[] args) {
        //��ߵ�one���Ƕ��������
        Demo21Person one = new Demo21Person();
        one.name = "��Բ";
        one.showname();

        //��������
        new Demo21Person().name = "�ͱ�";
        new Demo21Person().showname();
        //���̵�ʹ��
        //��ͨʹ��
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println("��ͨʹ�����������" + num);
        //����ʹ��
        int num1 = new Scanner(System.in).nextInt();
        System.out.println("������������Ϊ" + num1);
        System.out.println("==========================");
        //ʹ����������������
        //methodParam(new Scanner(System.in));
        //ʹ���������󷵻ز���
        Scanner sc = methodReturn();
        int num = sc.nextInt();
        System.out.println("������ǣ�" + num);

    }
    public static void methodParam(Scanner sc){
        System.out.println("����һ������");
        int num = sc.nextInt();
        System.out.println("�������" + num);
    }

    public static Scanner methodReturn(){
        return new Scanner(System.in);
    }

}
