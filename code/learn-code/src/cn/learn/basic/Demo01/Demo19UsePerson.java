package cn.learn.basic.Demo01;
/*
���췽����ר��������������ķ�����������ͨ���ؼ���new����������ʱ����ʵ�����ڵ��ù��췽��
��ʽ��
public �����ƣ��������� �������ƣ�{
      ������
}

ע�����
1�����췽�������Ʊ�������ڵ���������ȫһ����������СдҲҪһ��
2�����췽����Ҫд�������ͣ���void����д
3�����췽������returnһ������ķ���ֵ
4�����û�б�д�κι��췽������ô����������Ĭ������һ�����췽����û�в�����������ʲô���鶼������
5��һ����д������һ�����췽���������������������
6�����췽��Ҳ�ǿ��Խ������ص�
   ���أ�����������ͬ�������б�ͬ
*/

public class Demo19UsePerson {
    public static void main(String[] args) {
        Demo19Person person = new Demo19Person();
        person.name = "��С��";
        person.sayHello("����ȱ");

        person.name1 = "����";
        person.SayHello("�����");

        System.out.println(person);
        System.out.println("==========================");
        Demo19Person stu1 = new Demo19Person();
        System.out.println("===========================");
        Demo19Person stu2 = new Demo19Person("�Էɷ�",20);
        System.out.println("������" + stu2.getName2() + "�����䣺" + stu2.getAge());
        //�����Ҫ�ı�����жԵĳ�Ա�����������ݣ���Ȼ��Ҫʹ��setXxx����
        stu2.setAge(21);
        System.out.println("������" + stu2.getName2() + "�����䣺" + stu2.getAge());

    }

}
