package cn.learn.basic.Demo01;
/*
ͨ������£�һ���ಢ����ֱ��ʹ�ã���Ҫ�����ഴ��һ�����󣬲���ʹ��
  1��������ָ����Ҫʹ�õ��࣬��ʲôλ��
     ��ʽ��import ������.�����ƣ�
     import cn.learn.basic.Demo01.Demo15Student
     ���ں͵�ǰ������ͬһ���������������ʡ�Ե�����䲻д
  2������
     ��ʽ�������� ������ = new ������()
     Student stu = new Student();
  3��ʹ��
     ʹ�ó�Ա������������.��Ա������
     ʹ�ó�Ա������������.��Ա��������������
     ��Ҳ��������˭�����ö�������˭��

*/

public class Demo15UseStudent {
    public static void main(String[] args) {
        //��ͬһĿ¼�����Բ��õ���
        //��ͬĿ¼�µİ�����󣬳�Ա������ζ��壿
        //����
        Demo15Student stu = new Demo15Student();
        //ʹ��
        System.out.println(stu.name);
        System.out.println(stu.age);

        //�ı�����еĳ�Ա����ֵ����
        stu.name = "���è";
        stu.age  = 18;
        System.out.println("===============");
        System.out.println("����:" + stu.name);
        System.out.println("����:" +stu.age);
        //ʹ�ö���ĳ�Ա����
        //������.��Ա����������
        stu.eat("��״����");
        stu.sleep(5);
        stu.study();
    }
}
