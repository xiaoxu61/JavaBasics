package cn.learn.basic.Demo03;
/*
�Զ��������Զ�װ�䣺�������͵����ݺͰ�װ��֮������Զ����໥ת��
�Զ�װ�䣺�����������ͣ�ֱ�ӱ�ɶ���
�Զ����䣺�����е��������ͱ�������������
JDK1.5֮����ֵ�������
*/

import java.util.ArrayList;

public class Demo06Integer1 {
    public static void main(String[] args) {
        //�Զ�װ�䣺ֱ�Ӱ�int ���͵�������ֵ��װ��
        //Integer in = 1; ���൱�� Integer in = new Integer(1);
        Integer in = 1;

        //�Զ�����:in�ǰ�װ�࣬�޷�ֱ�Ӳ������㣬�����Զ�ת��Ϊ�����������ͣ��ٽ��м���
        //in + 2 ���൱�� in.intValue() + 2 = 3
        //in = in.intValue() + 2 = 3
        in = in + 2;

        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList�����޷�ֱ�Ӵ洢���������Դ洢Integer��װ��
        list.add(1);//�Զ�װ��list.add(new Integer(1));
        int a = list.get(0);
        System.out.println("=============");

        Integer a0 = new Integer(5);
        Integer b0 = new Integer(5);
        System.out.println(a0 == b0);
        System.out.println(a0.equals(b0));
        System.out.println("===================");

        Integer a1 = 500;
        Integer b1 = 500;
        System.out.println(a1 == b1);//false
        System.out.println(a1.equals(b1));//true
        System.out.println("=================");
        //��������byte��Χ��ʱ��JVM����new����
        Integer aa = 50;
        Integer bb = 50;
        System.out.println(aa == bb);//true
        System.out.println(aa.equals(bb));//true

    }
}
