package cn.learn.basic.Demo01;

import java.util.Random;
import java.util.Scanner;

public class Demo23GuessNumberPlus {
    public static void main(String[] args) {
        //创建随机数
        Random r = new Random();
        //生成一个随机目标数
        int bou = 100;
        int Goal = r.nextInt(bou);
        Scanner sc = new Scanner(System.in);
        System.out.println("猜数游戏开始：");
        System.out.println("请猜一个0至" + bou + "之间的数");
        for (int i = 0; i < 5; i++) {
            int Guess = sc.nextInt();
            if (Guess > Goal) {
                System.out.println("你猜的数是：" + Guess + ",猜大了您勒！");
                System.out.println("请重试：");
            } else if (Guess < Goal) {
                System.out.println("你猜的数是：" + Guess + ",猜小了您勒！");
                System.out.println("请重试：");
            } else if (i < 5 && Guess == Goal){
                System.out.println("恭喜，猜对了！！");
                break;
            }
            if(i >= 4){
                System.out.println("你输了*-*！");
                break;
            }

        }
    }
}
