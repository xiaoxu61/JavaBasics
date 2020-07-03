package cn.learn.basic.Demo09Convert;
/*
ת����
    java.io.InputStreamReader �̳� Reader
    �ַ�����������ȡ�ı��ļ�

    InputStreamReader ���ֽ���ͨ���ַ��������������ֽ���ת�ַ���

    ��ȡ�ķ�����
        read() ��ȡһ���ַ�����ȡ�ַ�����

    ���ɣ�
        OutputStreamWriter д���ļ�
        InputStreamReader ��ȡ�ļ�

        OutputStreamWriter(OutputStream out)�����ֽ������
        InputStreamReader(InputStream in) �������е��ֽ�������
            ���Դ��ݵ��ֽ���������FileInputStream
        InputStreamReader(InputStream in, String charsetName)���ݱ��������
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo02InputStreamReader {
    public static void main(String[] args) throws IOException{
        readGBK();
        readUTF();
    }

    private static void readUTF() throws IOException{
        FileInputStream fis = new FileInputStream("c:\\demo\\utf.txt");

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        char[] chars = new char[1024];
        int len = isr.read(chars);
        System.out.println(new String(chars, 0, len));

        isr.close();
    }

    /*
        ת����InputStreamReader����ȡ�ı�
        ����ϵͳĬ�ϱ������ȡGBK�ļ�
    */
    public static void readGBK() throws IOException {
        FileInputStream fis = new FileInputStream("c:\\demo\\gbk.txt");

        InputStreamReader isr = new InputStreamReader(fis);

        char[] chars = new char[1024];
        int len = isr.read(chars);
        System.out.println(new String(chars, 0, len));

        isr.close();
    }
}
