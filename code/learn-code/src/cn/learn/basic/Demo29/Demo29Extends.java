package cn.learn.basic.Demo29;
/*
在继承关系中，‘子类就是一个父类’，也就是说，子类可以被当作父亲看待
例如父亲是员工，子类是讲师，那么“讲师就是一个员工”，关系：is-a

定义父类的格式：（一个普通的类定义）
public class 父类名字{
    //...
}

定义子类的格式：
public class 子类名称 extends 父类名称 {
    //...
}

在子类的继承关系当中，如果成员变量重名，则创建子类对象时，访问有两种方式：
   直接通过子类对象访问成员变量：
       等号左边是谁，就优先用谁，没有则向上找
   间接通过成员方法访问成员变量:
        该方法属于谁，就优先用谁，没有则向上找


*/

public class Demo29Extends {
    public static void main(String[] args) {
        //创建一个子类对象
        Demo29Teacher teacher = new Demo29Teacher();
        //Teacher当中虽然什么都没写，但是会继承来自父类的method
        teacher.method();

        //创建一个子类助教的对象
        Demo29Assistant assistant = new Demo29Assistant();
        assistant.method();

        Demo29Fu fu = new Demo29Fu();//创建父类对象
        System.out.println(fu.numFu);//只能用父类的东西，没有任何子类内容

        Demo29Zi zi = new Demo29Zi();
        System.out.println(zi.numFu);
        System.out.println(zi.numZi);
        System.out.println("=================");

        //等号左边是谁，就优先用谁
        System.out.println(zi.num);//优先子类
//        System.out.println(zi.abc);//到处都没有，编译报错
        System.out.println("==================");
        zi.methodZi();//这个方法是子类的，优先用子类的，没有再向上找
        //这个方法是在父类当中定义的
        zi.methodFu();
    }
}
