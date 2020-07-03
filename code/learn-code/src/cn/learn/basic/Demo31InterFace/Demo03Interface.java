package cn.learn.basic.Demo31InterFace;

public class Demo03Interface {

    public static void main(String[] args) {
        MyInterfaceStatic impl = new MyInterfaceStaticImpl();

        //错误写法！不能通过接口实现类的对象来调用接口当中的静态方法
//        impl.methodStatic();
        //正确用法：接口名称.静态方法名(参数)
        MyInterfaceStatic.methodStatic();
    }

}
