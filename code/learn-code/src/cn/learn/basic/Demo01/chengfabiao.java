package cn.learn.basic.Demo01;

import java.util.Scanner;

public class chengfabiao {
    public static void main(String[] args){
        //调用键盘输入，系统输入一个整数的值
        //int num = number();
        //调用，打印出输入数的一个梯形乘法表
        print99(number());
    }
    public static void print99(int num){
        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println(" ");
        }
    }
    public static int number(){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }
}
