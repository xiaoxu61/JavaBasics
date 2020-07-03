package cn.learn.basic.Demo32Multi;

public class Zi extends Fu {

    int num = 20;
    int age = 16;

    @Override
    public void method() {
        System.out.println("子类的方法");
    }

    @Override
    public void showNum() {
        System.out.println(num);
    }

    public void methodZi() {
        System.out.println("子类的特有方法");
    }

}
