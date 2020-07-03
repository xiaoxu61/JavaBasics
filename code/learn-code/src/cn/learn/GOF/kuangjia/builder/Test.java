package cn.learn.GOF.kuangjia.builder;
/*
    建造者模式
        建造者模式也属于创建型模式，它提供了一种创建对象的最佳方式
    定义：将一个复杂对象的构建与它的表示分离，是的同样的构建过程可以创建不同的表示
    主要作用：在用户不知道对象的建造过程和细节 的情况下就可以直接创建复杂的对象
    用户只需要给出指定复杂对象的类型和内容，建造者模式负责按顺序创建对象(把内部的建造过程和细节隐藏起来)
        例子：
            工厂（建造者模式） 负责制造汽车（组装过程和细节在工厂内）
            汽车购买者（用户） 只需说出你需要的型号（对象的类型和内容），然后直接购买就就可以使用了
                无需知道汽车时怎么组装的（车轮、车门等等）
        本示例中是Builder模式的常规用法，Director在Builder模式中具有很重要的作用，它用于指导具体构建者如何构建产品，控制调用先后次序
    并向调用者返回完整的产品类，有些特殊情况下，需要简化系统结构，可以把Director和抽象建造者进行结合

        通过静态内部类的方法实现零件无需装配构造，这种方式使用更加灵活，更符合定义。内部有复杂对象的默认实现，使用时可以根据用户需求自定义
    修改内容，并且无需改变具体的构造方式 就可以生产出不同复杂产品
*/

public class Test {
    public static void main(String[] args) {
        //指挥
        Director director = new Director();
        //指挥 具体的工人完成 产品
        Product build = director.build(new Worker());
        System.out.println(build);
    }
}
