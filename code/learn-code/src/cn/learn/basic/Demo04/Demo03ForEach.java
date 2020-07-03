package cn.learn.basic.Demo04;
/*
JDK 1.5之后的新特性，增强for训话
    出现新的接口java.lang.Iterable   实现这个接口允许对象成为"foreach"语句的目标
    Collection开始继承Iterable
    Iterable作用，实现增强for循环

    格式：
        for(数据类型 变量名 : 数组或者集合) {
            sop(变量)
        }

    好处：代码量少，方便遍历
    弊端：没有索引，不能操作容器内的元素
*/

public class Demo03ForEach {
    public static void main(String[] args) {
        demo01();
        System.out.println("==========");
        demo02();
        System.out.println("===========");
        demo03();
    }
    /*
        增强for循环遍历集合
        存储自定义Person类型
    */
    private static void demo03() {
    }

    private static void demo02() {
        //for对于对象数组遍历的时候，能否调用对象的方法呢
        String[] arr = {"acb","gds","sdv"};
        for (String s : arr) {
            System.out.print(s);
            System.out.println(s.length());
        }
    }

    /*
        实现for循环，遍历数组
        好处：代码量少，方便遍历
        弊端：没有索引，不能操作容器内的元素
    */
    private static void demo01() {
        int[] arr = {3,1,5,6,8,1,7,9};
        for (int i : arr) {
            System.out.println(i+1);
        }
        System.out.println(arr[0]);
    }
}
