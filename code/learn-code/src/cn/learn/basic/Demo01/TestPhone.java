package cn.learn.basic.Demo01;

/*
  ���ԣ��ն���õ�Phone��
  �����������ͱ����ĸ�ʽ
    �������� ������ = new ��������();
	
   ʵ���������͵Ĳ���
      1����������඼����ͬһ���ļ��У�����Ҫ�����
	  2�������������͵ı���
	  3������.�����еĹ���
*/
public class TestPhone{
	public static void main(String[] args){
	    //2�������������͵ı���
	    Phone p = new Phone();
	    //System.out.println(p); ����ڴ�ĵ�ַ
	
	    //3������.�����еĹ���
	    //���� p.�ķ�ʽ���������е�����
	    //���Ծ��Ǳ�������ֵ�ͻ�ȡֵ
	    p.color = "������";
	    p.brand = "������";
	    p.size  = 15.0;
	
	    //��ȡ����ֵ
	    System.out.println(p.color+"  "+p.brand+"   "+p.size);
        
        //�����緹����������
        DianFanGuo dfg = new DianFanGuo();

        dfg.brand = "��˹��";
        dfg.color = "��ɫ";
        dfg.size = 10.5;		
	    System.out.println(dfg.color+"  "+dfg.brand+"   "+dfg.size);
	
	}
}