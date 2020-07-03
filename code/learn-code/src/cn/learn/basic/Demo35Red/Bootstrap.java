package cn.learn.basic.Demo35Red;
/*
场景说明：
    红包发出去之后，所有人都有红包，大家抢完后，最后一个红包给群主自己，
大多数代码都是现成的，我们需要做的就是填空题

红包分发策略：
        1、普通红包（平均）:toltalMoney/toltalCount，余数放在最后一个红包当中
        2、手气红包（随机)：最少一分钱，最多不超过平均数的2倍，应该越发越少
*/

import java.util.ArrayList;

public class Bootstrap {

    public static void main(String[] args) {
        People one = new People("群主",100);
        People two = new People("成员1",0);
        People three = new People("成员2",0);
        People four = new People("成员3",0);

        display(one, two, three, four);
        /*System.out.println("======================");
        ArrayList<Integer> redList = one.divideMoney(1, 20, 4);
        System.out.println(redList);
        one.receiveMoney(redList);
        two.receiveMoney(redList);
        three.receiveMoney(redList);
        four.receiveMoney(redList);
        display(one, two, three, four);
        System.out.println("=========================");*/

        ArrayList<Integer> redRandom = one.divideMoney(2, 20, 4);
        System.out.println(redRandom);
        one.receiveMoney(redRandom);
        two.receiveMoney(redRandom);
        three.receiveMoney(redRandom);
        four.receiveMoney(redRandom);
        display(one, two, three, four);

    }
    public static void display(People one, People two, People three, People four) {
        one.show();
        two.show();
        three.show();
        four.show();
    }
}
