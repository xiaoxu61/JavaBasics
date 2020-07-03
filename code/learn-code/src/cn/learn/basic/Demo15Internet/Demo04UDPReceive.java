package cn.learn.basic.Demo15Internet;
/*
    实现UDP接收端
    永不停歇的接收端
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Demo04UDPReceive {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(6000);
        byte[] data = new byte[1024];

        while (true) {
            DatagramPacket dp = new DatagramPacket(data, data.length);
            //调用ds对象的方法，receive 传递数据包
            ds.receive(dp);
            //获取发送端的IP地址对象
            String ip = dp.getAddress().getHostAddress();
            //获取发送的端口号
            int port = dp.getPort();
            //接收到的字节个数
            int length = dp.getLength();
            System.out.println(new String(data, 0, length) + "..." + ip + "..." + port);
        }
        //ds.close();
    }
}
