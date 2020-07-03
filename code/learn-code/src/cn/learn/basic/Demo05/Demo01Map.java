package cn.learn.basic.Demo05;
/*
    Map接口的常用方法
        使用Map接口的实现类HashMap
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo01Map {
    public static void main(String[] args) {
        demo01();
        System.out.println("===========");
        demo02();
        System.out.println("===========");
        demo03();
        System.out.println("===========");
        demo04();
    }
    /*
        Map集合获取方式
        entrySet方法，键值对映射关系获取
        实现步骤：
                1、调用map集合方法entrySet()将集合中的映射关系对象，存储到Set集合
                    Set<Entry <K, V> >
                2、迭代Set集合
                3、获取出的Set集合的元素，是映射关系对象
                4、通过映射关系对象方法getKey，getValue获取键值对
         创建内部类对象  外部类.内部类 = new ...
    */
    private static void demo04() {
        Map<Integer, String> map = new HashMap<>();
        map.put(11, "a");
        map.put(22, "b");
        map.put(33, "c");

        //1
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //2
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        while (it.hasNext()) {
            //3
            Map.Entry<Integer, String> entry = it.next();
            //4
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "..." + value);
        }
        System.out.println("==============");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "..." + entry.getValue());
        }
    }

    /*
        Map集合的遍历
            利用键，获取值
            Map接口中定义方法keySet，所有的键，存储到Set集合

    */
    private static void demo03() {
        //1、调用map集合的方法keySet，所有的键存储到Set集合中
        //2、遍历Set集合，获取出Set集合中的所有元素（Map中的键）
        //3、调用map集合方法get，通过键获取到值
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 11);
        map.put("b", 22);
        map.put("c", 33);
        map.put("d", 44);

        Set<String> set = map.keySet();

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            Integer value = map.get(key);
            System.out.println(key+ "...." + value);
        }
        for (String s : map.keySet()) {
            Integer v = map.get(s);
            System.out.println(s + "..." + v);
        }
    }

    /*
        通过键对象，获取值对象
        V get(K)
        如果集合中没有这个键，返回null
    */
    private static void demo02() {
        //创建集合对象，作为键的对象整数，值的对象存储字符串
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        System.out.println(map);
        //移除集合中的键值对，返回被移除之前的值
        // V remove(K)
        String value1 = map.remove(4);
        System.out.println(value1);
        System.out.println(map);

        String value = map.get(5);
        System.out.println(value);
    }

    /*
        将键值对存储到集合中
        V put(k, V) K作为键的对象，V作为值的对象
        存储的重复的键，将原有的值，覆盖
        返回值：一般情况下返回null，当存储重复键的时候，返回被覆盖之前的值
    */
    private static void demo01() {
        //创建集合对象，HashMap，存储对象，键是字符串，值是整数
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        Integer i = map.put("a", 2);
        map.put("c", 3);
        map.put("c", 5);
        System.out.println(map);
        System.out.println(i);
    }
}
