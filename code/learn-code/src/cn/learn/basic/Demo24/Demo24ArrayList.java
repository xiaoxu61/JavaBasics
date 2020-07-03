package cn.learn.basic.Demo24;
/*
数组长度不可以发生改变
但是ArrayList集合长度是可以随意变化的

对ArrayList来说，有一个尖括号<E>代表泛指类型
泛型：装在集合中的所有元素，全部都是统一的类型
注意：泛型只是引用类型，不能是基本类型
      对于ArrayList来说，直接打印得到的不是地址值，而是内容
      如果内容是空，得到的是空的中括号[]

ArrayList当中的常用方法：
    public boolean add <E e>：向集合当中添加元素，参数的类型和泛型一致
    public E get(int index)：从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素
    public int size()：获取集合的尺寸长度，返回值是集合中的元素个数
    public E remove(int index)：从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素
*/

import java.util.ArrayList;

public class Demo24ArrayList {
    public static void main(String[] args) {
        //创建了一个ArrayList集合名称是list，里面装的全部是String字符串类型的数据
        //备注：从JDK 1.7+开始，右侧尖括号内可以不写内容，但是尖括号本身还是要写的
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        //向集合中添加一些数据，需要用到add方法
        list.add("古力穷哈");
        list.add("古力穷哈哈");
        list.add("古力穷哈哈哈");
        System.out.println(list);

        boolean success = list.add("马尔扎哈");
        System.out.println(list);
        System.out.println("添加是否成功：" + success);

        //从集合中获取元素：get 索引值从0开始
        String name = list.get(2);
        System.out.println("第二号索引位置：" + name);

        //从集合中删除元素：remove 索引值从0开始
        String whoRemove = list.remove(3);
        System.out.println("被删除的是：" + whoRemove);
        System.out.println(list);

        //获取集合的长度尺寸，也就是集合的个数
        int size = list.size();
        System.out.println("集合中有多少个元素:" + size);
        System.out.println("============================");
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
