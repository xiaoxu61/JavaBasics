package cn.learn.basic.Demo01;

/*
   switch���,ѡ�����
   ��д��ʽ��
         switch(���ʽ��Ϊ�˵õ�һ��ֵ){
			 case ����1 :
			    Ҫִ�е����;
			 break;
			 
			 case ����2 :
			    Ҫִ�е����;
			 break; 
			 
			 case ����3 :
			    Ҫִ�е����;
			 break;
			 
			 default:
			     Ҫִ�е����;
			 break;
		 }
		 ִ�����̣����ʽ��case��ߵĳ������бȽ�
		 ���ĸ�case��ĳ�����ͬ��ִ���ĸ�case����ĳ�������break��ȫ����
		 �ؼ��֣�switch case break default
**************************************************************************		 
	     switch����еı��ʽ��������������Ҫ���
		 JDK1.0~1.4 �������ͽ���byte short int char
		 JDK1.5~    �������ͽ���byte short int char enum(ö��)
		 JDK1.7     �������ͽ���byte short int char enum String
*/
public class SwitchDemo{
	public static void main(String[] args){
		//�����������������ڱ������ڼ�������
		int week = 6;
		//switch���
		switch(week){
			case 1:
			  System.out.println("����һ");
			break;
			
			case 2:
			  System.out.println("���ڶ�");
			break;
			
			case 3:
			  System.out.println("������");
			break;
			
			case 4:
			  System.out.println("������");
			break;
			
			case 5:
			  System.out.println("������");
			break;
			
			case 6:
			  System.out.println("������");
			break;
			
			case 7:
			  System.out.println("������");
			break;
			
			default:
			  System.out.println("���ڲ�����");
			break;
		}
//switch��һ���ԣ�case�Ĵ�͸��
//     case�ĳ�����switch��������ͬ��case����û������break ����ͻ�һֱ���´�
//����������һ~�壬�����ա�����6~7�����Ϣ��		
		switch(week){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			  System.out.println("������");
			break;
			
			case 6:
			case 7:
			  System.out.println("��Ϣ��");
			break;
			
			default:
			  System.out.println("���ڲ�����");
			break;
		}

/*
   ���飺����̫�������
     ������������
	     ��������������Ҫ�أ�ǿ��������������
		 �������������ͣ���С�����Ǵ洢���ݵĸ���
		 �������鹫ʽ��
		       ��������[] ������ = new ��������[�洢Ԫ�صĸ���];
			   
			   �������ͣ������д洢Ԫ�ص���������
			   []      ����ʾ�������˼
			   ������  ���Զ����ʶ��
			   �������ͣ������д洢Ԫ�ص���������
			   []      ����ʾ�������˼
			   Ԫ�ظ����������У����Դ洢���ٸ�����
			   
			������һ���������洢�������е�ÿ��Ԫ�أ������Լ����Զ����
			�Զ���ţ���Сֵ��0�����ֵ������-1��
			�Զ����רҵ���ƣ�������index��,�±꣬�Ǳ�
			��������洢��Ԫ�أ�����������������ʽ��������[����]; 
			
			Java�ṩһ�����ԣ���������
			�����һ�����ԣ�����ĳ��ȣ����Ե����֣�length
			ʹ�����Թ�ʽ��������.length  �������ͣ�int
			
			�������С������0�������������.length-1
		��������У������������쳣
            ���������Խ���쳣  ����java.lang.ArrayIndexOutOfBoundsException: 6
            ��ָ���쳣			
*/
            //�������飬�洢�������������ȣ�3��
			//��������[] ������ = new ��������[�洢Ԫ�صĸ���];
			int[] arr = new int[3];
			//arr���������������ͣ����������ʵ�����ڴ��еĵ�ַ
			System.out.println(arr);
			//ͨ�������ķ�ʽ�����������е�����Ԫ��
			System.out.println(arr[0]);
			System.out.println(arr[1]);
			System.out.println(arr[2]);
			System.out.println(arr.length);
//    ������������巽ʽ
//1����������[] ������ = new ��������[]{Ԫ��1��Ԫ��2��Ԫ��3}��
//ע�����new������������У�������д�κ����ݣ�д�˾ͱ���ʧ��
			int[] arr1 = new int[]{1,2,4,6,9};
			System.out.println(arr1.length);
			System.out.println(arr1[3]);
			System.out.println("==============");
//2����������[] ������ = {Ԫ��1��Ԫ��2��Ԫ��3};
//ֱ�Ӵ����Ÿ�ֵ,��
			int[] arr2 = {0,2,4,6,};
			System.out.println(arr2.length);
			System.out.println(arr2[3]);
			
//ʹ���������������е�Ԫ�ؽ��и�ֵ
//�������飬�洢int�������飬���Ⱦ���5
            int[] arr3 = new int[5];
            arr3[3] = 3;			
			System.out.println(arr3[4]);
/*���������
    �����е�����Ԫ�� ȫ��ȡ(��������)
	���ɴ�0��ʼ��һֱ�Զ�����1������length-1;
	ѭ����ʵ��
	    for  ֪��ѭ��������������˼��
		while��ȷ��ѭ������
*/
			int[] arr4 = {1,5,9,7,6,5};
			System.out.println("�������(whileѭ��):");
			int num = 0; 
			while(num < arr4.length){
				System.out.println(arr4[num]);
				num++;
			}
			System.out.println(arr4[5]);
			System.out.println(num);
			
			
			System.out.println("�������forѭ��");
			for(int i = 0; i < arr4.length; i++){
			    System.out.println(arr4[i]);
				
			}
/*
    ��ȡ�����е���ֵ�������������max����min�Ƚ�������Ԫ��
	����max����min��¼�±Ƚ��нϴ���С������������ɺ��¼����������������Сֵ
*/
            int[] arr5 = {1,5,8,5,9,7,6};
			//���������¼����0�ϵ�Ԫ��
			int max = arr5[0];
			//�������飬��ȡ���е�Ԫ�أ��ͱ���max���бȽ�
			for(int i = 1; i < arr5.length; i++){
				//����max�������е�ÿ��Ԫ�ؽ��бȽ�
				//���maxС�������е�һ��Ԫ��
				if (max < arr5[i]){
					//�ϴ�������Ԫ�أ���ֵ��max
					max = arr5[i];
				}
			}
			//������ɣ�����max�����������ֵ
			System.out.println("�����е����ֵ��" +max);
			
/*
  ��ά����
     �����е����飬��������洢�Ļ�������
  ���巽ʽ��һά��������
  int[][] arr = new int[3][4];
  ����һ����ά����
  [3]��ʾ����ά������������һά����
  [4]��ʾ������һά�����У�ÿ������ĳ�����4
*/
            int[][] arr6 = new int[3][4];
			System.out.println(arr6);
			System.out.println(arr6[1]);
			System.out.println(arr6[1][2]);
			
//��򵥵Ķ�λ���鶨�壺
// int[][] arr = {{1,4},{1,6,8},{3,5,9,10}}
            int[][] arr7 = {{1,2,3},{4,5},{6,7,8,9},{0} };
			//�����ӡ�����е�Ԫ��7
			System.out.println("��ά�����е�" +arr7[2][1]);
			System.out.println(arr7[1].length);
			//��ά����ı���
			//forѭ��������ά���飬���������У�for����һά����
			//��ѭ��������ά����
			for(int i = 0; i < arr7.length; i++){
				//��ѭ������ÿ��һά����
				for(int j = 0; j < arr7[i].length; j++){
					System.out.print("��"+i+"��,"+"��"+j+"������"+arr7[i][j]);	
				}
				System.out.println();
			}
			//��whileѭ��ʵ�ֱ���
			int numOut = 0;
			while(numOut < arr7.length){
				int numIn = 0;
				while(numIn < arr7[numOut].length){
					System.out.println("��"+numOut+"��,"+"��"+numIn+"������"+arr7[numOut][numIn]);
					numIn++;
				}
				numOut++;
			}
			
		//��ά����ı������
            int[][] arr8 = {{11,12},{21,22,23},{31,32,33,34},};
            //�����������������͵�ֵ
            int sum = 0;        //�������е����
            int groupSum = 0;	//����ÿ��һά�������
            for(int i = 0; i < arr8.length; i++){
				for(int j = 0; j < arr8[i].length; j++){
					//��һά�����Ԫ�����
					groupSum += arr8[i][j];
				}
				System.out.println("ÿ��С���ܽ��"+groupSum);
				//��ÿ��һά�������
				sum += groupSum;
				groupSum = 0;
			}
            System.out.println("��˾���ܽ��"+sum);			
/*
JVM���Լ����ڴ�����˻��֣���Ϊ5������

          �洢�����ڴ��CPU֮��
      ���ط���ջ��JVM������ϵͳ�еĹ���
  ���������ݹ�������ʱ��class�ļ�������ĵط�
          ����ջ�����еķ������е�ʱ�򣬽�����ڴ�
              �ѣ��洢���������Ͷ���
*/
	}
}