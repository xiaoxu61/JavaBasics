package cn.learn.basic.Demo04;
/*
    Collection接口中的方法，集合中所有实现类必须拥有的方法
    方法的执行都是实现的重写
        add(E e) ：确保此 collection 包含指定的元素（可选操作）。返回值
        clear() 移除此 collection 中的所有元素（可选操作）。
    学习Java中三种长度表现形式
            1、数组.length 属性 返回值 int
            2、字符串.length() 方法， 返回值 int
            3、集合.size() 方法，返回值 int
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
        boolean remove(Object o)移除集合中指定的元素,遇到的第一个
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
        Object[] toArray() 集合中的元素，转成一个数组中的元素，集合转成数组
            返回是一个存储对象的数组，数组存储的数据是Object
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
        boolean contain(Object o)判断对象是否存在于集合中，对象存在返回true
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
        boolean contains = coll.contains(123);//类型不同也是false
        System.out.println(contains);
    }

    /*
        Collection接口的方法
        void clear() 清空记号个中的所有元素，集合仍然存在
    */
    private static void demo01() {
        //接口多态的方法调用
        Collection<String> coll = new ArrayList<String>();
        coll.add("acc");
        coll.add("bcd");
        System.out.println(coll);

        coll.clear();
        System.out.println("clear以后：" + coll);
    }
}
