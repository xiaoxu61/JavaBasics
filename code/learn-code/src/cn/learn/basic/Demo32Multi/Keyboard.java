package cn.learn.basic.Demo32Multi;
//������һ��USB�豸
public class Keyboard implements USB{
    @Override
    public void open() {
        System.out.println("�򿪼���");
    }

    @Override
    public void close() {
        System.out.println("�رռ���");
    }

    public void type() {
        System.out.println("�û�����");
    }
}
