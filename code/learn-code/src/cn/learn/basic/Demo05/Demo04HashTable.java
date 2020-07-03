package cn.learn.basic.Demo05;
/*
Map接口实现类Hashtable
底层数据结果哈希表，特点和HashMap是一样的
Hashtable 线程安全集合，运行速度慢
HashMap线程不安全集合，运行速度快

Hashtable命运和Vector是一样的，从JDK 1.2开始，被先进的HashMap取代
但是他的子类Properties依然活跃在开发舞台

HashMap允许存储null值，null键
而Hashtable不允许(编译时没事，运行时会抛出空指针异常NullPointerException)

*/

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Demo04HashTable {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        Map<String, String> table = new Hashtable<>();
//        table.put(null, null);//
    }
}
