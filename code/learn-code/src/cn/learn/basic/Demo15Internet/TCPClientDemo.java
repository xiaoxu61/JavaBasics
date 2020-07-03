package cn.learn.basic.Demo15Internet;
/*
    ʵ��TCPͼƬ�ϴ��ͻ���
    ʵ�ֲ��裺
        1��Socket�׽������ӷ�����
        2��ͨ��Socket��ȡ�ֽ��������дͼƬ
        3��ʹ���Լ��������󣬶�ȡͼƬ����Դ
            FileInputStream
        4����ȡͼƬ��ʹ���ֽ����������ͼƬд��������
            �����ֽ�������л���
        5��ͨ��Socket�׽��ֻ�ȡ�ֽ�������
            ��ȡ���������������ϴ��ɹ�
        6���ر���Դ
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientDemo {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);
        //��ȡ�ֽ��������ͼƬд��������
        OutputStream out = socket.getOutputStream();
        //�����ֽ�����������ȡ�����ϵ�����ԴͼƬ
        FileInputStream fis = new FileInputStream("F:\\ͼƬ\\��ֽ\\5246843548d5b9030b2db16d.jpg");
        //��д�ֽ�����
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        //��������д��ֹ����
        socket.shutdownOutput();
        //��ȡ�ֽ�����������ȡ���������ϴ��ɹ�
        InputStream in = socket.getInputStream();

        len = in.read(bytes);
        System.out.println(new String(bytes, 0, len));

        fis.close();
        socket.close();
    }
}
