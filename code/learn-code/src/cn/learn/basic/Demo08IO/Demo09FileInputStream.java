package cn.learn.basic.Demo08IO;
/*
    FileInputStream��ȡ�ļ�
        ���췽����Ϊ��������������Դ

    ������
        File ���Ͷ���
        String ����
    ��������ȡ�ļ��Ĳ���
        1�������ֽ����������������
        2�����ö�ȡ����read��ȡ
        3���ر���Դ
    read() ����
        read()ִ��һ�Σ��ͻ��Զ���ȡ��һ���ֽ�
        ����ֵ�����ض�ȡ�����ֽڣ���������ȡ����β������-1
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Demo09FileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c:\\demo\\a.txt");
        /*//��ȡһ���ֽڣ����÷���read�� ����int
        int i = fis.read();
        System.out.println(i);

        i = fis.read();
        System.out.println(i);*/
        //ʹ��ѭ����ʽ��ȡ�ļ�
        int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.print((char)len);
        }
        //�ر���Դ
        fis.close();
    }
}
