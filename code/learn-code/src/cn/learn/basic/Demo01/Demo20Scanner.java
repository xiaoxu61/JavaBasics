package cn.learn.basic.Demo01;
//1������
import java.util.Scanner;
/*
Scanner��Ĺ��ܣ�����ʵ�ּ����������ݣ���������

�������һ��ʹ�ò��裺
1������
   import ��·��.������
   �����Ҫʹ�õ�Ŀ���࣬�͵�ǰ��λ��ͬһ�����£������ʡ�Ե�����䲻д
   ֻ��java.lang���µ����ݲ���Ҫ�����������İ�����Ҫimport���
2������
   ������ ������ = new ������();
3��ʹ��
   ������.��Ա������()


*/

public class Demo20Scanner {
    public static void main(String[] args) {
        //String str = "123";
        //2������
        Scanner sc = new Scanner(System.in);
        System.out.println("����һ��������");
        int num = sc.nextInt();
        System.out.println("������һ������");
        int num1 = sc.nextInt();
        int sum = num + num1;
        System.out.println("���ӽ��Ϊ��" + sum);
        System.out.println("����һЩ�֣�" );
        String str = sc.next();
        System.out.println("������ַ��ǣ�" + str);
        System.out.println("�����һ������:");
        int a = sc.nextInt();
        System.out.println("����ڶ�������:");
        int b = sc.nextInt();
        System.out.println("�������������:");
        int c = sc.nextInt();
        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;
        System.out.println("�������ֵΪ��" + max);
    }
}
