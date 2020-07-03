package cn.learn.basic.Demo06;
/*
集合操作的工具类
    Collections
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo03Collections {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }
    /*
        Collections.shuffle方法
        对List集合中的元素，进行随机排列
    */
    private static void demo03() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }

    /*
        Collections.binarySearch静态方法
        对List集合进行二分搜索，方法参数，传递List集合，传递被查找的元素
        找不到返回 -插入点-1
    */
    private static void demo02() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);

        int index = Collections.binarySearch(list, 5);
        System.out.println(index);
    }

    /*
        Collections.sort 静态方法
        对于List集合进行升序排列
    */
    private static void demo01() {
        //创建List集合
        List<String> list = new ArrayList<String>();
        list.add("ewdf");
        list.add("dqwbg");
        list.add("bc");
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }
}
