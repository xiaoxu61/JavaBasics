package cn.learn.basic.Demo01;
/*
  ����һ���࣬����ģ�⡰ѧ��������
  ���ԣ���ʲô��
     ����
     ����
  ��Ϊ������ʲô��
     �Է�
     ˯��
     ѧϰ
  ��Ӧ��Jave���൱�У�

  ��Ա������
     String name
     int age
  ��Ա����
     public void eat(){}
     public void sleep(){}
     public void study(){}

ע�����
   1����Ա������ֱ�Ӷ������൱�У��ڷ������
   2����Ա������Ҫд��static�ؼ���

*/

public class Demo15Student {
    //��Ա����
    String name; //����
    int age;     //����
    //��Ա����
    public void eat(String what){
        System.out.println("��"+ what);
    }
    public void sleep(int hour){
        System.out.println("һ��˯"+ hour + "Сʱ");
    }
    public void study(){
        System.out.println("Study");
    }

}
