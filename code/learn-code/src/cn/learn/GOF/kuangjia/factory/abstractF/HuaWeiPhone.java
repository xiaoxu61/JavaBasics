package cn.learn.GOF.kuangjia.factory.abstractF;

public class HuaWeiPhone implements IphoneProduct {
    @Override
    public void start() {
        System.out.println("������Ϊ�ֻ�");
    }

    @Override
    public void shutdown() {
        System.out.println("�رջ�Ϊ�ֻ�");
    }

    @Override
    public void callup() {
        System.out.println("��Ϊ�ֻ���绰");
    }

    @Override
    public void sendSMS() {
        System.out.println("��Ϊ�ֻ�������");
    }
}
