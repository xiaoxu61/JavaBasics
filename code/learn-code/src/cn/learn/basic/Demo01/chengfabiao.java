package cn.learn.basic.Demo01;

import java.util.Scanner;

public class chengfabiao {
    public static void main(String[] args){
        //���ü������룬ϵͳ����һ��������ֵ
        //int num = number();
        //���ã���ӡ����������һ�����γ˷���
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
