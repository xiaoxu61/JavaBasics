package cn.learn.basic.Demo32Multi;
/*
����ת��һ���ǰ�ȫ�ģ�û������ģ�����Ҳ��һ���ı׶�
   һ������ת��Ϊ���࣬��ô�Ͳ�����������ԭ����������

����������ö�������ת�͡���ԭ��
*/


public class Demo03Main {

    public static void main(String[] args) {
        //���������ת�ͣ����ǣ���������ָ���������
        Animal animal = new Cat();
        animal.eat();

        //����ת�ͻ�ԭ����
        Cat cat = (Cat)animal;
        cat.catchMouse();
        //���������ת��
        //����new��ʱ����һֻè�����ڷ�Ҫ����
        //����д�������벻�ᱨ�����������쳣��
        //java.lang.ClassCastException��ת���쳣
        Dog dog = (Dog)animal;
    }

}
