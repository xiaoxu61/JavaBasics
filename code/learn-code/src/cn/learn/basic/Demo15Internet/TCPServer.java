package cn.learn.basic.Demo15Internet;
/*
    ʵ��TCP����������
    ��ʾ������������� java.net.ServerSocket
    ���췽����
        ServerSocket(int port) ���ݶ˿ں�

    ����Ҫ�����飺
        ����Ҫ��ȡ�ÿͻ��˵��׽��ֶ���Socket accept()

*/

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        //���÷������׽Ӷ����е÷���accept() ��ȡ�ͻ����׽��ֶ���
        Socket socket = server.accept();

        //ͨ���ͻ����׽��ֶ���socket��ȡ�ֽ�����������ȡ���ǿͻ��˷�����������
        InputStream in = socket.getInputStream();

        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println(new String(data, 0, len));

        //��������ͻ��˻����ݣ��ֽ��������ͨ���ͻ����׽��ֶ����ȡ�ֽ������
        OutputStream out = socket.getOutputStream();
        out.write("�յ���лл".getBytes());

        socket.close();
        server.close();
    }
}
