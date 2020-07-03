package cn.learn.basic.Demo04;
/*
    LinkedList �����ϵ����й���
    �����ص㣺����ײ�ʵ�֣���ѯ������ɾ��

        �������й��ܣ����ܶ�̬����
*/

import java.util.LinkedList;

public class Demo05LinkedList {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }
    /*
        E removeFirst() �Ƴ�����������Ŀ�ͷ
        E removeLast() �Ƴ���������Ľ�β
    */
    private static void demo03() {
        LinkedList<String> link = new LinkedList<>();
        link.add("1");
        link.add("2");
        link.add("3");
        link.add("4");
        System.out.println(link);

        String first = link.removeFirst();
        String last = link.removeLast();
        System.out.println(first + " " +last);
    }

    /*
        E   getFirst() ��ȡ����Ŀ�ͷ
        E   getLast() ��ȡ����Ľ�β
    */
    private static void demo02() {
        LinkedList<String> link = new LinkedList<>();
        link.add("1");
        link.add("2");
        link.add("3");
        link.add("4");
        System.out.println(link);
        if (!link.isEmpty()) {
            String first = link.getFirst();
            String last = link.getLast();
            System.out.println(first);
            System.out.println(last);
        }
    }

    /*
        addFirst(E) ��ӵ�����Ŀ�ͷ
        addLast(E) ��ӵ�����Ľ�β
    */
    private static void demo01() {
        LinkedList<String> link = new LinkedList<>();
        link.add("abc");
        link.add("bcd");
        System.out.println(link);

        link.addFirst("ABC");
        System.out.println(link);
        link.addLast("BCD");
        System.out.println(link);
        System.out.println("===================");
        LinkedList<String> link1 = new LinkedList<>();
        link1.addLast("a");
        link1.addLast("b");
        link1.addLast("c");
        link1.addLast("d");
        System.out.println(link1);
        link1.addFirst("1");
        link1.addFirst("2");
        link1.addFirst("3");
        link1.addFirst("4");
        System.out.println(link1);
    }
}
