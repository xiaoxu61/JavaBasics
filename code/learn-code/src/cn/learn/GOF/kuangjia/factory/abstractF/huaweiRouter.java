package cn.learn.GOF.kuangjia.factory.abstractF;

public class huaweiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("������Ϊ·����");
    }

    @Override
    public void shutdown() {
        System.out.println("�رջ�Ϊ·����");
    }

    @Override
    public void openWifi() {
        System.out.println("�򿪻�Ϊ·����WiFi");
    }

    @Override
    public void setting() {
        System.out.println("�򿪻�Ϊ·��������");
    }
}
