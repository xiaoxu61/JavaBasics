package cn.learn.basic.Demo15Internet;
/*
    ʵ��UDP���ն�
        ʵ�ַ�װ���ݱ� java.net.DatagramPacket�����ݽ���
        ʵ���������  java.net.DatagramSocket �������ݰ�
    ʵ�ֲ��裺
        1������DatagramSocket���󣬰󶨶˿ں�
           Ҫ�ͷ��Ͷ˶˿ں�һ��
        2�������ֽ����飬���շ���������
        3���������ݰ�����DatagramPacket
        4������DatagramSocket���󷽷�
            receive(DatagramPacket dp)�������ݣ����ݷ������ݰ���
        5�����
            ���͵�IP��ַ
                ���ݰ�����DatagramPacket����getAddress() ��ȡ���Ƿ��Ͷ˵�IP��ַ����
                ����ֵ��InetAddress
            ���յ����ֽڸ���
                ���ݰ�����DatagramPacket����getLength()
            ���Ͷ˵Ķ˿ں�
                ���ݰ�����DatagramPacket����getPort()���Ͷ˶˿�
        6���ر���Դ
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Demo03UDPReceive {
    public static void main(String[] args) throws IOException {
        //�������ݰ��������DatagramSocket �󶨶˿ں�
        DatagramSocket ds = new DatagramSocket(6000);
        //�����ֽ�����
        byte[] data = new byte[1024];
        //�������ݰ����󣬴����ֽ�����
        DatagramPacket dp = new DatagramPacket(data,data.length);
        //����ds����ķ�����receive �������ݰ�
        ds.receive(dp);
        //��ȡ���Ͷ˵�IP��ַ����
        String ip = dp.getAddress().getHostAddress();
        //��ȡ���͵Ķ˿ں�
        int port = dp.getPort();
        //���յ����ֽڸ���
        int length = dp.getLength();
        System.out.println(new String(data,0 ,length)+"..." +ip+"..."+port);
        ds.close();
    }
}
