package cn.learn.basic.Demo34Main;
/*
如果出现了重名现象，那么格式是：外部类名称.this.外部类成员变量名

如果一个类是定义在一个方法内部，那么这就是一个局部内部类
局部，只有当前所属的方法才能使用它，出了这个方法外面就不能用了

定义格式：
修饰符 class 外部类名称{
    修饰符 返回值类型 外部类方法名称(参数列表) {
        class 局部内部类名称 {
            //...
         }
     }
}
小节一下类的权限修饰符：
    public > protect > (default) > private
定义一个类的时候，权限修饰规则
    1、外部类：public/（defaul）
    2、成员内部类：public/protect/（default）/private
    3、局部内部类：什么都不能写
*/

public class Outer {

    int num = 10;//外部类的成员变量

    public class Inner {
        int num = 20;//内部类的成员变量

        public void methodInner() {
            int num = 30;//内部类的局部变量
            System.out.println(num);//局部变量，就近原则
            System.out.println(this.num);//内部类的成员变量
            System.out.println(Outer.this.num);//外部类的成员变量
        }

    }
    public  void methodOuter() {
        class Inner{//局部内部类
            int num = 10;
            public void methodInner() {
                System.out.println(num);//10
            }
        }
        Inner inner = new Inner();
        inner.methodInner();
    }
}
