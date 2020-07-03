package cn.learn.basic.Demo03;
/*
java.text.DateFormat��DateFormat ������/ʱ���ʽ������ĳ�����
���ã���ʽ����Ҳ�������� -> �ı������������ı�-> ���ڣ�
��Ա������
    String format(Date date)������ָ��ģʽ����ʽ��Ϊ����ģʽ���ַ���
    Date parse(String source)���ѷ���ģʽ���ַ���������ΪDate����
DateFormat����һ�������࣬�޷�ֱ�Ӵ�������ʹ�ã�����ʹ��DateFormat�������

java.text.SimpleDateFormat extends DateFormat
���췽����
    SimpleDateFormat(String pattern)
        �ø���ģʽ��Ĭ�����Ի��������ڸ�ʽ�������SimpleDateFormat
    ������
        String pattern������ָ����ģʽ
    ģʽ�����ִ�Сдy  M  d  H  m  s
                   �� �� �� ʱ �� ��
          д�Զ�Ӧ��ģʽ�����ģʽ�滻Ϊ��Ӧ�����ں�ʱ��
          "yyyy-MM-dd HH:mm:ss"
          ע�⣺
            ģʽ�е���ĸ���ܸ��ģ�����ģʽ�ķ��ſ��Ըı�
            "yyyy��MM��dd�� HHʱmm��ss��"
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02DateFormat {

    public static void main(String[] args) throws ParseException {
        demo01();
        System.out.println("=====================");
        demo02();
    }

    /*
    ʹ��DateFoemat���еķ���parse�����ı�����Ϊ����
    ʹ�ò��裺
        1������SimpleDateFormat���󣬹��췽���д���ָ����ģʽ
        2������SimpleDateFormat�����е�parse���ѷ��Ϲ��췽����ģʽ���ַ���������ΪDate����
        ע�⣺
            parse����������һ���쳣��ParseException
            ���һ���ַ����͹��췽����ģʽ��һ������ô�ͻ��׳����쳣
            ����һ���׳����쳣�ķ������ͱ��봦������쳣��Ҫôthrows�����׳�����쳣��Ҫôtry catch�Լ�����
    */
    private static void demo02() throws ParseException {
        //����SimpleDateFormat���󣬹��췽���д���ָ����ģʽ
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2������SimpleDateFormat�����е�parse���ѷ��Ϲ��췽����ģʽ���ַ���������ΪDate����
        //Date parse(String source)���ѷ���ģʽ���ַ���������ΪDate����
        Date date =  sdf.parse("2020-02-11 11:18:04");
        System.out.println(date);
    }

    /*
    ʹ��DateFormat���еķ���format�������ڸ�ʽ��Ϊ�ı�
    ʹ�ò��裺
            1������SimpleDateFormat���󣬹��췽���д���ָ����ģʽ
            2������SimpleDateFormat�����е�format�����չ��췽����ָ����ģʽ����Date���ڸ�ʽ��Ϊ����ģʽ���ַ���
    */
    private static void demo01() {
        //����SimpleDateFormat���󣬹��췽���д���ָ����ģʽ
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //����SimpleDateFormat�����еķ���format�����չ��췽����ָ����ģʽ����Date����ת��Ϊ����ģʽ���ַ������ı���
        //String format(Date date) ����ָ����ģʽ����Date���ڣ���ʽ��Ϊ����ģʽ���ַ���
        Date date = new Date();
        String d = sdf.format(date);
        System.out.println(date);
        System.out.println(d);
    }
}
