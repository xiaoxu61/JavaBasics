package cn.learn.basic.Demo05;
/*
    LinkedHashMap�̳�HashMap
    ��֤�˵�����˳��
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
