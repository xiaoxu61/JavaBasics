package cn.learn.basic.Demo01;
/*
Random类来生成随机数字。使用起来也是三个步骤：
1、导包
   import java.util.Random
2、创建
   Random r =new Random();//留空即可
3、使用
   获取一个随机的int数字(范围是int所有范围，有正负两种)： int num = r.nextInt();
   获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num = r.nextInt(3);
      实际上代表的含义是：[0,3)之间的数字
      若获取[1,3],整体加一即可

*/

import java.util.Random;

public class Demo22UseRandom {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt();
        System.out.println("随机数是：" + num);
        for (int i = 0; i < 10; i++) {
            int num1 = r.nextInt(10);//实际上范围是0~9之间的数
            int num2 = r.nextInt(10) + 1;//实际上范围是1~10之间的数
            System.out.println("num1的值" + num1);
            System.out.println("num2的值" + num2);
        }
    }
}
