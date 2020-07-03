package cn.learn.basic.Demo01;

public class Demo18UsePerson {
    public static void main(String[] args) {
        Demo18Person person = new Demo18Person();
        person.show();
        System.out.println("======================");

        person.setName("噢吼吼");
//        person.age = 20;//直接访问private内容，错误写法
        person.setAge(20);
        person.setMale(true);
        person.show();
        System.out.println("=============");
        System.out.println("姓名：" + person.getName());
        System.out.println("年龄：" + person.getAge());
        System.out.println("是否是爷们：" + person.isMale());

    }
}
