package cn.learn.GOF.kuangjia.factory.abstractF;

public class xiaomiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("����С��·����");
    }

    @Override
    public void shutdown() {
        System.out.println("�ر�С��·����");
    }

    @Override
    public void openWifi() {
        System.out.println("��С��·����WiFi");
    }

    @Override
    public void setting() {
        System.out.println("��С��·��������");
    }
}
