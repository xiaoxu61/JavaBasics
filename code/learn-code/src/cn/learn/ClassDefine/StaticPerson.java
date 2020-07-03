package cn.learn.ClassDefine;

public class StaticPerson {
    static {
        System.out.println("静态代码块执行！");
    }
    public StaticPerson(){
        System.out.println("构造方法执行！");
    }
}
