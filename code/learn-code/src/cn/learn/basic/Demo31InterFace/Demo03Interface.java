package cn.learn.basic.Demo31InterFace;

public class Demo03Interface {

    public static void main(String[] args) {
        MyInterfaceStatic impl = new MyInterfaceStaticImpl();

        //����д��������ͨ���ӿ�ʵ����Ķ��������ýӿڵ��еľ�̬����
//        impl.methodStatic();
        //��ȷ�÷����ӿ�����.��̬������(����)
        MyInterfaceStatic.methodStatic();
    }

}
