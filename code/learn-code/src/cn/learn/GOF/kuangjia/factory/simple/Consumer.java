package cn.learn.GOF.kuangjia.factory.simple;
/*
工厂模式的核心本质：
    实例化对象不使用new，用工厂方法替代
    将选择实现类，创建对象统一管理和控制，从而将调用者跟我们的实现类解耦
*/

public class Consumer {
    public static void main(String[] args) {
       /* //1、接口，所有的实现类
        Car car = new WuLing();
        Car car1 = new Tesla();*/
        //2、使用工厂创建
        Car car = CarFactory.getCar("五菱");
        Car car1 = CarFactory.getCar("Tesla");

        car.name();
        car1.name();
    }
}
