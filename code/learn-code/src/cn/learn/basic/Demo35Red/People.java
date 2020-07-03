package cn.learn.basic.Demo35Red;

import java.util.ArrayList;
import java.util.Random;

public class People extends User {
    public void receiveMoney(ArrayList<Integer> list){
        //����õ��������һ��
        int index = new Random().nextInt(list.size());
        //�õ������Ǯ
        double receive = list.remove(index);
        double detal = receive / 100;
        double money = super.getMoney();
        setMoney(money + detal);
    }

    public ArrayList<Integer> divideMoney(int Model, int toltalMoney, int toltalCount) {
        ArrayList<Integer> redList = new ArrayList<>();
        //�õ���ǰ���
        double money = getMoney();
        if (toltalMoney > money) {
            System.out.println("��ǰ���㣬���ط�");
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
