package cn.learn.basic.Demo35Red;
/*
����˵����
    �������ȥ֮�������˶��к���������������һ�������Ⱥ���Լ���
��������붼���ֳɵģ�������Ҫ���ľ��������

����ַ����ԣ�
        1����ͨ�����ƽ����:toltalMoney/toltalCount�������������һ���������
        2��������������)������һ��Ǯ����಻����ƽ������2����Ӧ��Խ��Խ��
*/

import java.util.ArrayList;

public class Bootstrap {

    public static void main(String[] args) {
        People one = new People("Ⱥ��",100);
        People two = new People("��Ա1",0);
        People three = new People("��Ա2",0);
        People four = new People("��Ա3",0);

        display(one, two, three, four);
        /*System.out.println("======================");
        ArrayList<Integer> redList = one.divideMoney(1, 20, 4);
        System.out.println(redList);
        one.receiveMoney(redList);
        two.receiveMoney(redList);
        three.receiveMoney(redList);
        four.receiveMoney(redList);
        display(one, two, three, four);
        System.out.println("=========================");*/

        ArrayList<Integer> redRandom = one.divideMoney(2, 20, 4);
        System.out.println(redRandom);
        one.receiveMoney(redRandom);
        two.receiveMoney(redRandom);
        three.receiveMoney(redRandom);
        four.receiveMoney(redRandom);
        display(one, two, three, four);

    }
    public static void display(People one, People two, People three, People four) {
        one.show();
        two.show();
        three.show();
        four.show();
    }
}
