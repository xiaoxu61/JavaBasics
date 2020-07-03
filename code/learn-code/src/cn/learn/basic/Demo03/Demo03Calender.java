package cn.learn.basic.Demo03;
/*
java.util.Calender�ࣺ������
Calender��һ�������࣬�ṩ�˺ܶ���������ֶεķ�����YEAR��MONTH��DAY_OF_MONTH��HOUR ��
Calender���޷�ֱ��ʹ�ã�������һ����̬������getInstance(),�÷���������Calender����������
static Calender getInstance() ʹ��Ĭ��ʱ�������Ի������һ������

Calender�ೣ�õĳ�Ա������
    public int get(int field)�����ظ��������ֶε�ֵ
    public void set(int field, int value)���������������ֶ�����Ϊ����ֵ
    public abstract void add(int field, int amount)�����������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
    public Date getTime()������һ����ʾ��Calenderʱ��ֵ������Ԫ�����ڵĺ���ƫ��������Date����
��Ա�����Ĳ�����
    int field����������ֶΣ�����ʹ��Calender��ľ�̬��Ա������ȡ
        public static final int YEAR = 1; ��
        public static final int MONTH = 1; ��
        public static final int DATE = 1; ���е�ĳһ��
        public static final int DAY_OF_MONTH = 1; ���е�ĳһ��
        public static final int HOUR = 1; ʱ
        public static final int MINUTE = 1; ��
        public static final int SECOND = 1; ��
*/

import java.util.Calendar;
import java.util.Date;

public class Demo03Calender {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        demo01();
        System.out.println("===================");
        Demo02();
        System.out.println("====================");
        Demo03();
        System.out.println("====================");
        Demo04();
        System.out.println("=====================");
        Demo05();
    }

    private static void Demo05() {
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();

        born.set(Calendar.YEAR, 2019);
        born.set(Calendar.MONTH, 01);
        born.set(Calendar.DATE, 14);

        int day = born.get(Calendar.DATE);
        int day1 = now.get(Calendar.DATE);
        System.out.println(day1-day);
    }

    /*
    public Date getTime()������һ����ʾ��Calenderʱ��ֵ������Ԫ�����ڵĺ���ƫ��������Date����
    ����������ת��Ϊ���ڶ���
    */
    private static void Demo04() {
        Calendar c = Calendar.getInstance();

        Date date = c.getTime();
        System.out.println(date);

    }

    /*
    public abstract void add(int field, int amount)�����������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
    ��ָ�����ֶ�����/����ָ����ֵ
    ������
        int field������ָ���������ֶ�
        int amount������/����ָ����ֵ���������ӣ���������
    */
    private static void Demo03() {
        //ʹ��getInstance������ȡCalender����
        Calendar c = Calendar.getInstance();

        //������������
        c.add(Calendar.YEAR, 2);
        //���·ݼ���������
        c.add(Calendar.MONTH, -3);


        int year =  c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//�������·�0~11�£�����1~12��

        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

    /*
    public void set(int field, int value)���������������ֶ�����Ϊ����ֵ
    ������
        int field������ָ���������ֶ�
        int value�������ֶ����õ�ֵ
    */
    private static void Demo02() {
        Calendar c = Calendar.getInstance();

        //������Ϊ9999��
        c.set(Calendar.YEAR, 9999);
        //������
        c.set(Calendar.MONTH, 9);
        //������
        c.set(Calendar.DATE, 9);
        //ͬʱ���������գ�����ʹ��set�ķ�������
        c.set(8888, 8, 8);

        int year =  c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//�������·�0~11�£�����1~12��

        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

    /*
    public int get(int field)�����ظ��������ֶε�ֵ
    ����������ָ���������ֶΣ�YEAR��MONTH...��
    ����ֵ�������ֶδ���ľ����ֵ
    */
    private static void demo01() {
        //ʹ��getInstance������ȡCalender����
        Calendar c = Calendar.getInstance();
        int year =  c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//�������·�0~11�£�����1~12��

        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }
}
