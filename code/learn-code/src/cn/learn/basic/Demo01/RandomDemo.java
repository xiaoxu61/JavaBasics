package cn.learn.basic.Demo01;/*
   java���Ѿ��е��������� Random�࣬���ã����������
   ���裺
      1���������Random�࣬Ҳ��Java.util�ļ���
	  2����ʽ��������Random���͵ı���
	  3������.����Random���еĹ��ܣ����������
	  
	  Random�࣬�ṩ���ܣ����� nextInt() ����һ��������������int����
	  ����������ķ�Χ���ڹ���nextInt(дһ������)������������������ķ�Χ
	  ������ķ�Χ��0~ָ������֮��������  nextInt(100) 0~99
	  
	  ��������������:��������nextDouble() ������ķ�Χ0.0~1.0
	  
	  ������ڵ��������α������������������д�õ�һ���㷨���ɳ�����
*/
import java.util.Random;
public class RandomDemo{
	public static void main(String[] args){
		 //2.��ʽ��������Random���͵ı���
		 Random ran = new Random();
		 //3������.����Random���еĹ��ܣ����������
		 //Random���еĲ���������Ĺ���
		 int i = ran.nextInt(50);
		 System.out.println(i);
		 
		 //���⣿�������������Χ1��100֮��
		 //nextInt(100) 0~99 + 1
		 
		 double d = ran.nextDouble();
		 System.out.println(d);
		 
	}
}