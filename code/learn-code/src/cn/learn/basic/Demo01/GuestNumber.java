package cn.learn.basic.Demo01;/*
   ʵ�ֲ����ֵ�С��Ϸ
       �����һ�����֣����û���
	   ������������
	       ���ˣ����ˣ�С��
		�������Random
		�������룺Scanner
		�µ����ֺ���������бȽ� if �ж�
		ֱ������Ϊֹ������ȥ�£�ѭ��while
*/
import java.util.Random;
import java.util.Scanner;
public class GuestNumber{
	public static void main(String[] args){
		//����Random�����
		Random ran = new Random();
		//����Scanner�����
		Scanner sc = new Scanner(System.in);
        //����.ʹ�ù���nextInt(); ��ȡ1~100�����
		int i = ran.nextInt(100)+1;
		System.out.print("С�ϵ����¸�1~100������");
		while(true){
			//��ȡ��������
			int j = sc.nextInt();
			if(i > j){
				System.out.println("С�ϵ�(��o��)�����С��");
			}else if(i < j){
				System.out.println("С�ϵ� ��* *��!��´���");
			}else{
				System.out.println("��¶���  ������  ����ţ��");
				break; 
			}
		}
		
	}
}