package cn.learn.GOF.kuangjia.factory.abstractF;

public class HuaWeiFactory implements IProductFactory {
    @Override
    public IphoneProduct iPhoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public IRouterProduct iRouterProduct() {
        return new huaweiRouter();
    }
}
