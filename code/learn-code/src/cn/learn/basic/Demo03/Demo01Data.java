package cn.learn.basic.Demo03;
/*
    java.util.Data����ʾ���ں�ʱ�����
    �� Date ��ʾ�ض���˲�䣬��ȷ�����롣
    ���룺ǧ��֮һ��
    �ض�˲�䣺һ��ʱ��㣬һɲʱ��

    ����ֵ�����ã����Զ�ʱ������ڽ��м���
    2099-01-03��2088-01-01�м乲�ж�����
    ��������ת��Ϊ������м��㣬�Ѻ���ת��Ϊ����

    �ѵ�ǰ����ת��Ϊ���룺
        ��ǰ����2088-01-01
        ʱ��ԭ�㣺1970 �� 1 �� 1 �� 00:00:00��Ӣ����������ʱ�䣩
        ���Ǽ��㵱ǰ���ڵ�ʱ��ԭ��֮��һ�������˶��ٺ��룬1581303961895
    �Ѻ���ת��Ϊ���ڣ�
        1 �� = 24 �� 60 �� 60 = 86400 �� = 86400 * 1000 ����
    ע�⣺
        �й����ڶ����������ʱ�����Ӱ˸�Сʱ1970 �� 1 �� 1 �� 08:00:00
*/
import java.util.Date;
public class Demo01Data {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//��ȡ��ǰϵͳʱ��һ����1970 �� 1 �� 1 �� 00:00:00�����˶��ٺ���
        demo01();
        demo02();
        demo03();
        System.out.println("=========");
        demo04();
    }
    /*
        Date�෽��setTime(long)���ݺ���ֵ
        �����ڶ������õ�ָ������ֵ��
        ����ֵת�����ڶ���
    */
    private static void demo04() {
        Date date = new Date();
        System.out.println(date);
        date.setTime(0);
        System.out.println(date);
    }

    /*
        long getTime()������ת��Ϊ����
        ������1970 �� 1 �� 1 �� 00:00:00 GMT �Դ�����Data�����ʾ�ĺ���
    */
    private static void demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);

    }
    /*
        Data����������췽��
        Data(lang data)�����ݺ���ֵ���Ѻ���ֵת��ΪData����
    */
    private static void demo02() {
        Date date = new Date(0L);
        System.out.println(date);

        date = new Date(1581303961895L);
        System.out.println(date);
    }
    /*
    Data��Ŀղ������췽��
    Data()��ȡ��ǰϵͳ��ʱ�������
    */
    private static void demo01() {
        Date date = new Date();
        System.out.println(date);
    }

}
