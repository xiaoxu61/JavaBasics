package cn.learn.basic.Demo01;

import java.util.Random;
import java.util.Scanner;

public class Demo23GuessNumberPlus {
    public static void main(String[] args) {
        //���������
        Random r = new Random();
        //����һ�����Ŀ����
        int bou = 100;
        int Goal = r.nextInt(bou);
        Scanner sc = new Scanner(System.in);
        System.out.println("������Ϸ��ʼ��");
        System.out.println("���һ��0��" + bou + "֮�����");
        for (int i = 0; i < 5; i++) {
            int Guess = sc.nextInt();
            if (Guess > Goal) {
                System.out.println("��µ����ǣ�" + Guess + ",�´������գ�");
                System.out.println("�����ԣ�");
            } else if (Guess < Goal) {
                System.out.println("��µ����ǣ�" + Guess + ",��С�����գ�");
                System.out.println("�����ԣ�");
            } else if (i < 5 && Guess == Goal){
                System.out.println("��ϲ���¶��ˣ���");
                break;
            }
            if(i >= 4){
                System.out.println("������*-*��");
                break;
            }

        }
    }
}
