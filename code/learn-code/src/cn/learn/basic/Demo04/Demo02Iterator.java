package cn.learn.basic.Demo04;
/*
    集合中的迭代器：
        获取集合中元素的一种方式
        接口中有两个抽象方法：
            boolean hasNext() 判断集合中还有没有可以被取出来的元素，如果有返回true
            next() 取出集合中的下一个元素

        Iterator接口，找实现类
        Collection接口定义方法
            Iterator iterator()
        ArrayList重写方法iterator,返回了Iterator接口的实现类的对象
        it是接口的实现类对象，调用方法hasNext和next集合元素迭代
JDK 1.5 出现新的安全机制，保证程序的安全性
    泛型：指明了集合中存储数据的类型<数据类型>
*/

import java.util.*;

public class Demo02Iterator {
    public static void main(String[] args) {
        demo01();
        System.out.println("===========");
        demo02();
        System.out.println("===========");
        ArrayList<String> arr = new ArrayList<>();
        arr.add("123");
        arr.add("456");
        HashSet<Integer> set = new HashSet<>();
        set.add(567);
        set.add(789);
        iteractor(arr);
        iteractor(set);
        System.out.println("==============");
        demo03();
    }
    /*
        迭代器的并发修改异常
        java.util.ConcurrentModificationException
        在遍历过程中，使用了集合的方法修改了集合的【长度】，这是不允许的
    */
    private static void demo03() {
        List<String> list = new ArrayList<>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        //对集合使用迭代器进行获取，获取时候判断集合中是否存在 "abc3" 对象
        //如果有，添加一个元素"ABC3"
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            //对获取出的元素进行判断
            if (s.equals("abc3")) {
                list.add("ABC3");
            }
            System.out.println(s);
        }
    }

    /*
        定义方法，可以同时迭代两个集合
        参数：怎么实现，既不能写ArrayList，也不能写HashSet
        参数：共同实现的接口
        泛型的通配：匹配所有的数据类型 ?
        通配符仅适用于遍历，迭代器it。next()方法取出来的是Object类型，可以用 <? extends 限定的固定数据类型>
        限定的固定数据类型可以有许多子类，其子类可以穿进去，但是其他的不可传进去

        ? extends 父类     限制的是父类，上线限定，可以传递他的子类对象
        ? super 父类       限制的是子类，下线限定，可以传递他的父类对象
    */
    private static void iteractor(Collection<?> coll) {
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void demo02() {
        //集合中可以存储任意类型对象
        //集合中，不指定存储的类型数据，集合什么都存
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("123ggd");

        //迭代获取
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            //iterator.next()获取出来的是什么类，Object类
//            Object obj = iterator.next();
//            System.out.println(obj);
            //当需要使用子类对象特有方法时，需要向下转型
            String s = (String)iterator.next();
            System.out.println(s.length());
        }
    }

    private static void demo01() {
        Collection<String> coll = new ArrayList<>();
        coll.add("AB1");
        coll.add("AB2");
        coll.add("AB3");
        coll.add("AB4");
        coll.add("AB5");
        //迭代其，对集合ArrayList中的元素进行取出

        //调用集合方法，iterator() 获取出，Iterator接口的实现类的对象
        Iterator<String> it = coll.iterator();
        //接口实现类对象，调用方法hasNext()判断集合中是否有元素
        boolean b = it.hasNext();
        System.out.println(b);
        //接口的实现类对象，调用方法next取出集合中的元素
//        String next = it.next();
//        System.out.println(next);

        //迭代是反复内容，使用循环实现，循环的条件，集合中没有元素，hasNext()返回了false
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);

        }
    }
}
