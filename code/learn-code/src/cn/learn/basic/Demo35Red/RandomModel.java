package cn.learn.basic.Demo35Red;

import java.util.ArrayList;
import java.util.Random;

public class RandomModel implements OpenMode {
    @Override
    public ArrayList<Integer> devide(final int toltalmoney, final int toltalcount) {
        ArrayList<Integer> list = new ArrayList<>();
        //��Ԫ��Ϊ��
        int leftMoney = toltalmoney*100;
        int leftCount = toltalcount;
        //���������䣬�п��ܶ࣬�п�����
        //����һ��Ǯ����಻���� ʣ�½��ƽ����������
        for (int i = 0; i < toltalcount - 1; i++) {
            int money = new Random().nextInt(leftMoney / leftCount * 2) + 1;
            list.add(money);
            leftMoney -= money;
            leftCount--;
        }
        //��ʣ�µĽ���������һ�����
        list.add(leftMoney);
        return list;
    }
}
