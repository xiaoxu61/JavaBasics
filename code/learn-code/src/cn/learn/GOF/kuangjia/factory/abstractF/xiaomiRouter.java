package cn.learn.GOF.kuangjia.factory.abstractF;

public class xiaomiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("启动小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("打开小米路由器WiFi");
    }

    @Override
    public void setting() {
        System.out.println("打开小米路由器设置");
    }
}
