package cn.learn.basic.Demo01;
/*
Random��������������֡�ʹ������Ҳ���������裺
1������
   import java.util.Random
2������
   Random r =new Random();//���ռ���
3��ʹ��
   ��ȡһ�������int����(��Χ��int���з�Χ������������)�� int num = r.nextInt();
   ��ȡһ�������int���֣����������˷�Χ������ҿ����䣩��int num = r.nextInt(3);
      ʵ���ϴ���ĺ����ǣ�[0,3)֮�������
      ����ȡ[1,3],�����һ����

*/

import java.util.Random;

public class Demo22UseRandom {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt();
        System.out.println("������ǣ�" + num);
        for (int i = 0; i < 10; i++) {
            int num1 = r.nextInt(10);//ʵ���Ϸ�Χ��0~9֮�����
            int num2 = r.nextInt(10) + 1;//ʵ���Ϸ�Χ��1~10֮�����
            System.out.println("num1��ֵ" + num1);
            System.out.println("num2��ֵ" + num2);
        }
    }
}
