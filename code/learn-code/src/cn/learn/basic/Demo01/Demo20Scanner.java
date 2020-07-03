package cn.learn.basic.Demo01;
//1、导包
import java.util.Scanner;
/*
Scanner类的功能，可以实现键盘输入数据，到程序当中

引用类的一般使用步骤：
1、导包
   import 包路径.类名称
   如果需要使用的目标类，和当前类位于同一个包下，则可以省略导包语句不写
   只有java.lang包下的内容不需要导包，其他的包都需要import语句
2、创建
   类名称 对象名 = new 类名称();
3、使用
   对象名.成员方法名()


*/

public class Demo20Scanner {
    public static void main(String[] args) {
        //String str = "123";
        //2、创建
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个加数：");
        int num = sc.nextInt();
        System.out.println("输入另一个加数");
        int num1 = sc.nextInt();
        int sum = num + num1;
        System.out.println("所加结果为：" + sum);
        System.out.println("输入一些字：" );
        String str = sc.next();
        System.out.println("输入的字符是：" + str);
        System.out.println("输入第一个数字:");
        int a = sc.nextInt();
        System.out.println("输入第二个数字:");
        int b = sc.nextInt();
        System.out.println("输入第三个数字:");
        int c = sc.nextInt();
        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;
        System.out.println("其中最大值为：" + max);
    }
}
