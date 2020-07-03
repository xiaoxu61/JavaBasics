package cn.learn.basic.Demo05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo02HashMap {
    public static void main(String[] args) {
        demo01();
        System.out.println("======================");
        demo02();
    }
    //HashMap存储自定义对象，作为键出现
    //键的对象是Person类型，值是字符串
    //保证键的唯一，存储到键的对象，hashCode  equals
    private static void demo02() {
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("a", 20), "里约热内卢");
        map.put(new Person("b", 21), "索马里海盗");
        map.put(new Person("c", 23), "百慕大海峡");
        for(Person key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "..." + value);
        }
        System.out.println("=====");
        for(Map.Entry<Person, String> entry : map.entrySet()) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "..." + value);
        }
    }

    //HashMap 存储自定义的对象Person，作为值出现
    private static void demo01() {
        HashMap<String, Person> map = new HashMap<>();
        map.put("Beijing", new Person("a", 20));
        map.put("Tianjing", new Person("b", 18));
        map.put("ShangHai", new Person("c", 22));

        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Person value = map.get(key);
            System.out.println(key + "..." + value);
        }
        System.out.println("===");
        for(Map.Entry<String, Person> entry : map.entrySet()) {
            String key = entry.getKey();
            Person person = entry.getValue();
            System.out.println(key + "...." + person);
        }
    }
}
