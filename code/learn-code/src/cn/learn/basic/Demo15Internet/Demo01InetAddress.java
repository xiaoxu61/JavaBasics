package cn.learn.basic.Demo15Internet;
/*
    ��ʾ�������е�IP��ַ
        java.net.InetAddress
    ��̬������
        static InetAddress getLocalHost() LocalHost��������
        ���ر�������������ֵInetAddress

        static InetAddress getByName(String hostName) ��������������ȡIP��ַ����

    �Ǿ�̬������
        String getHoustAddress() ��ȡ����IP��ַ
        String getHoustName()    ��ȡ������
*/

import java.net.InetAddress;
import java.net.UnknownHostException;



public class Demo01InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        function_1();
    }

    private static void function_1() throws UnknownHostException {
        InetAddress inet = InetAddress.getByName("DESKTOP-HR7GET6");
        System.out.println(inet);
    }

    public static void function() throws UnknownHostException {
        InetAddress inet = InetAddress.getLocalHost();
        //��������������������IP��ַ
        String ip = inet.getHostAddress();
        String name = inet.getHostName();
        System.out.println(name +"   " + ip);
        /*System.out.println(inet);
        String hsot = inet.toString();
        String[] str = hsot.split("/");
        for (String s : str) {
            System.out.println(s);
        }*/
    }
}
