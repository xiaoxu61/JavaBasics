package cn.learn.basic.Demo01;

/*
  �㷨�����
  + �ӷ�������
  - ����
  * �˷�
  / ����
  % ȡģ����ȡ����
  ++ ����1
  -- �Լ�1
*/
public class Operator{
	public static void main(String[] args){
		// + �������ã���һ���ַ���������������������
		// + �����ַ�����������ӷ��š�5+5=55��
		// + �κ�����ֻҪ���ַ���+�����е����ݶ�������ַ���
		System.out.println("5+5 = "+5+5);
		//��������
		int i = 100;
		int j = 9;
		System.out.println(+i/j);
		//ȡģ���㣬�������������ȡ��������
		int k = 6;
		int m = 4;
		System.out.println(k%m);
		//�������� ++
		int a = 2;
		int b = 4;
		a++;        //����a�Լ�����1
		System.out.println(a);
        ++b;
		System.out.println(b);
		/*
		   ++ д�ڱ���ǰ�棬��д�ں�ߵ�����
		   a = 1
		   a++  ++a ����д��ǰ�滹�Ǻ��棬�ڱ����Լ����������ʱ��û������
		   ���Ǳ���Ҫ�ǲ����������������������
		*/
		int k1 = 5;
		int k2 = k1++;   //++ ���㣬�Ƚ�K1��ֵ����k2��k1�Լ���++
		System.out.println(k1);
		System.out.println(k2);
		
		int k3 = 5;
		int k4 = ++k3;   //++ ���㣬�Ƚ�K3��ֵ++�ٸ���k4
		System.out.println(k3);
		System.out.println(k4);
		
		/*
		  ��ֵ�����
		  =
		  += -= *= /= %=
		*/
		//= ��ֵ���㣬�������ֵ����ֵ����ߵı���
		int k5 = 3;
		k5 = k5 + 3;
		System.out.println(k5);
		
		//+= ��ֵ����� i+=3 i = i+3
		int k6 = 5;
		k6 += 6;   //k6 = k6 + 6
		System.out.println(k6);
		
		byte k7 = 1;
		k7 =(byte)(k7 + 1);
		System.out.println(k7);
		byte b1 = 1;
		b1+=1;  //��ͬ��(byte)(b1 + 1)  �Ƽ��üӵȣ�������ǿ��ת��
		System.out.println(b1);
		
		/*
		  ==�����  !=������ <С�� >���� <=С�ڵ��� >=���ڵ���
		  �ȽϷ������ߵ�����
		  �Ƚ������ �ȽϵĽ���ǲ���ֵ��true����false 
		  ������������������boolean����
		  
		*/
		int i1 = 3;
		int j1 = 4;
		//System.out.println(i1 = j1);
		//System.out.println(i1 == j1);
		//System.out.println(3 == 4);
		
		/*
		  �߼������ &�� |�� ^���(������ͬΪ��) !�ǣ�ȡ����
		  &&��·�루һ����false��һ�߲����У�  
		  ||��·��һ����true����һ�߲����У�
		  ������Boolean��������֮����м��㣬���Ҳ��Boolean����
		*/
		System.out.println(true & true);
		
		System.out.println(3>4 && ++j1>2);
		System.out.println(i1);
		System.out.println(j1);
		/*
		  ��Ԫ�����
		  ��ʽ��
		      �������ʽ �� ���1�����2
		  �������ʽ�����true����Ԫ������Ľ���ǽ��1
		  �������ʽ�����false����Ԫ������Ľ���ǽ��2
		*/
		System.out.println(3>5?99:88);
		String S = 0 == 0 ? "�������" : "�Ǻ�";
		System.out.println("���ǲ��ǵ����㣿"+S);
	}
}