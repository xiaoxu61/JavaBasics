package cn.learn.GOF.kuangjia.factory.method;
/*
工厂模式的核心本质：
    实例化对象不使用new，用工厂方法替代
    将选择实现类，创建对象统一管理和控制，从而将调用者跟我们的实现类解耦
*/

public class Consumer {
    public static void main(String[] args) {
       Car car = new WuLingFactory().getCar();
       Car car1 = new TeslaFactory().getCar();
       Car car2 = new MoBaiFactory().getCar();

       car.name();
       car1.name();
       car2.name();
    }
    //结构复杂度 simple
    //代码复杂度 simple
    //编程复杂度 simple
    //管理复杂度 simple
    //根据设计原则，工厂方法模式
    //根据实际业务：简单工厂模式
}
