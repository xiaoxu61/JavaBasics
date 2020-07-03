package cn.learn.basic.Demo32Multi;
/*
如何才能知道一个父类引用的对象，本来是什么子类？
格式：
对象 instanceof 类名称
这将会的到一个boolean值，也就是判断前面的对象能不能当作后面类型的实例
*/

public class Demo02Instanceof {

    public static void main(String[] args) {
        Animal animal = new Dog();//本来是一只猫
        animal.eat();

        //希望向下转型，用到子类特有方法
        //判断一下父类引用animal本来是不是Dog
        if (animal instanceof Dog) {
            Dog dog = (Dog)animal;
            dog.watchHouse();
        }
        //判断一下animal本来是不是Cat
        if (animal instanceof Cat) {
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }
        System.out.println("=======================");
        giveMePet(new Dog());
    }

    public static void giveMePet(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog)animal;
            dog.watchHouse();
        }
        //判断一下animal本来是不是Cat
        if (animal instanceof Cat) {
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }
    }

}
