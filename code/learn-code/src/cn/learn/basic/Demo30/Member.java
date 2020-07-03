package cn.learn.basic.Demo30;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {

    public void recive(ArrayList<Integer> list) {
        //从多个红包中，随机抽取一个，给自己
        //随机获取一个集合当中索引编号
        int index  = new Random().nextInt(list.size());
        //根据索引，从几个当中删除，并且得到被删除的红包，给我自己
        int delta = list.remove(index);
        //当前成员本来有多少钱
        int money = super.getBalance();
        //加法并且设置回去
        super.setBalance(delta + money);

    }

    public Member(String name, int balance) {
        super(name, balance);
    }

    public Member() {
    }
}
