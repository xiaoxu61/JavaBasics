package cn.learn.basic.Demo01;
/*
 题目要求：
    比较两个数据是否相等
    参数类型分别为两个byte，两个long，两个int，两个short类型
    并在main方法中进行测试

*/

public class Demo07MethodOverloadSame {
    public static void main(String[] args) {

        System.out.println(isSame((short)10,(short)50));
        System.out.println(isSame(10,20));
        System.out.println(isSame((long)2, (long)5));
    }
    public static boolean isSame(byte a, byte b){
        System.out.println("两个byte参数的方法执行");
        boolean same;
        if(a == b){
            same = true;
        }else{
            same = false;
        }
        return same;
    }

    public static boolean isSame(short a, short b){
        System.out.println("两个short参数的方法执行");
        boolean same = a == b ? true:false;
        return same;
    }

    public static boolean isSame(int a, int b){
        System.out.println("两个int参数的方法执行");
        return a == b;
    }

    public static boolean isSame(long a, long b){
        System.out.println("两个long参数的方法执行");
        return a == b;
    }
}


