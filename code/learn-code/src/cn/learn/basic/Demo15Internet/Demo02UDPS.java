package cn.learn.basic.Demo15Internet;
/*
    ʵ��UDPЭ��ķ��Ͷˣ�
        ʵ�ַ�װ���ݵ��� java.net.DatagramPacket   ��������ݰ�װ
        ʵ�����ݴ������ java.net.DatagramSocket   ����İ�����ȥ

   ʵ�ֲ��裺
    1������DatagramPacket���󣬷�װ���ݣ����յĵ�ַ�Ͷ˿�
    2������DatagramSocket
    3������DatagramSocket�෽��send���������ݰ�
    4���ر���Դ
      DatagramPacket���췽����
        DatagramPacket(byte[] buf, int length, InetAddress address, int port)
      DatagramSocket���췽����
               DatagramSocket()�ղ���
               ������send(DatagramPacket d)
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Demo02UDPS {
    public static void main(String[] args) throws IOException {
        //�������ݰ����󣬷�װҪ���͵����ݣ����ն�IP���˿�
        byte[] date = "���UDP".getBytes();
        //����InetAddress���󣬷�װ�Լ���IP��ַ
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(date, date.length, inet, 6000);
        //����DatagramSocket�������ݰ��ķ��ͺͽ��ն���
        DatagramSocket ds = new DatagramSocket();
        //����ds����ķ���send���������ݰ�
        ds.send(dp);
        //�ر���Դ
        ds.close();
    }
}