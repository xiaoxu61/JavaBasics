package cn.learn.basic.Demo01;/*
  ������������ַ���
*/
import java.util.Random;
public class callName{
	public static void main(String[] args){
		//�洢�����������洢��������
		//����洢�������������������ͣ�String
		String[] names = {"����","����","����","С��","С��","����","С��","С��","�ɻ�","̹��"};
		for(int i = 0; i < names.length; i++){
			System.out.println(names[i]);
		}
		System.out.println("=======");
		//�����һ������
		//���������������һ����������Ϊ���������������ҵ���Ӧ��Ԫ��
		Random ran = new Random();
		//���������Χ������0~������������
		int index = ran.nextInt(names.length);
		System.out.println(names[index]);
		
		System.out.println("=======");
		//�������飬�洢ѧ������
		String[] Names = new String [10];
		//���������������
		addStudent(Names);
		//���ñ������鷽��
		printStudentName(Names);
		//������������ķ���
		String name = randomStudentName(Names);
		System.out.println("=======");
		System.out.println(name);
		
	}
	/*
	  1���洢����ѧ������
	  2��Ԥ������ѧ����������������
	  3���������Ϊ����������������Ԫ��
	  
	  ���������ɷ��������÷�������
	  �����������ܣ��õ�ͬһ����������
	  �����洢�������У�����������ʹ��һ�������е����ݣ��������ݲ���
	*/
	/*
	   ���巽����ʵ�������������ѧ������
	   ����ֵ��û��
	   ������������������
	*/
	public static void addStudent(String[] Names){
		 Names[0] ="����"; Names[1] ="����"; Names[2] ="����";
		 Names[3] ="С��"; Names[4] ="С��"; Names[5] ="����";
		 Names[6] ="С��"; Names[7] ="С��"; Names[8] ="�ɻ�";
		 Names[9] ="̹��";
	}
	/*
	  ���巽������������
	  ����ֵ��û��
	  ����������
	*/
	public static void printStudentName(String[] Names){
		for(int i = 0; i < Names.length; i++){
			System.out.println(Names[i]);
		}
	}
	/*
	  ���巽��������������������������ҵ�ѧ������
	  ����ֵ��ѧ������
	  ����������
	*/
	public static String randomStudentName(String[] Names){
		Random Ran = new Random();
		int Index = Ran.nextInt(Names.length);
		return Names[Index];
	}
}