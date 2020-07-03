package cn.learn.basic.Demo35Red;

import java.util.ArrayList;
import java.util.Random;

public class People extends User {
    public void receiveMoney(ArrayList<Integer> list){
        //随机得到红包当中一个
        int index = new Random().nextInt(list.size());
        //得到红包的钱
        double receive = list.remove(index);
        double detal = receive / 100;
        double money = super.getMoney();
        setMoney(money + detal);
    }

    public ArrayList<Integer> divideMoney(int Model, int toltalMoney, int toltalCount) {
        ArrayList<Integer> redList = new ArrayList<>();
        //得到当前余额
        double money = getMoney();
        if (toltalMoney > money) {
            System.out.println("当前余额不足，请重发");
            return redList;
        }
        if (Model == 1){
            redList = new NormalMode().devide(toltalMoney,toltalCount);
        }else if (Model == 2) {
            redList = new RandomModel().devide(toltalMoney,toltalCount);
        }
        setMoney(money - toltalMoney);
        return redList;
    }

    public People(String name, double money) {
        super(name, money);
    }

    public People() {
    }
}
