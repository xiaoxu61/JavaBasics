package cn.learn.basic.Demo06;
/*
JDK 1.5 �µ����ԣ������Ŀɱ����
    ǰ�᣺��������������ȷ���������ĸ�������
    ��ʽ����������...������
    �ɱ�������ʾ�������
*/

public class Demo02Vrguments {
    public static void main(String[] args) {
        System.out.println(demo01());
        System.out.println(demo01(1,2, 6,7));

        demo02(1, 2, 5, 5, 5, 6);
    }
    /*
        �ɱ������ע�����
            1��һ�������У��ɱ����ֻ����һ��
            2���ɱ��������д�ڲ����б�����һλ
    */
    private static void demo02(int a, int b, int...c) {

    }

    /*
        ���巽��������X��������
        �����Ŀɱ����
    */
    private static int demo01(int...a) {
        int sum = 0;
        for(int i : a) {
            sum = sum + i;
        }
        return sum;
    }
}
