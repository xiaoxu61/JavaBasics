package cn.learn.basic.Demo31InterFace;

public class MyInterfaceDefaultA implements MyInterfaceDefault {
    @Override
    public void methodAbs() {
        System.out.println("实现了抽象方法，AAA");
    }

    @Override
    public void methodDefault() {
        System.out.println("实现类A覆盖重写了接口的默认方法");
    }
}
