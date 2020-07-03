package cn.learn.basic.Demo03;
/*
对于超大整数运算
    超过long取值范围整数，封装成BigInteger类型对象
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Demo09BigInteger {
    public static void main(String[] args) {
        function_1();
        System.out.println("===============");
        function_2();

    }

    private static void function_2() {
        /*
            计算结果，未知
            原因：
                计算机二进制中，表示浮点数不精确造成
            超级大型的浮点数据，提供高精度的浮点运算，BigDecimal,其三则运算与整数相同
        */
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        BigDecimal b1 = new BigDecimal("0.09");
        BigDecimal b2 = new BigDecimal("0.01");
        //加法
        BigDecimal add = b1.add(b2);
        System.out.println(add);

         b1 = new BigDecimal("1");
         b2 = new BigDecimal("0.32");
        //减法
        BigDecimal subtract = b1.subtract(b2);
        System.out.println(subtract);

        b1 = new BigDecimal("1.015");
        b2 = new BigDecimal("100");
        //乘法
        BigDecimal multiply = b1.multiply(b2);
        System.out.println(multiply);

        b1 = new BigDecimal("1.301");
        b2 = new BigDecimal("100");
        //除法
        //有除不尽的情况发生，则需要选择保留小数位
        //如：devide(BigDecimal divisor, int scale, int roundingMode)
        //int scale：保留几位小数
        //int roundingMode：保留模式 参阅API文档
        //int roundingMode：保留模式 参阅API文档
        //static int ROUND_UP 向上+1
        //static int ROUND_HALF_UP >=0.5 向上+1
        //static int ROUND_HALF_DOWN >0.5 向上+1，否则直接舍去
        BigDecimal divide = b1.divide(b2, 2, BigDecimal.ROUND_UP);
        System.out.println(divide);
    }

    /*
        BigInteger类的构造方法
        传递字符串，要求数字格式，没有长度限制
    */
    private static void function_1() {
        BigInteger b = new BigInteger("1564848946135861613216681215868413");
        BigInteger c = new BigInteger("1564848946135861613216681215868413");

        System.out.println(b);
        System.out.println(c);
        //BigInteger的四则运算
        //调用方法计算，计算结果也只能是BigInteger对象

        //加法
        BigInteger add = b.add(c);
        System.out.println(add);
        //减法
        BigInteger subtract = b.subtract(c);
        System.out.println(subtract);
        //乘法
        BigInteger multiply = b.multiply(c);
        System.out.println(multiply);
        //除法
        BigInteger divide = b.divide(c);
        System.out.println(divide);
    }
}
