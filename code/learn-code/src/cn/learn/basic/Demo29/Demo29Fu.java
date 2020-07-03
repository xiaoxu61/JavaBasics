package cn.learn.basic.Demo29;

public class Demo29Fu {
    int numFu = 10;

    int num = 100;

    public void methodFu() {
        //使用的是本类当中的，不会向下找子类的
        System.out.println(num);
        System.out.println("父类方法执行！");
    }

    public void method() {
        System.out.println("父类重名方法执行！");
    }

    public String method1() {
        return null;
    }

    public Demo29Fu() {
        System.out.println("父类无参构造");
    }

    public Demo29Fu(int num) {
        System.out.println("父类有参构造");
    }
}
