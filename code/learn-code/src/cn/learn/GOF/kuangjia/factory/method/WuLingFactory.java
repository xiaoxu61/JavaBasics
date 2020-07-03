package cn.learn.GOF.kuangjia.factory.method;

public class WuLingFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
