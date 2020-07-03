package cn.learn.basic.Demo34Main;
/*
如果接口的实现类(或者父类的子类)只需要使用唯一的一次
那么这种情况下就可以省略掉该类的定义，改为【匿名内部类】

匿名内部类的定义格式：
接口名称 对象名 = new 接口名称(){
    //覆盖重写所有抽象方法
};

对格式进行解析“new 接口名称() {...}”：
    1、new代表创建对象的动作
    2、接口名称就是匿名内部类需要实现哪个接口
    3、{...} 这才是匿名内部类的内容

注意：
    1、匿名内部类，在【创建对象】的时候，只能使用唯一一次。若希望多次创建对象，
       且类的内容一样的话，那么就必须使用单独定义的实现类了
    2、匿名对象，在【调用方法】的时候，只能唯一一次
        如果希望同一个对象，调用多次方法，那么必须给对象起个名字
    3、匿名内部类是省略了【实现类/子类名称】，但是匿名对象是省略了【对象名称】
    强调：匿名内部类和匿名对象不是一回事
*/


public class Demo03Main {

    public static void main(String[] args) {
        MyInterfaceimpl obj = new MyInterfaceimpl();
        obj.method();

        MyInterface some = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法！");
            }

            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！1111");
            }
        };
        some.method();
        some.method1();
        System.out.println("=================");

        //使用了匿名内部类，而且省略了对象名称，也是匿名对象
        new MyInterface(){
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法！A");
            }

            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法111！A");
            }
        }.method1();
    }

}
