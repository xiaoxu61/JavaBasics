package cn.learn.basic.Demo01;

/*
   ѭ����䣺������һ���ִ��뷴��ִ��
   whileѭ����д��ʽ��
         while(����){
			 ѭ����
		 }
		 ��������������true����ִ��ѭ���壬ִ����ѭ�����
		 �����ٴ�ִ��while�е������������������true������ִ��ѭ����
		 ֱ��������false��ʱ��ѭ���ͽ���
*/
public class WhileDemo{
	public static void main(String[] args){
		//���1~4֮�������
		//����������������ͣ�ѭ��������
		int i = 1;
		while(i <= 4){
			System.out.println(i);
			i++;
		}
/*
  forѭ����д��ʽ
      for(��ʼ������ ; ���� ; ����){
		  ѭ����
	  }
	  ��ʼ��������������������ã�����ѭ���Ĵ���
	  1���������壬��һ��whileѭ���У�����Ͷ���һ��
	  2��������false������for����
	      3����true��ִ��ѭ����
		  4��ִ������
		  5����ִ��2��  ���ѭ��
	  ��������������true��ִ��ѭ���壬������false������ѭ��
	  �����������������
*/
         //    �������   ����   ����
         for(int j = 0; j <= 10; j++){
			 System.out.println(j);
		 }
		 //����forѭ��������1+��4 �Ľ��
		 int sum = 0;
		 //����ѭ������������1�仯��4
		 for(int i1 = 1; i1 <= 4; i1++){
			 //�Ա����������
			 sum = sum + i1;
		 }
			 System.out.println(sum);
/*
  do...whileѭ����д��ʽ��
         do{
			 ѭ����
		 }while(����)��
     �ص㣺��������ִ��һ��
*/		 
         int a = 0;
		 do{
			 System.out.println(a);
			 a++;
		 }while(a < 5);
		 
/*
   //��ѭ��
   //while��ʽ��ѭ��
       while(true){
	   
       }
   //for��ʽ��ѭ��
       for( ; true; ){
		   
	   }
*/
    /*
	  Ƕ��ѭ����ѭ�����滹��ѭ����for��ʽ��
	  for(����){
		  for(����){
			  
		  }
	  }
	  ��ѭ������ = ��ѭ������*��ѭ������
	  ��ѭ������ѭ����ѭ����
	*/
	    for(int b  = 0; b <= 9; b++){
		    for(int c = 0; c <= b; c++ ){
			    System.out.print(c);
		    }
			System.out.println();
	    }
/*
   break �ؼ���
   ������ѭ���У���ֹѭ��������
*/		
	     int d = 1;
		 while(true){
			 if(d == 3){
				 break;
			 }else{
				 System.out.println(d);
			 }
			 d++;
		 }
	//��ѭ����������ѭ��ǰ  ѭ���� + �� ���ɣ�
	//��ֹĳ��ѭ�� break + ѭ����;
	//break����û��ѭ�������Ǿ�����ֹ��ǰѭ��
	      a: for(int e = 0; e < 5; e++){
			  for (int f = 0; f < 7; f++){
				  System.out.print("F"+f);
				  break a;
			  }
			  System.out.println("E"+e);
		  }
/*
   continue �ؼ���
   ���ã���ѭ���У���ֹ����ѭ������ʼ��һ��ѭ��
*/
             for(int g = 0; g < 10; g++){
				 if(g % 2 == 0){     //����ż��
					 continue;       //������ǰѭ������ʼ�´�ѭ��
				 }
				 System.out.println(g);
			 }
	}
}