package cn.learn.basic.Demo35Red;

import java.util.ArrayList;

public interface OpenMode {
    /*
    ��toltalmoney�ֳ�count�ݣ����浽ArrayList<Integer>�У����ؼ���
    @param toltalmoney              �ܽ��Ϊ���㷽�㣬�Ѿ�ת��Ϊ��������λΪ��
    @param toltalcount              �������
    @return ArrayList<Integer>      Ԫ��Ϊ��������Ľ��ֵ������Ԫ�ص�ֵ�ۺ͵����ܽ��
    */

    public abstract ArrayList<Integer> devide(int toltalmoney, int toltalcount);
}
