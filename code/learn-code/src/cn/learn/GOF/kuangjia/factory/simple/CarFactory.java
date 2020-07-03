package cn.learn.GOF.kuangjia.factory.simple;
//静态工厂模式
//不满足开闭原则
public class CarFactory {
    //方法一
    public static Car getCar(String car) {
        if (car.equals("五菱")) {
            return new WuLing();
        } else if (car.equals("Tesla")) {
            return new Tesla();
        }else {
            return null;
        }
    }

}
