package cn.learn.basic.Demo08IO;
/*
    �����Լ������Լ�
    �����ڣ���������������ⲻ�䣬�������е�ʱ�򣬲������еķ���������仯
    ע�⣺
        �ݹ�һ��Ҫ�г��ڣ���������ó���ͣ����
        �ݹ�������ܹ���
        ���췽������ֹ�ݹ�
*/

public class Demo06Digui {
    public static void main(String[] args) {
        System.out.println(getSum(100));
        System.out.println(getJieCheng(5));
        System.out.println(getFBNQ(12));
    }
    /*
        �����ĵݹ飬����쳲���������
    */
    public static int getFBNQ(int month) {
        if (month == 1)
            return 1;
        if (month ==2)
            return 1;
        return getFBNQ(month - 1) + getFBNQ(month -2);
    }
    /*
        ����׳�
            5*4*3*2*1
    */
    public static int getJieCheng(int n) {
        if (n == 1)
            return 1;
        return n*getJieCheng(n -1);
    }
    /*
        ����1�ӵ�100�ĺ�
        ������ɣ�
            n + (n-1) + (n -2) + ... + 1
    */
    public static int getSum(int n) {
        if (n == 1){
            return 1;
        }
        return n + getSum(n - 1);
    }
}
