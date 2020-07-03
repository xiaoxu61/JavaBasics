package cn.learn.basic.Demo30;

import java.util.ArrayList;
import java.util.Random;

//成员的类
public class People  extends User{

    public void receive(ArrayList<Integer> list) {
        //随机得到红包的一个索引，并且将里面的金额加到自己的余额
        int index = new Random().nextInt(list.size());
        //拿到红包里面的钱
        int detal = list.remove(index);

        int money = super.getBalance();
        super.setBalance(detal + money);
    }

    public People(String name, int balance) {
        super(name, balance);
    }

    public People() {
    }
}
