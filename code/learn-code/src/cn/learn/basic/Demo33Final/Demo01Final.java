package cn.learn.basic.Demo33Final;
/*
final �ؼ��ִ������ա����ɸı��

�����������÷���
    1��������������һ����
    2��������������һ������
    3����������������һ���ֲ�����
    4����������������һ����Ա����
*/

public class Demo01Final {

    public static void main(String[] args) {
        new MyClass().mathod();

        int num1 = 10;
        System.out.println(num1);
        num1 = 20;
        System.out.println(num1);

        final int num2 = 200;
        System.out.println(num2);
//        num2 = 300;//����д��

        //��ȷд����ֻҪ��֤��Ψһһ�θ�ֵ����
        final int num3;
        num3 = 30;

        //���ڻ���������˵�����ɱ�˵���Ǳ������е����ݲ��ɸı�
        //��������������˵�����ɱ�˵���Ǳ������еĵ�ֵַ���ɸı�
        Student stu1 = new Student("����ӱ");
        System.out.println(stu1);
        System.out.println(stu1.getName());
        stu1 = new Student("������");
        System.out.println(stu1);
        System.out.println(stu1.getName());
        System.out.println("=================");

        final Student stu2 = new Student("��ԲԲ");
        //����д����final���������ͱ��������еĵ�ֵַ���ɸı�
        //stu2 = new Student("����͢")
        System.out.println(stu2.getName());
        stu2.setName("��ԲԲԲԲ");
        System.out.println(stu2.getName());
    }

}
