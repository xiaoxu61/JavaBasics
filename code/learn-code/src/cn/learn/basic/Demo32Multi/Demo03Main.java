package cn.learn.basic.Demo32Multi;
/*
向上转型一定是安全的，没有问题的，但是也有一定的弊端
   一旦向上转型为父类，那么就不发调用子类原本特有内容

解决方案：用对象向下转型【还原】
*/


public class Demo03Main {

    public static void main(String[] args) {
        //对象的向上转型，就是：父类引用指向子类对象
        Animal animal = new Cat();
        animal.eat();

        //向下转型还原动作
        Cat cat = (Cat)animal;
        cat.catchMouse();
        //错误的向下转型
        //本来new的时候是一只猫，现在非要当狗
        //错误写法！编译不会报错，但会运行异常；
        //java.lang.ClassCastException类转换异常
        Dog dog = (Dog)animal;
    }

}
