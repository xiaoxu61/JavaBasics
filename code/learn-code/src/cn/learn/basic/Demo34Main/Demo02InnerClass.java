package cn.learn.basic.Demo34Main;
/*
如果一个实物的内部包含另一个事务，那么这就是一个类内部包含另一个类
例如：身体和心脏，汽车和发动机

分类：
1、成员内部类
    格式：
        修饰符 class 外部类名称 {
            修饰符 class 内部类名称 {
                //....
            }
         }
     注意：内用外，随意访问；外用内，一定需要借助内部类对象
==========================================================
     如何使用成员内部类：
        1、间接方式：在外部类的方法当中，使用内部类：然后main只是调用外部类的方法
        2、直接方式：公式：外部类名称.内部类名称 对象名  = new 外部类名称().new 内部名称
2、局部内部类（包含匿名内部类)
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

public class Demo02InnerClass {

    public static void main(String[] args) {
        Body body = new Body();
        //通过外部类的对象，调用外部类的方法，里面间接在使用内部类Heart
        body.methodBody();
        System.out.println("===================");

        //按照公式写
        Body.Heart heart = new Body().new Heart();
        heart.beat();
        System.out.println("=========================");

        Outer.Inner obj = new Outer().new Inner();
        obj.methodInner();
        System.out.println("================");

        Outer obj1 = new Outer();
        obj1.methodOuter();
    }

}
