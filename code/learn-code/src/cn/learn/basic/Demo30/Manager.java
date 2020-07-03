package cn.learn.basic.Demo30;

import java.util.ArrayList;
//Ⱥ����
public class Manager extends User {

    public ArrayList<Integer> send(int totalMoney, int count) {

        //�����������
        ArrayList<Integer> redList = new ArrayList<>();
        //��ȡ��ǰ���
        int money = super.getBalance();
        //�����������������ʾ����
        if (totalMoney > money){
            System.out.println("����");
            return redList;
        }

        //�������������
        super.setBalance(money - totalMoney);
        int avg = totalMoney / count;
        //���������������ӵ����һ���������
        int mod = totalMoney % count;

        for (int i = 0; i < count - 1; i++) {
            //�Ѻ���ӽ�ȥ
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
