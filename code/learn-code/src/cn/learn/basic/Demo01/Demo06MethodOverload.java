package cn.learn.basic.Demo01;
/*
  方法的重载（Overload）：多个方法的名称功能一样，但是参数列标不一样
  方法重载与下列因素相关：
    1、参数个数不同
    2、参数类型不同
    3、参数的多类型顺序不同
  方法与下列参数方法无关
    1、与参数的名称无关
    2、与方法的返回值类型无关
*/

public class Demo06MethodOverload {
    public static void main(String[] args) {
        System.out.println(sum(1,5));
        System.out.println(sum(1,5,6));
        System.out.println(sum(1,5,6,1));

    }

    public static int sum(int a, int b){
        System.out.println("doubleSum");
        return a+b;
    }
    public static int sum(int a, int b, int c){
        System.out.println("tripleSum");
        return a+b+c;
    }
    public static int sum(int a, int b, int c, int d){
        System.out.println("tetradSum");
        return a+b+c+d;
    }


}
