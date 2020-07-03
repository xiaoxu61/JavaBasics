package cn.learn.basic.Demo03;
/*
    ������˶�����
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo03DateTest {
    public static void main(String[] args) throws ParseException {
        demo01();
        demo02();
    }
    /*
        �������
        �������õ�ָ����ݵ�3��1�գ�add��ǰƫ��һ�죬��ȡ������29����
    */
    private static void demo02() {
        Calendar c = Calendar.getInstance();
        //������������ָ�������3��1��
        c.set(3000, 2, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }

    private static void demo01() throws ParseException {
        System.out.println("��������ĳ�������yyyy-MM-dd");
        //��ȡ��������
        String dayString = new Scanner(System.in).next();
        //���ַ�������תΪDate����
        //����SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dayString);

        //��ȡ�������ڶ���
        Date today = new Date();
        //��������תΪ����ֵ
        long born = date.getTime();
        long now = today.getTime();
        long second = now - born;
        if (second <= 0){
            System.out.println("�㻹û������");
        }else {
            System.out.println(second / 1000 / 60 / 60 / 24);
        }
    }
}
