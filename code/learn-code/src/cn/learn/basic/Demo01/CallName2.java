package cn.learn.basic.Demo01;/*
  ���������,���ϸĽ�(ѧ��������������)
  ��ʵ����ѧ��������ʹ�ö������ʽ������ѧ������
  ���ԣ�����������
  
  �����洢�����飬���������ɼ���
  String[] s = {"",""};
  �����д洢����ѧ����������Ӧ�ô洢Student����
  �洢ѧ����
    ѧ������,�洢��������
	��������������
	��������������Ϊ����,���������ҵ�Ԫ��
	�������ܣ��������ݣ���������
	������������������������ݼ���
*/
import java.util.ArrayList;
import java.util.Random;

public class CallName2{
	public static void main(String[] args){
		//���弯�ϣ��洢����StudentName���ͱ���
		ArrayList<StudentName> array = new ArrayList<StudentName>();
		//������ӷ���
		add(array);
		//���ñ�������
		printArrayList(array);
		//���������
		randomStudentName(array);
	}
	/*
	  ����ѧ������Ϣ����������
	*/
	public static void printArrayList(ArrayList<StudentName> array){
		for(int  i = 0; i < array.size(); i++){
			//�洢���ϵ�ʱ�򣬼���.add(sn1)
			//��ȡ������ʱ��,����.get��������ȡ��������ʲô,����StudentName���ͱ���
			
			System.out.println(array.get(i));
			
			StudentName s = array.get(i);
			System.out.println(s.name+" "+s.age);
			
		}
	}
	/*
	  ��������������ϵ����������������ҵ�Ԫ��
	*/
	public  static  void randomStudentName(ArrayList<StudentName> array){
		Random r = new Random();
		int number = r.nextInt(array.size());
		//���������������������get
		StudentName s = array.get(number);
		System.out.println(s.name+" "+s.age);

	}
	/*
	  ���巽��ʵ�ִ洢ѧ��������������
	  ����StudentName���ͱ������洢��������
	*/
	public static void add(ArrayList<StudentName> array){
		//����StudentName���ͱ���
		StudentName sn1 = new StudentName();
		StudentName sn2 = new StudentName();
		StudentName sn3 = new StudentName();
		StudentName sn4 = new StudentName();
		StudentName sn5 = new StudentName();
		StudentName sn6 = new StudentName();
		
		sn1.name = "��1";
		sn1.age  =  21;
		sn2.name = "��2";
		sn2.age  =  22;
		sn3.name = "��3";
		sn3.age  =  23;
		sn4.name = "��4";
		sn4.age  =  24;
		sn5.name = "��5";
		sn5.age  =  25;
		sn6.name = "��6";
		sn6.age  =  26;
		
		//��StudentName�������洢��������
		array.add(sn1);
		array.add(sn2);
		array.add(sn3);
		array.add(sn4);
		array.add(sn5);
		array.add(sn6);
	}
	
}