package cn.learn.basic.Demo04;
/*
    Set接口，特点不重复元素，没索引

    Set接口的实现类，HashSet（哈希表）
    特点：无序集合，存储和取出的顺序不同，没有索引，不存储重复元素
    代码的编写上和ArrayList完全一致

    HashSet集合的自身特点：
        底层数据结构，哈希表
        存储，取出都比较快
        线程不安全，运行速度快
      哈希的存储过程：
                    将存入对象的哈希值与已存入的所有对象进行比较，
                        若不同，则将此值存入
                        若相同，则用equal进行比较
                            若相同，则不存
                            若不相同，则存在与其哈希值相同的原有链表下边，并记住他的地址
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo06Set {
    public static void main(String[] args) {
        demo01();
        System.out.println("==================");
        demo02();
        System.out.println("==================");
        demo03();
    }

    private static void demo03() {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        set.add("bbc");
        set.add("bbc");
        System.out.println(set);
        //将Person对象中的姓名，年龄相同数据，看作是一个对象
        //判断对象是否重复，依赖对象自己的方法hashCode，equals
        //重写的目标，让对象中属性值name，age如果属性值相同，得到相同的哈希值
        HashSet<Person> people = new HashSet<>();
        people.add(new Person("a", 15));
        people.add(new Person("b", 14));
        people.add(new Person("b", 19));
        people.add(new Person("b", 19));
        people.add(new Person("c", 13));

        System.out.println(people);

    }

    /*
        对象的哈希值，普通的十进制整数
        父类Object，方法public int hashCode() 计算结果int整数
    */
    private static void demo02() {
        /*Person person = new Person();
        int i = person.hashCode();//返回的结果是不定的
        System.out.println(i);*/

        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354
        /*
           哈希值的计算过程：31*原来的计算结果 + 字符ASCII值
            "abc" --> char[] {'a','b','c'}
            h = 31*0 + char[0] = 31*0 + 'a' = 31*0 +97 = 97
            h = 31*97 + char[1] = 31*97 + 'b' = 31*97 +98 = 3105
            h = 31*3105 + char[2] = 31*3105 + 'c' = 31*3105 + 99 = 96354
        */
    }

    private static void demo01() {
        Set<String> set = new HashSet<>();
        set.add("cn");
        set.add("itCast");
        set.add("heima");
        set.add("java");

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
