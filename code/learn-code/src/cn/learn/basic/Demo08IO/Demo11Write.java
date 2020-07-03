package cn.learn.basic.Demo08IO;
/*
    �ַ������
        java.io.Writer�����ַ�������ĳ���
   д�ļ���д�ı��ļ�

   д�ķ���writer
   write(int c) дһ���ַ�
   write(char[] c) д�ַ�����
   write(char[] c, int off, int len) д���ַ������ĳһ����
   write(String s) д���ַ���

   Writer����������FileWriter

   ���췽����д������Ŀ��
    File ���Ͷ���
    String �ļ���

    �ַ������д���ݵ�ʱ�򣬱���Ҫ����һ�����ܣ�ˢ�¹���
    flush()
*/

import java.io.FileWriter;
import java.io.IOException;

public class Demo11Write {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("c:\\demo\\a.txt");

        //дһ���ַ�
        fw.write(100);
        fw.flush();
        char[] c = {'a', 'm', 'v', 'f', 'd'};
        fw.write(c);
        fw.write("\r\n");
        fw.flush();

        fw.write(c, 2, 2);
        fw.flush();

        fw.write("Hello");
        fw.flush();

        fw.close();
    }
}
