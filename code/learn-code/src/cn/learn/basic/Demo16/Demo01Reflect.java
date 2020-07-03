package cn.learn.basic.Demo16;
/*
    获取一个类的class文件对象的三种方式
        1、对象获取
        2、类名获取
        3、class获取

      三种方式拿到的都是唯一的
*/

public class Demo01Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.获取对象
        Person p = new Person();
        //调用Person类的父类方法getClass
        Class c= p.getClass();
        System.out.println(c);

        //2.类名获取
        //每个类型，包括基本和引用，都会赋予这个类型一个静态的属性，属性名字class
        Class c1 = Person.class;
        System.out.println(c1);

        System.out.println(c==c1);//true
        System.out.println(c.equals(c1));//true

        //3.Class类的静态方法获取forName(字符串的类名)  包名.类名的形式
        Class c2 = Class.forName("cn.learn.basic.Demo16.Person");
        System.out.println(c2);
    }
}
