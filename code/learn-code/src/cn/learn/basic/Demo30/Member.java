package cn.learn.basic.Demo30;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {

    public void recive(ArrayList<Integer> list) {
        //�Ӷ������У������ȡһ�������Լ�
        //�����ȡһ�����ϵ����������
        int index  = new Random().nextInt(list.size());
        //�����������Ӽ�������ɾ�������ҵõ���ɾ���ĺ���������Լ�
        int delta = list.remove(index);
        //��ǰ��Ա�����ж���Ǯ
        int money = super.getBalance();
        //�ӷ��������û�ȥ
        super.setBalance(delta + money);

    }

    public Member(String name, int balance) {
        super(name, balance);
    }

    public Member() {
    }
}
