package cn.learn.basic.Demo09Convert;
/*
    �ַ��������������
        java.io.BufferedWriter �̳� Writer
        д�뷽��write()  �����ַ����ַ����飬�ַ���

        ���췽����
            BufferedWriter(Writer w) ���������ַ������
            ����˭���͸�Ч˭
                �ܴ��ݵ��ַ������FileWriter��OutputStreamWriter

        BufferedWriter �����Լ������з���
        void newLine() д����,���н���Ͳ������໥��ϵ
        ��������ƽ̨�޹���
        Windows ���з� \r\n
        Linux   ���з� \n


*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo06BufferedWriter {
    public static void main(String[] args) throws IOException {
        //�����ַ����������װ�ļ�
        FileWriter fw = new FileWriter("c:\\demo\\buffer.txt");

        BufferedWriter bfw = new BufferedWriter(fw);

        bfw.write(100);
        bfw.flush();

        bfw.write("���".toCharArray());
        bfw.newLine();
        bfw.flush();

        bfw.write("�Һ�\r\n");
        bfw.flush();


        bfw.write("��Һ�");
        bfw.flush();

        bfw.close();
    }
}
