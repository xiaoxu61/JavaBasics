package cn.learn.basic.Demo09Convert;
/*
    ת����
        java.io.OutputStreamWriter �̳�Writer��
        ����һ���ַ��������д�ı��ļ�
        writer() �ַ��� �ַ����飬�ַ���

        �ֽ���ͨ���ַ��������������Խ��ֽ���ת�ַ���

     OutputStreamWriter ʹ�÷���
     ���췽����
        OutputStreamWriter(OutputStream out) �������е��ֽ������
        ���ǣ��ֽ������ FileOutputStream

        OutputStreamWriter(OutputStream out, String charsetName)
        String charsetName ���ݱ�������� GBK UTF-8

        OutputStreamWriter �и����� FileWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo01OutputStreamWriter {
    public static void main(String[] args) throws IOException{
        writeGBK();
        writeUTF();
    }

    private static void writeUTF() throws IOException{
        FileOutputStream fos = new FileOutputStream("c:\\demo\\utf.txt");
        //����ת�������������췽�������ֽ������,ʹ��GBK�����
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        //ת����д����
        osw.write("���");

        osw.close();
    }

    /*
        ת��������OutputStreamWriter
        �ı�����GBK����ʽд��
    */
    private static void writeGBK() throws IOException {
        //�����ֽ���������������ļ�
        FileOutputStream fos = new FileOutputStream("c:\\demo\\gbk.txt");
        //����ת�������������췽�������ֽ������,ʹ��GBK�����
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        //ת����д����
        osw.write("���");

        osw.close();

    }


}
