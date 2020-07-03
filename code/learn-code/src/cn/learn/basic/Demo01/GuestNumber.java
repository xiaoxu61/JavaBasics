package cn.learn.basic.Demo01;/*
   实现猜数字的小游戏
       随机数一个数字，让用户猜
	   结果三种情况：
	       中了，大了，小了
		随机数：Random
		键盘输入：Scanner
		猜的数字和随机数进行比较 if 判断
		直到猜中为止，反复去猜，循环while
*/
import java.util.Random;
import java.util.Scanner;
public class GuestNumber{
	public static void main(String[] args){
		//创建Random类变量
		Random ran = new Random();
		//创建Scanner类变量
		Scanner sc = new Scanner(System.in);
        //变量.使用功能nextInt(); 获取1~100随机数
		int i = ran.nextInt(100)+1;
		System.out.print("小老弟来猜个1~100的整数");
		while(true){
			//获取键盘输入
			int j = sc.nextInt();
			if(i > j){
				System.out.println("小老弟(⊙o⊙)？你猜小了");
			}else if(i < j){
				System.out.println("小老弟 （* *）!你猜大了");
			}else{
				System.out.println("你猜对了  ！！！  大佬牛逼");
				break; 
			}
		}
		
	}
}