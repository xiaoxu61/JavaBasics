package cn.learn.basic.Demo29;
/*
局部变量：       直接写
本类的成员变量：this.成员变量名
父类的成员变量：super.成员变量名

在父子类的继承关系当中，创建子类对象，访问成员的方法规则：
   创建的对象是谁，就优先用谁，如果没有则向上找

注意事项：
   无论是成员方法还是成员变量，如果没有都是向上找父类，绝不会向下找子类的

重写（Override）
概念：在继承关系当中，方法的名称一样，参数列表也一样

重写（Override）：方法的名称一样，参数列表【也一样】，覆盖、覆写
重载（Overload）：方法的名称一样，参数列表【不一样】

方法的覆盖重写特点，创建的是子类对象，优先用子类方法
    注意事项：
            1、必须保证父子类之间的方法名称相同,参数列表也相同
               @Override：写在方法前面，用来检测是不是有效的正确覆盖重写，不是的话它会报错
               这个注解就算不写，只要满足要求，也是正确的方法覆盖重写
            2、子类方法的返回值必须【小于等于】父类方法的返回值范围
            扩展提示：java.lang.Object类是所有类的公共最高父类：java.lang.String就是Object的子类
            3、子类方法的权限必须【大于等于】父类方法的权限修饰符
            小扩展提示：public > protected > (default) > private
               备注：（default）不是关键字default，而是什么都不写，留空

*/

public class Demo29ExtendsField {

    public static void main(String[] args) {
        Demo29Zi zi = new Demo29Zi();

        zi.method();
        zi.methodFu();
        zi.methodZi();

        zi.method();
        System.out.println("===============");
        /*
        继承关系中，父类构造方法访问的特点：
            1、子类构造方法当中有一个默认隐含的super()调用，所以一定是先调用的父类构造，后执行的子类构造
            2、子类构造可以通过super关键字来调用父类重载构造
            3、super的父类构造调用，必须是子类构造方法的第一个语句，不能一个构造调用多次super构造。
        总结：
            子类必须调用父类构造方法，不写则赠送super();写了则用写的指定super调用，super只能有一个，还必须是第一个
        */

        Demo29Zi zi1 = new Demo29Zi();
    }
}
