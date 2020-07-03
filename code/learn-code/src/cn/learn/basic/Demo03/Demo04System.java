package cn.learn.basic.Demo03;
/*
java.lang.System 类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：
    public static long currentTimeMills()：返回毫秒为单位的当前时间
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, ing length)：将数组中指定的数据拷贝到另一个数组中
*/

import java.sql.SQLOutput;
import java.util.Arrays;

public class Demo04System {
    public static void main(String[] args) {
        //获取当前操作系统属性
        System.out.println(System.getProperties());
        demo01();
        System.out.println("================");
        demo02();
        System.out.println("============");
        demo04();
        System.out.println("============");
        demo03();
    }
    /*
        JVM在内存中，收取对象的垃圾
        static void gc()
    */
    private static void demo04() {
        new Person();
        System.gc();
    }

    /*
        退出虚拟机，所有程序停止
        static void exit(0)
    */
    private static void demo03() {
        while (true) {
            System.out.println("Hello");
            System.exit(0);
        }
    }

    /*
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, ing length)：将数组中指定的数据拷贝到另一个数组中
    参数：
        src - 源数组。要复制的数组
        srcPos - 源数组中的起始位置(起始索引)。
        dest - 目标数组。
        destPos - 目标数据中的起始位置。
        length - 要复制的数组元素的数量。
    练习：
        将src数组中前3个元素，复制到dest数组的前三个位置上，
        复制元素前：src数组元素[1, 2, 3, 4, 5],dest数组[6, 7, 8, 9, 10]
        复制元素后：src数组元素[1, 2, 3, 4, 5],dest数组[1, 2, 3, 9, 10]
    */
    private static void demo02() {
        //定义原数组
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};
        System.out.println("复制前" + Arrays.toString(dest));
        //使用System类中的arraycopy把源数组的前3个元素复制到目标数组的前3个位置上
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println("复制后" + Arrays.toString(dest));

    }

    /*
    public static long currentTimeMills()：返回毫秒为单位的当前时间
    用来验证程序的效率
    验证for循环打印数字1~9999所需要使用的时间
    */
    private static void demo01() {
        //程序执行前，获取一次毫秒值
        long s = System.currentTimeMillis();
        for (int i = 0; i < 99; i++) {
            System.out.println(i);
        }
        long e = System.currentTimeMillis();
        System.out.println("程序共耗时：" + (e - s) + "毫秒");
    }
}
