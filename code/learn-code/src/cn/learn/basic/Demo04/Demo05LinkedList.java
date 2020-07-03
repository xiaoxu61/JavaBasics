package cn.learn.basic.Demo04;
/*
    LinkedList 链表集合的特有功能
    自身特点：链表底层实现，查询慢，增删快

        子类特有功能：不能多态调用
*/

import java.util.LinkedList;

public class Demo05LinkedList {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }
    /*
        E removeFirst() 移除并返回链表的开头
        E removeLast() 移除返回链表的结尾
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
        E   getFirst() 获取链表的开头
        E   getLast() 获取链表的结尾
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
        addFirst(E) 添加到链表的开头
        addLast(E) 添加到链表的结尾
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
