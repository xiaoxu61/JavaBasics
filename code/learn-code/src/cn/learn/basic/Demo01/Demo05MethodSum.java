package cn.learn.basic.Demo01;
/*
  题目要求：
       1、定义一个方法，用来求出1~100之间所有数字的值
       2、定义一个方法，用来打印指定次数的HelloWorld
*/
public class Demo05MethodSum {
    public static void main(String[] args) {
        System.out.println(getSum());
        print(5);
    }


    public static int getSum(){
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
    public static void print(int a){
        for (int i = 1; i <= a; i++) {
            System.out.println("HelloWorld"+i);
        }
    }
}
