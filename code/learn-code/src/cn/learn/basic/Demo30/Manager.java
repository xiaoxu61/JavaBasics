package cn.learn.basic.Demo30;

import java.util.ArrayList;
//群主类
public class Manager extends User {

    public ArrayList<Integer> send(int totalMoney, int count) {

        //创建红包集合
        ArrayList<Integer> redList = new ArrayList<>();
        //获取当前余额
        int money = super.getBalance();
        //若发红包金额大于余额，显示余额不足
        if (totalMoney > money){
            System.out.println("余额不足");
            return redList;
        }

        //将发红包余额减掉
        super.setBalance(money - totalMoney);
        int avg = totalMoney / count;
        //将除不尽的余数加到最后一个红包里面
        int mod = totalMoney % count;

        for (int i = 0; i < count - 1; i++) {
            //把红包加进去
            redList.add(avg);
        }
        redList.add(avg + mod);
        return redList;
    }

    public Manager(String name, int balance) {
        super(name, balance);
    }

    public Manager() {
    }
}
