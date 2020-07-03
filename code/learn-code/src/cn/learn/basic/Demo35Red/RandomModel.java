package cn.learn.basic.Demo35Red;

import java.util.ArrayList;
import java.util.Random;

public class RandomModel implements OpenMode {
    @Override
    public ArrayList<Integer> devide(final int toltalmoney, final int toltalcount) {
        ArrayList<Integer> list = new ArrayList<>();
        //将元变为分
        int leftMoney = toltalmoney*100;
        int leftCount = toltalcount;
        //金额随机分配，有可能多，有可能少
        //最少一分钱，最多不超过 剩下金额平均数的两倍
        for (int i = 0; i < toltalcount - 1; i++) {
            int money = new Random().nextInt(leftMoney / leftCount * 2) + 1;
            list.add(money);
            leftMoney -= money;
            leftCount--;
        }
        //将剩下的金额塞进最后一个红包
        list.add(leftMoney);
        return list;
    }
}
