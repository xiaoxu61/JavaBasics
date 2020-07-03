package cn.learn.basic.Demo30;

import java.util.ArrayList;
//群主的类
public class Leader extends User {

    public ArrayList<Integer> send(int totalMoney, int count) {
        //首先需要一个集合，用来存储若干红包的金额
        ArrayList<Integer> redList = new ArrayList<>();

        //首先看一下群主自己有多少钱
        int leftMoney = super.getBalance();//群主当前余额
        if (totalMoney > leftMoney) {
            System.out.println("余额不足");
            return redList;//返回空集合
        }

        //扣钱，其实就是重新设置余额
        super.setBalance(leftMoney - totalMoney);

        //发红包需要拆分成为count个
        int avg = totalMoney / count;
        int mod = totalMoney % count;//余数，也就是用下的零头

        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        int last = avg + mod;
        redList.add(last);

        return redList;

    }

    public Leader() {
    }

    public Leader(String name, int balance) {
        super(name, balance);
    }

}
