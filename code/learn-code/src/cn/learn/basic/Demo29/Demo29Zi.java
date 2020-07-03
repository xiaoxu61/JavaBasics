package cn.learn.basic.Demo29;
/*
super关键字用来访问父类内容，而this关键字用来访问本类内容
super关键字的用法有三种：
1、在子类成员方法中，访问父类的成员变量
2、在子类成员方法中，访问父类的成员方法
3、在子类的构造方法中，访问父类的构造方法

this关键字的用法：
1、在本类的成员方法中，访问本类的成员变量
2、在本类的成员方法中，访问本类的另一个成员方法
3、在本来的构造方法中，访问本类的另一个构造方法
   this(...)调用也必须是构造方法的第一个语句，唯一一个
   super和this两种构造调用，不能同时使用
*/

public class Demo29Zi extends Demo29Fu {
    int numZi = 20;

    int num = 200;

    public void methodZi() {
        //因为本类当中有num，所以这里用的是本类的num
        System.out.println(num);
        System.out.println(numFu);
        System.out.println("子类方法执行！");
    }

    public void method() {
        int num = 30;
        System.out.println("局部变量" + num);
        System.out.println("子类的成员变量" + this.num);
        System.out.println("父类的成员变量" + super.num);
        System.out.println("子类重名方法执行");
    }

    @Override
    public String method1() {
        return null;
    }

    public Demo29Zi() {
//        super();//在调用父类无参构造方法
        super(15);//在调用父类重载的构造方法
        System.out.println("子类构造方法");
    }
}
