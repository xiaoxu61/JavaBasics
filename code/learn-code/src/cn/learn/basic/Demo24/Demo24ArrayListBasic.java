package cn.learn.basic.Demo24;
/*
ϣ���򼯺���ArrayList���д洢�������ͣ�����ʹ�û������Ͷ�Ӧ�ġ���װ�ࡱ

�������� ��װ�ࣨ�������ͣ���װ�඼λ��java.lang���£�

byte     Byte
short    Short
int      Integer     �����⡿
long     Long
float    Float
double   Double
char     Character   �����⡿
boolean  Boolean

��JDK 1.5+ ��ʼ��֧���Զ�װ�䣬�Զ�����
�Զ�װ�䣺�������� --> ��װ����
�Զ����䣺��װ���� --> ��������
*/

import java.util.ArrayList;

public class Demo24ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();

        //ArrayList<int> = listB = new ArrayList<>();//����д��
        ArrayList<Integer> listC = new ArrayList<>();
        listC.add(100);
        listC.add(125);
        listC.add(0, 15);
        System.out.println(listC);


        int num = listC.get(0);
        System.out.println("listC�еĵ�һ��Ԫ���ǣ�" + num);

    }
}
