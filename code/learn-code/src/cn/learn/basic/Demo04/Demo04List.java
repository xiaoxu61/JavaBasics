package cn.learn.basic.Demo04;
/*
 List接口派系，继承Collection接口
    有许多实现类
    List接口特点：有序，索引，可以重复元素
        实现类，ArrayList，LinkedList
    接口中的抽象方法，有一部分方法和父类方法Collection一样
    主要关注List的特有方法，带有索引的功能

*/

import java.util.ArrayList;
import java.util.List;

public class Demo04List {
    public static void main(String[] args) {
        demo01();
        System.out.println("===========");
        demo02();
        System.out.println("===========");
        demo03();
    }
    /*
        E set(int index, E)
        修改指定索引上的元素
        返回被修改之前的元素
    */
    private static void demo03() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Integer set = list.set(3, 5);
        System.out.println(list);
        System.out.println(set);

    }

    /*
        E remove(int index)
        移除指定索引上的元素,并返回删除前的元素
    */
    private static void demo02() {
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        String remove = list.remove(0);
        System.out.println(list);
        System.out.println(remove);
    }

    /*
        add(int index, E)
        将元素插入到列表的索引上
        带有索引的操作，要注意防止越界问题
        java.lang.IndexOutOfBoundsException
    */
    private static void demo01() {
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        System.out.println(list);

        list.add(2, "itCast");
        System.out.println(list);
    }
}
