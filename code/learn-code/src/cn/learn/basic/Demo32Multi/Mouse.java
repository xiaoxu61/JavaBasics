package cn.learn.basic.Demo32Multi;
//������һ��USB�豸
public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("�����");
    }

    @Override
    public void close() {
        System.out.println("�ر����");
    }

    public void chick() {
        System.out.println("������");
    }
}
