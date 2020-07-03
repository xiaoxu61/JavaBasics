package cn.learn.basic.Demo03;
/*
自动拆箱与自动装箱：基本类型的数据和包装类之间可以自动的相互转换
自动装箱：基本数据类型，直接变成对象
自动拆箱：对象中的数据类型便会基本数据类型
JDK1.5之后出现的新特性
*/

import java.util.ArrayList;

public class Demo06Integer1 {
    public static void main(String[] args) {
        //自动装箱：直接把int 类型的整数赋值包装类
        //Integer in = 1; 就相当于 Integer in = new Integer(1);
        Integer in = 1;

        //自动拆箱:in是包装类，无法直接参与运算，可以自动转换为基本数据类型，再进行计算
        //in + 2 就相当于 in.intValue() + 2 = 3
        //in = in.intValue() + 2 = 3
        in = in + 2;

        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList集合无法直接存储整数，可以存储Integer包装类
        list.add(1);//自动装箱list.add(new Integer(1));
        int a = list.get(0);
        System.out.println("=============");

        Integer a0 = new Integer(5);
        Integer b0 = new Integer(5);
        System.out.println(a0 == b0);
        System.out.println(a0.equals(b0));
        System.out.println("===================");

        Integer a1 = 500;
        Integer b1 = 500;
        System.out.println(a1 == b1);//false
        System.out.println(a1.equals(b1));//true
        System.out.println("=================");
        //当数据在byte范围内时，JVM不会new对象
        Integer aa = 50;
        Integer bb = 50;
        System.out.println(aa == bb);//true
        System.out.println(aa.equals(bb));//true

    }
}
