package cn.learn.basic.Demo01;/*
  �����Ķ����ʽ
      ���η� ����ֵ���� ����������(�����б�){
		  �����Ĺ�������
		     ѭ�����жϣ��������Ƚϣ�����
		   return;
	  }
	  
	      ���η����̶�д�� public static
	  ����ֵ���ͣ���������󣬽�����������ͣ��޷���ֵʱ����ֵ������void
	      ���������Զ������֣������ʶ���淶��������������ĸСд������ÿ����������ĸ��д
        �����б���������������У��Ƿ���δ֪�����ݣ������δ֪�����ݣ������ڲ����б���(�������)
		  return�������ķ��أ�������Ľ������.��������
	
    ���������ʹ�õ�ע����� 
	    1���������ܶ�������һ������������
		2��д����������
		3��д���˲����б�
		4����������ֵ��void�������п���ʡ��return ��д
		5�������ķ���ֵ���ͺ�return������������ͱ���ƥ��
		6�������ظ���������
		7�����÷�����ʱ�򣬷���ֵ��void������д����������
		
    		  
	��������������(overload)
	   ��ͬһ�����У��������ͬ���ķ�����ֻҪ�����Ĳ����б�ͬ�������ķ�����������
	   �����б�ͬ�������ĸ������������ͣ�˳��
	  ע�����
	    1�������б���벻ͬ
		2�����غͲ����������޹�
		3�����غͷ���ֵ�����޹�
		3�����غ����η��޹�
	  ���ɣ����ؿ��������Ͳ����б�
*/
import java.util.Scanner;
public class MethodDemo{
	public static void main(String[] args){
		//���÷���������ִ������
		//�ڷ���main�У����÷��� getArea
		int area = getArea(5,6);
		System.out.println("����ǣ�" +area);
		System.out.println("����ǣ�"+getArea(7,8));
		//��ӡ����
		printRect();
		//����¼��õ�һ������
		int number = getNumber();
		System.out.println(number);
		//��ӡָ��M�У�ÿ��N��*�ŵľ���
		printRect2(3,5);
		//����������ƽ��ֵ
		//int getAvg(1,3,5);
		System.out.println(getAvg(1,3,5));
		//���������صĵ��ã����ݲ������ݽ�������
		System.out.println(getSum(1.2,3));
		//�����������еĲ�����������
		//������������
		int a = 1;
		int b = 2;
		change(a,b);
		System.out.println(a);
		System.out.println(b);
		//��������
		int[] arr = {1,2,3,4};
		System.out.println(arr[2]);
		change(arr);
		System.out.println(arr[2]);
		
		
		
	}
	/*
	   �����Ķ�����ϰ
	   
	     �����޷���ֵ���޲������������ӡ3�У�ÿ��3��*��
		 Ϊʲôû�з���ֵ��
		     ��ӡ���Σ�������������Ҫ���������
			 ��ȷδ֪��������Ҫδ֪��
	*/
	public static void printRect(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print("*");
			}
				System.out.println();
		}
	}
	/*
	  �����з���ֵ�޲��������������¼��õ�һ������
	  ��ȷ��������������������� int
	  ��ȷ��û��δ֪����û��
	*/
	public static int getNumber(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		return number;
	}
	/*
	  �����޷���ֵ���в������������ӡָ��M�У�ÿ��N��*�ŵľ���
	  ��ȷ�����������������̨���ͼ�Σ�û�з���ֵ��
	  ��������û��δ֪����ͼ����������������δ֪�ģ�������������int
	*/
	public static void printRect2(int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print("*");
			}
				System.out.println();
		}
	}
	/*
	   �����з���ֵ�в���������������������ƽ��ֵ
	   ��ȷ�������������ͣ�����ֵ���� int
	   ��ȷ����δ֪��������δ֪��������
	*/
	public static int getAvg(int a, int b, int c){
		return (a+b+c)/3;
	}
	/*
	Ҫ�󣺼���һ�������ε����
	���巽��������Ҫ��
	��������������̣�
	    1����ȷ���������Ľ������������ int �����ʽ��Ӧ�ľ��Ƿ���ֵ����
		2�������ļ�������У���û��δ֪�����ݣ���ͳ���δ֪���ݵ��������� int
		   δ֪���ı����������ڷ�����С������
	*/
	public static int getArea(int W, int h){
		//ʵ�ַ����Ĺ�������
		int area = W * h;
		return area;
	}
	/*
	  
	  ���巽�����Բ������
	  ������û�й涨��������������
	
	public static int getSum(int a; int b){
		return a + b;
	}
	
	public static double getSumDouble(double a; double b){
		return a + b;
	}
	public static int getSum3(int a; int b; int c){
		return a + b + c;
	}
	*/
	//�Բ�����ͣ����÷�������������
	public static int getSum(int a, int b){
		System.out.print("����int�����ĺ�Ϊ");
		return a + b;
	}
	public static int getSum(int a, int b, int c){
		System.out.print("����int�����ĺ�Ϊ");
		return a + b + c;
	}
	public static double getSum(double a, double b){
		System.out.print("����double�����ĺ�Ϊ");
		return a + b;
	}
	/*
	  �����������еĲ�����������
	      1�����������ǻ�����������
		  2��������������������
		     ���ݵ��ǵ�ַ
	*/
	public static void change(int a, int b){
		a = a+b;
		b = b+a;
	}
	public static void change(int[] arr){
		arr[2] = 100;
	}
	
}