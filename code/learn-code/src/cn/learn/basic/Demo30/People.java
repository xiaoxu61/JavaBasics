package cn.learn.basic.Demo30;

import java.util.ArrayList;
import java.util.Random;

//��Ա����
public class People  extends User{

    public void receive(ArrayList<Integer> list) {
        //����õ������һ�����������ҽ�����Ľ��ӵ��Լ������
        int index = new Random().nextInt(list.size());
        //�õ���������Ǯ
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
