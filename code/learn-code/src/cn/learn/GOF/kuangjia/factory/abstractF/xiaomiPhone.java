package cn.learn.GOF.kuangjia.factory.abstractF;

public class xiaomiPhone implements IphoneProduct {
    @Override
    public void start() {
        System.out.println("����С���ֻ�");
    }

    @Override
    public void shutdown() {
        System.out.println("�ر�С���ֻ�");
    }

    @Override
    public void callup() {
        System.out.println("С���ֻ���绰");
    }

    @Override
    public void sendSMS() {
        System.out.println("С���ֻ�������");
    }
}
