package cn.learn.basic.Demo35Red;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> devide(final int toltalmoney, final int toltalcount) {

        ArrayList<Integer> list = new ArrayList<>();
        int leftMoney = toltalmoney*100;
        int leftCount = toltalcount;

        int avg = leftMoney / leftCount;
        int mod = leftMoney % leftCount;

        for (int i = 0; i < toltalcount -1; i++) {
            list.add(avg);
        }
        list.add(avg + mod);
        return list;
    }
}
