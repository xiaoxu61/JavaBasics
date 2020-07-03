package cn.learn.basic.Demo30;

public class DemoMain {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        System.out.println("===================");
        Zi zi = new Zi();
        zi.eat();
        System.out.println("================");

        Dog2Ha ha = new Dog2Ha();
        ha.eat();
        ha.sleep();
        System.out.println("=================");

        DogGolden golden = new DogGolden();
        golden.eat();
        golden.sleep();

    }

}
