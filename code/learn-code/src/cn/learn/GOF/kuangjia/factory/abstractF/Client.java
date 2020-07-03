package cn.learn.GOF.kuangjia.factory.abstractF;

public class Client {
    public static void main(String[] args) {
        System.out.println("==========小米系列产品===========");
        //小米工厂
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();

        IphoneProduct iphoneProduct = xiaoMiFactory.iPhoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();

        IRouterProduct iRouterProduct = xiaoMiFactory.iRouterProduct();
        iRouterProduct.start();
        iRouterProduct.openWifi();

        System.out.println("==========小米系列产品===========");

        HuaWeiFactory huaWeiFactory = new HuaWeiFactory();
        iphoneProduct = huaWeiFactory.iPhoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();

        iRouterProduct = huaWeiFactory.iRouterProduct();
        iRouterProduct.start();
        iRouterProduct.openWifi();
    }
}
