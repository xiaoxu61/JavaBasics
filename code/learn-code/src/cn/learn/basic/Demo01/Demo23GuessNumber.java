package cn.learn.basic.Demo01;
/*
�ô���ģ������ֵ�С��Ϸ
1��������Ҫ����һ��������֣�����һ�������Ͳ��ٱ仯
2����Ҫ�������룬�����õ���Scanner
3����ȡ������������֣���Scanner���е�nextInt����
4���Ѿ��õ����������֣��жϣ�if��һ��
   ����С�˶�Ӧ����ʾ��Ȼ�����²�
   ��������ˣ���Ϸ����
5��ѭ����ȷ������while��true��

*/

import java.util.Random;
import java.util.Scanner;

public class Demo23GuessNumber {
    public static void main(String[] args) {
        //���������
        Random r = new Random();
        //����һ�����Ŀ����
        int bou = 100;
        int Goal = r.nextInt(bou);
        Scanner sc = new Scanner(System.in);
        System.out.println("������Ϸ��ʼ��");
        System.out.println("���һ��0��" + bou + "֮�����");
        while (true){
            int Guess = sc.nextInt();
            if(Guess > Goal){
                System.out.println("��µ����ǣ�" + Guess + ",�´������գ�");
                System.out.println("�����ԣ�");
            }else if (Guess < Goal) {
                System.out.println("��µ����ǣ�" + Guess + ",��С�����գ�");
                System.out.println("�����ԣ�");
            }else{
                System.out.println("��ϲ���¶��ˣ���");
                break;
            }
        }

    }

}
