package cn.learn.basic.Demo30;

import java.util.ArrayList;
//Ⱥ������
public class Leader extends User {

    public ArrayList<Integer> send(int totalMoney, int count) {
        //������Ҫһ�����ϣ������洢���ɺ���Ľ��
        ArrayList<Integer> redList = new ArrayList<>();

        //���ȿ�һ��Ⱥ���Լ��ж���Ǯ
        int leftMoney = super.getBalance();//Ⱥ����ǰ���
        if (totalMoney > leftMoney) {
            System.out.println("����");
            return redList;//���ؿռ���
        }

        //��Ǯ����ʵ���������������
        super.setBalance(leftMoney - totalMoney);

        //�������Ҫ��ֳ�Ϊcount��
        int avg = totalMoney / count;
        int mod = totalMoney % count;//������Ҳ�������µ���ͷ

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
