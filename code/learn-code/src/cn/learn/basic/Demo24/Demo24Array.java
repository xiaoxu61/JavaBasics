package cn.learn.basic.Demo24;
/*
定义一个数组，用来存储3个Person对象

数组有一个缺点，一旦创建，程序运行区间长度不可以发生改变

*/

public class Demo24Array {
    public static void main(String[] args) {
        //首先创建一个数组，长度为3，里面用来存放person对象
        Demo24Person[] array = new Demo24Person[3];

        Demo24Person one = new Demo24Person("迪丽热巴",18);
        Demo24Person two = new Demo24Person("古力穷哈",20);
        Demo24Person three = new Demo24Person("马尔扎哈",1800);

        array[0] = one;
        array[1] = two;
        array[2] = three;
        System.out.println(array[0]);//地址值
        System.out.println(array[1]);//地址值
        System.out.println(array[2]);//地址值

        System.out.println(array[1].getName());
    }
}
