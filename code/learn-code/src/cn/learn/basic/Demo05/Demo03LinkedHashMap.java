package cn.learn.basic.Demo05;
/*
    LinkedHashMap继承HashMap
    保证了迭代的顺序
*/

import java.util.LinkedHashMap;

public class Demo03LinkedHashMap {
    public static void main(String[] args) {
        demo01();
    }

    private static void demo01() {
        LinkedHashMap<String, String> link = new LinkedHashMap<>();
        link.put("2", "a");
        link.put("3", "b");
        link.put("4", "c");
        link.put("5", "d");
        System.out.println(link);
    }
}
