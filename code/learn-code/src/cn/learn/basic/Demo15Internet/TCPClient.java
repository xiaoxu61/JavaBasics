package cn.learn.basic.Demo15Internet;
/*
    ʵ��TCP�ͻ��ˣ����ӷ�����
    �ͷ��������ݽ���
    ʵ��TCP�ͻ��˳�����࣬java.net.Socket

    ���췽����
        Socket(String host, int port) ���ݷ�����IP�Ͷ˿ں�
        ע�⣺���췽��ֻҪ���У��ͻ�ͷ������������ӣ�����ʧ�ܣ��׳��쳣

    OutputStream getOutputStream() �����׽��ֵ������
        ���ã�����������������������

    InputStream getInputStream() �����׽��ֵ�������
        ���ã��ӷ������˶�ȡ����

    �ͻ��˷��������ݽ���������ʹ���׽��ֶ���Socket�еĻ�ȡ��IO�����Լ�new��������
*/

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args)throws IOException {
        //����Socket�������ӷ�����
        Socket socket = new Socket("127.0.0.1", 8888);
        //ͨ���ͻ��˵��׽��ֶ���Socket��������ȡ�ֽ��������������д�������
        OutputStream out = socket.getOutputStream();
        out.write("������OK".getBytes());

        //��ȡ���������ص����ݣ�ʹ��socket�׽��ֶ����е��ֽ�������
        InputStream in = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println(new String(data, 0, len));

        socket.close();
    }
}
