package cn.learn.GOF.kuangjia.factory.abstractF;

public class XiaoMiFactory implements IProductFactory {
    @Override
    public IphoneProduct iPhoneProduct() {
        return new xiaomiPhone();
    }

    @Override
    public IRouterProduct iRouterProduct() {
        return new xiaomiRouter();
    }
}
