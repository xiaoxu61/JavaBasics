package cn.learn.basic.Demo24;
/*
��һ���󼯺ϴ���20��������֣�Ȼ��ɸѡ���е�ż��Ԫ�أ��ŵ�С������
Ҫ��ʹ���Զ���ķ�����ʵ��ɸѡ

������
    1����Ҫ����һ���󼯺ϣ������洢int���֣�<Integer>
    2��������־���Random nextInt
    3��ѭ��20�Σ���������ַ���󼯺ϣ�forѭ����add�ķ���
    4������һ������������ɸѡ
    ɸѡ�����ݴ󼯺ϣ�ɸѡ����Ҫ���Ԫ�أ��õ�С����
    ��Ҫ�أ�
         ����ֵ���ͣ�ArrayListС���ϣ��ڲ�����������ȷ����
         �������ƣ�getSmallList
         �����б꣺ArrayList�󼯺ϣ�װ��20���������
     5���ж�if��ż����num % 2 == 0
     6�������ż�����ŵ�С���ϣ����򲻷�
*/


import java.util.ArrayList;
import java.util.Random;

public class Demo24ArrayListReturn {
    public static void main(String[] args) {
        ArrayList<Integer> BbigList = bigList(5);
        System.out.println(BbigList);
        System.out.println("С���ϵĸ���Ϊ��" + getSmallList(BbigList).size());
        System.out.println(getSmallList(BbigList));
    }

    public static ArrayList<Integer> getSmallList(ArrayList<Integer> list){
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num % 2 == 0){
                smallList.add(num);
            }
        }
        return smallList;
    }

    public static ArrayList<Integer> bigList(int howLong){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < howLong; i++) {
            int temp = new Random().nextInt(50);
            list.add(temp);
        }
        return list;
    }
}
