package cn.learn.basic.Demo01;

/*
   if ����д��ʽ��
     if(����){
		 if	����ִ����
	 }
	 ��������������ǲ������� 1==1 true||false
	 ִ���壺��if�е�����Ϊtrue��ʱ��ִ�д������е�ִ����
	         if����false��ʱ��ʲôҲ����
*/
public class ifDemo{
	public static void main(String[] args){
		int i = 4;
		//�Ա���i����if�ж�
		if(i == 5){
			System.out.println("if�е�������true");
			i++;
		}
			System.out.println(i);
/*
   if...else ���
      ��д��ʽ��
	      if(����){
			  if ��ִ����
		  }else{
			  else ��ִ����
		  }
		 ��if�е�����Ϊtrue��ִ��if��ִ����
		 ��if�е�����Ϊfalse��ִ��else��ִ����
*/
        int  j = 8;
		//�жϱ�������ż��������2��������0 1
		if (j % 2 == 0){
			System.out.println(j+ "��ż��");
	    }else{
			System.out.println(j+ "������");
		}
/*
    if...else if...else���
    ������ڶԶ�����������ж�
         ��д��ʽ��
            if(����){
				ifִ����
			}else if(����){
				ifִ����
			}else if(����){
				ifִ����
			}else{
				else��ִ����
			}
         ��if�е�������true��ִ��ifִ����
         if�е�������false��ִ��elseִ����
         һ������У��������if��ֻҪ��һ��if��������true���������벻��ִ��		 
*/
        //�ɼ��ж�Ҫ�󣬳ɼ�>80��,�ɼ�>70��,�ɼ�>60������
		int grade = 80;
		//ʹ��if else if���Գɼ��ж�
		if(grade > 80){
			System.out.println(grade+ "�ɼ�����");
		}else if(grade > 70){
			System.out.println(grade+ "�ɼ�����");
		}else if(grade > 60){
			System.out.println(grade+ "�ɼ�����");
		}else{
			System.out.println(grade+ "�ɼ��ǲ�");
		}
/*
  if������Ԫ��������滻
    Ҫ����֪���������������ֵ
	���������Ƚϴ�С
	
	ʹ��if����ʹ����Ԫ
	    �ж������Ƚ϶࣬ʹ��if
		��Ԫ�����н����if����û�н��
*/
         int a = 5;
		 int b = 5;
		 //ʹ��if��䣬�жϳ����ֵ
		 if(a > b){
			 System.out.println(a+ "�����ֵ");
		 }else{
			 System.out.println(b+ "�����ֵ");
			 
		 }
     //ʹ����Ԫ����ʵ�� 
	     int k = a > b ? i : j;
			 System.out.println(k+ "�����ֵ");
	}
}