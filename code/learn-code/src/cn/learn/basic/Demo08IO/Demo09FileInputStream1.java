package cn.learn.basic.Demo08IO;
/*
    FileInputStream��ȡ�ļ�
        ��ȡ���� int read(byte[] b) ��ȡ�ֽ�����
        �������ã� �������ã����Ч��
        read��������int�ĺ��壺 ��ȡ������Ч�ֽ���
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Demo09FileInputStream1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c:\\demo\\a.txt");
        //�����ֽ�����
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            System.out.print(new String(b, 0, len));
        }

        /*len = fis.read(b);
        System.out.println(new String(b));
        System.out.println(len);

        len = fis.read(b);
        System.out.println(new String(b));
        System.out.println(len);*/

        fis.close();
    }
}
