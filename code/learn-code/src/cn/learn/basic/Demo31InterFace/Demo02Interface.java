package cn.learn.basic.Demo31InterFace;
/*
1���ӿڵ�Ĭ�Ϸ���������ͨ���ӿ�ʵ�������ֱ�ӵ���
2���ӿڵ�Ĭ�Ϸ�����Ҳ���Ա��ӿ�ʵ������и�����д
*/


public class Demo02Interface {

    public static void main(String[] args) {

        //����ʵ�������
        MyInterfaceDefaultA a = new MyInterfaceDefaultA();
        a.methodAbs();
        //ʹ��Ĭ�Ϸ��������ʵ���൱��û�У��������ҽӿ�
        a.methodDefault();//ʵ����A������д�˽ӿڵ�Ĭ�Ϸ���
        System.out.println("===================");

        MyInterfaceDefaultB b = new MyInterfaceDefaultB();
        b.methodAbs();
        b.methodDefault();//��������ӵ�Ĭ�Ϸ���

    }

}
