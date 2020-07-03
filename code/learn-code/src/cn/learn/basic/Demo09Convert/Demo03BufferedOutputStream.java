package cn.learn.basic.Demo09Convert;
/*
    �ֽ�������Ļ�����
        java.ui.BufferedOutputStream ���ã����ԭ���������д��Ч��
        BufferedOutputStream �̳� OutputStream
        ������д��write �ֽڣ��ֽ�����

        ���췽����
            BufferedOutputStream(OutputStream out)
                ���Դ���������ֽ�����������ݵ����ĸ��ֽ������Ͷ��ĸ��ֽ������Ч��

            FileOutputStream
*/

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("c:\\demo\\buffer.txt");

        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(55);

        byte[] bytes = "HelloWorld\r\n".getBytes();
        bos.write(bytes);

        bos.write(bytes, 3, 2);

        bos.close();
    }
}
