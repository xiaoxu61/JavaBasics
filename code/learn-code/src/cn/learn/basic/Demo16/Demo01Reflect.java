package cn.learn.basic.Demo16;
/*
    ��ȡһ�����class�ļ���������ַ�ʽ
        1�������ȡ
        2��������ȡ
        3��class��ȡ

      ���ַ�ʽ�õ��Ķ���Ψһ��
*/

public class Demo01Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.��ȡ����
        Person p = new Person();
        //����Person��ĸ��෽��getClass
        Class c= p.getClass();
        System.out.println(c);

        //2.������ȡ
        //ÿ�����ͣ��������������ã����ḳ���������һ����̬�����ԣ���������class
        Class c1 = Person.class;
        System.out.println(c1);

        System.out.println(c==c1);//true
        System.out.println(c.equals(c1));//true

        //3.Class��ľ�̬������ȡforName(�ַ���������)  ����.��������ʽ
        Class c2 = Class.forName("cn.learn.basic.Demo16.Person");
        System.out.println(c2);
    }
}
