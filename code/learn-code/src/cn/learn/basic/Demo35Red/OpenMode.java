package cn.learn.basic.Demo35Red;

import java.util.ArrayList;

public interface OpenMode {
    /*
    将toltalmoney分成count份，保存到ArrayList<Integer>中，返回即可
    @param toltalmoney              总金额为计算方便，已经转换为整数，单位为分
    @param toltalcount              红包个数
    @return ArrayList<Integer>      元素为各个红包的金额值，所有元素的值累和等于总金额
    */

    public abstract ArrayList<Integer> devide(int toltalmoney, int toltalcount);
}
