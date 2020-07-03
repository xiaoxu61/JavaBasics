package cn.learn.basic.Demo04;
/*
    Collection�ӿ��еķ���������������ʵ�������ӵ�еķ���
    ������ִ�ж���ʵ�ֵ���д
        add(E e) ��ȷ���� collection ����ָ����Ԫ�أ���ѡ������������ֵ
        clear() �Ƴ��� collection �е�����Ԫ�أ���ѡ��������
    ѧϰJava�����ֳ��ȱ�����ʽ
            1������.length ���� ����ֵ int
            2���ַ���.length() ������ ����ֵ int
            3������.size() ����������ֵ int
*/

import java.util.ArrayList;
import java.util.Collection;

public class Demo01Collection {
    public static void main(String[] args) {
        demo01();
        demo02();
        System.out.println("=============");
        demo03();
        System.out.println("=============");
        demo04();
        System.out.println("============");
    }
    /*
        boolean remove(Object o)�Ƴ�������ָ����Ԫ��,�����ĵ�һ��
    */
    private static void demo04() {
        Collection<String> coll = new ArrayList<>();
        coll.add("acc");
        coll.add("acd");
        coll.add("ace");
        coll.add("acf");
        coll.add("acg");
        coll.add("123");
        System.out.println(coll);
        boolean acc = coll.remove("acc");
        System.out.println(acc);
        System.out.println(coll);
    }

    /*
        Object[] toArray() �����е�Ԫ�أ�ת��һ�������е�Ԫ�أ�����ת������
            ������һ���洢��������飬����洢��������Object
    */
    private static void demo03() {
        Collection<String> coll = new ArrayList<>();
        coll.add("acc");
        coll.add("acd");
        coll.add("ace");
        coll.add("acf");
        coll.add("acg");
        coll.add("123");

        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

    /*
        boolean contain(Object o)�ж϶����Ƿ�����ڼ����У�������ڷ���true
    */
    private static void demo02() {
        Collection<String> coll = new ArrayList<>();
        coll.add("acc");
        coll.add("acd");
        coll.add("ace");
        coll.add("acf");
        coll.add("acg");
        coll.add("123");
        System.out.println(coll);
        boolean ac = coll.contains("acf");
        System.out.println(ac);
        boolean contains = coll.contains(123);//���Ͳ�ͬҲ��false
        System.out.println(contains);
    }

    /*
        Collection�ӿڵķ���
        void clear() ��ռǺŸ��е�����Ԫ�أ�������Ȼ����
    */
    private static void demo01() {
        //�ӿڶ�̬�ķ�������
        Collection<String> coll = new ArrayList<String>();
        coll.add("acc");
        coll.add("bcd");
        System.out.println(coll);

        coll.clear();
        System.out.println("clear�Ժ�" + coll);
    }
}
