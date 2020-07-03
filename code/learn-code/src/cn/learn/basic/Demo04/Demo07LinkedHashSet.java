package cn.learn.basic.Demo04;
/*
    LinkedHashSet 基于链表的哈希表实现
    继承自HashSet

    LinkedHashSet 自身特性，具有顺序，存储和取出的顺序相同
    线程不安全的集合，运行速度快
*/

import java.util.LinkedHashSet;

public class Demo07LinkedHashSet {
    public static void main(String[] args) {
        demo01();
    }

    private static void demo01() {
        LinkedHashSet<Integer> link = new LinkedHashSet<>();
        link.add(12);
        link.add(13);
        link.add(14);
        link.add(15);
        System.out.println(link);
    }
}
