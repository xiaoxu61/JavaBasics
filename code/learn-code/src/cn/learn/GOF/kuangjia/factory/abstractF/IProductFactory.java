package cn.learn.GOF.kuangjia.factory.abstractF;

//抽象的产品工厂
public interface IProductFactory {
    //生产手机
    IphoneProduct iPhoneProduct();

    //生产路由器
    IRouterProduct iRouterProduct();
}
