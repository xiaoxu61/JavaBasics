package cn.learn.basic.Demo34Main;
/*
����ӿڵ�ʵ����(���߸��������)ֻ��Ҫʹ��Ψһ��һ��
��ô��������¾Ϳ���ʡ�Ե�����Ķ��壬��Ϊ�������ڲ��ࡿ

�����ڲ���Ķ����ʽ��
�ӿ����� ������ = new �ӿ�����(){
    //������д���г��󷽷�
};

�Ը�ʽ���н�����new �ӿ�����() {...}����
    1��new����������Ķ���
    2���ӿ����ƾ��������ڲ�����Ҫʵ���ĸ��ӿ�
    3��{...} ����������ڲ��������

ע�⣺
    1�������ڲ��࣬�ڡ��������󡿵�ʱ��ֻ��ʹ��Ψһһ�Ρ���ϣ����δ�������
       ���������һ���Ļ�����ô�ͱ���ʹ�õ��������ʵ������
    2�����������ڡ����÷�������ʱ��ֻ��Ψһһ��
        ���ϣ��ͬһ�����󣬵��ö�η�������ô����������������
    3�������ڲ�����ʡ���ˡ�ʵ����/�������ơ�����������������ʡ���ˡ��������ơ�
    ǿ���������ڲ��������������һ����
*/


public class Demo03Main {

    public static void main(String[] args) {
        MyInterfaceimpl obj = new MyInterfaceimpl();
        obj.method();

        MyInterface some = new MyInterface() {
            @Override
            public void method() {
                System.out.println("�����ڲ���ʵ���˷�����");
            }

            @Override
            public void method1() {
                System.out.println("�����ڲ���ʵ���˷�����1111");
            }
        };
        some.method();
        some.method1();
        System.out.println("=================");

        //ʹ���������ڲ��࣬����ʡ���˶������ƣ�Ҳ����������
        new MyInterface(){
            @Override
            public void method() {
                System.out.println("�����ڲ���ʵ���˷�����A");
            }

            @Override
            public void method1() {
                System.out.println("�����ڲ���ʵ���˷���111��A");
            }
        }.method1();
    }

}
