package cn.learn.basic.Demo02Equal;

import java.util.ArrayList;

public class Demo01Equal {
    public static void main(String[] args) {
        /*
        person��Ĭ�ϼ̳���Object�࣬���Կ�����Object���equal����
        boolean equal(Object obj)ָʾ����ĳ�������Ƿ�������
        eaqual����Դ���룺
            public boolean equal(Object obj) {
                return (this == obj)
            }
            this��˭���ĸ�������õķ����������е�this�����Ǹ�����
            obj��˭�����ݹ����Ĳ���
        ������
            Object obj�����Դ����������
            == �Ƚ�����������ص���һ������ֵ
            �����������ͣ��Ƚϵ���ֵ
            �����������ͣ��Ƚϵ�����������ĵ�ֵַ
        */
        Person one = new Person("�����Ȱ�", 19);
        Person two = new Person("�����Ȱ�", 19);
        Person three = new Person("��������", 20);
        System.out.println("one" + one);
        System.out.println("two" + two);
        boolean equals = one.equals(two);
        System.out.println(equals);

        ArrayList<String> list = new ArrayList<>();

        boolean b = one.equals(list);
        System.out.println(b);

        System.out.println(one.equals(one));

    }
}
