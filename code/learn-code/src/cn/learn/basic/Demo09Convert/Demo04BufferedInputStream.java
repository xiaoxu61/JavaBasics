package cn.learn.basic.Demo09Convert;
/*
    �ֽ��������Ļ�����
        java.io.BufferedInputStream
            �̳�InputStream ��׼���ֽ�������
            ��ȡ����read() �����ֽڣ��ֽ�����

        ���췽����
            BufferedInputStream(InputStream in)
            ���Դ���������ֽ���������������˭�������˭��Ч��
            ���Դ��ݵ��ֽ�������FileInputStream

*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo04BufferedInputStream {
    public static void main(String[] args) throws IOException {
        System.out.println(System.in);

        //�����ֽ��������Ļ��������󣬹��췽���а�װ�ֽ�����������װ�ļ�
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:\\demo\\buffer.txt"));

        byte[] bytes = new byte[10];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, len));
        }
        bis.close();
    }
}