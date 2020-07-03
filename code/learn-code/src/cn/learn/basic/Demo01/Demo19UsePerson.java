package cn.learn.basic.Demo01;
/*
构造方法是专门用来创建对象的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法
格式：
public 类名称（参数类型 参数名称）{
      方法体
}

注意事项：
1、构造方法的名称必须和所在的类名称完全一样，就连大小写也要一样
2、构造方法不要写返回类型，连void都不写
3、构造方法不能return一个具体的返回值
4、如果没有编写任何构造方法，那么编译器将会默认赠送一个构造方法，没有参数、方法体什么事情都做不了
5、一但编写了至少一个构造方法，则编译器将不再赠送
6、构造方法也是可以进行重载的
   重载：方法名称相同，参数列表不同
*/

public class Demo19UsePerson {
    public static void main(String[] args) {
        Demo19Person person = new Demo19Person();
        person.name = "江小鱼";
        person.sayHello("花无缺");

        person.name1 = "佩奇";
        person.SayHello("吹风机");

        System.out.println(person);
        System.out.println("==========================");
        Demo19Person stu1 = new Demo19Person();
        System.out.println("===========================");
        Demo19Person stu2 = new Demo19Person("赵飞飞",20);
        System.out.println("姓名：" + stu2.getName2() + "。年龄：" + stu2.getAge());
        //如果需要改变对象当中对的成员变量数据内容，仍然需要使用setXxx方法
        stu2.setAge(21);
        System.out.println("姓名：" + stu2.getName2() + "。年龄：" + stu2.getAge());

    }

}
