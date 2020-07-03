package cn.learn.basic.Demo15Internet;
/*
    TCPͼƬ�ϴ��ķ�����
        1��ServerSocket�׽��ֶ��󣬼����˿�8000
        2������accept() ��ȡ�ͻ��˵����Ӷ���
        3���ͻ������Ӷ����ȡ�ֽ�����������ȡ�ͻ��˷���ͼƬ
        4������File���󣬰��ϴ��ļ���
           �ж��ļ��д��ڣ������ڴ����ļ���
        5�������ֽ������������Ŀ��File���������ļ���
        6���ֽ�����ȡͼƬ���ֽ�����ͼƬд�뵽Ŀ���ļ�����
        7�����ϴ��ɹ�д�ؿͻ���
        8���ر���Դ
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPSeverDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket sever = new ServerSocket(8888);
        Socket socket = sever.accept();

        InputStream in = socket.getInputStream();
        //��Ŀ���ļ��з�װ��File����
        File upload = new File("C:\\demo\\UpLoad");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        //��ֹ�ļ�ͬ�������ǣ����¶����ļ�����
        //��������+����ֵ+6λ�����
        String filename = "itcast" + System.currentTimeMillis() + new Random().nextInt(999999)+".jpg";
        //�����ֽ����������ͼƬд�뵽Ŀ���ļ�����
        FileOutputStream fos = new FileOutputStream(upload + File.separator + filename);
        //��д�ֽ�����
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        //ͨ���ͻ������Ӷ����ȡ�ֽ������
        //�ϴ��ɹ�д�ؿͻ���
        socket.getOutputStream().write("�ϴ��ɹ�".getBytes());

        fos.close();
        socket.close();
        sever.close();
    }
}
