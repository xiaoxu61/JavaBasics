package cn.learn.basic.Demo01;
/*
用代码模拟猜数字的小游戏
1、首先需要产生一个随机数字，并且一旦产生就不再变化
2、需要键盘输入，所以用到了Scanner
3、获取键盘输入的数字，用Scanner当中的nextInt方法
4、已经得到了两个数字，判断（if）一下
   大了小了都应该提示，然后重新猜
   如果猜中了，游戏结束
5、循环不确定，用while（true）

*/

import java.util.Random;
import java.util.Scanner;

public class Demo23GuessNumber {
    public static void main(String[] args) {
        //创建随机数
        Random r = new Random();
        //生成一个随机目标数
        int bou = 100;
        int Goal = r.nextInt(bou);
        Scanner sc = new Scanner(System.in);
        System.out.println("猜数游戏开始：");
        System.out.println("请猜一个0至" + bou + "之间的数");
        while (true){
            int Guess = sc.nextInt();
            if(Guess > Goal){
                System.out.println("你猜的数是：" + Guess + ",猜大了您勒！");
                System.out.println("请重试：");
            }else if (Guess < Goal) {
                System.out.println("你猜的数是：" + Guess + ",猜小了您勒！");
                System.out.println("请重试：");
            }else{
                System.out.println("恭喜，猜对了！！");
                break;
            }
        }

    }

}
