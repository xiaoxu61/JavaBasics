package cn.learn.basic.Demo06;
/*
JDK 1.5 新的特性，方法的可变参数
    前提：方法的数据类型确定，参数的个数任意
    格式：数据类型...变量名
    可变参数本质就是数组
*/

public class Demo02Vrguments {
    public static void main(String[] args) {
        System.out.println(demo01());
        System.out.println(demo01(1,2, 6,7));

        demo02(1, 2, 5, 5, 5, 6);
    }
    /*
        可变参数的注意事项：
            1、一个方法中，可变参数只能有一个
            2、可变参数必须写在参数列表的最后一位
    */
    private static void demo02(int a, int b, int...c) {

    }

    /*
        定义方法，计算X个整数和
        方法的可变参数
    */
    private static int demo01(int...a) {
        int sum = 0;
        for(int i : a) {
            sum = sum + i;
        }
        return sum;
    }
}
