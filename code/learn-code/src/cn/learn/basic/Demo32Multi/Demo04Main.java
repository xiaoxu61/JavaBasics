package cn.learn.basic.Demo32Multi;

public class Demo04Main {

    public static void main(String[] args) {
        //首先创建一个笔记本电脑
        Computer computer = new Computer();
        computer.powerOn();

        //准备一个鼠标，供电脑使用
        //先向上转型
        USB usb = new Mouse();//多态写法
        //参数是USB类型，我正好传递进去的就是USB鼠标
        computer.usbDevice(usb);
        //创建一个键盘
        Keyboard keyboard = new Keyboard();
        //方法参数就是USB类型，传递进去的是实现类对象
        computer.usbDevice(keyboard);//正确写法，也发生了向上转型
//        computer.usbDevice(new Keyboard());//正确写法，也发生了向上转型

        computer.powerOf();

        method(10.0);//正确写法：double ---> double
        method(10);//正确写法：int ---> double

    }

    public static void method(double num) {
        System.out.println(num);
    }

}
