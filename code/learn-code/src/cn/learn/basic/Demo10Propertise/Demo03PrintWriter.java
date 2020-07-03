package cn.learn.basic.Demo10Propertise;
/*
    ��ӡ����
        PrintStream
        PrintWriter
    ��ӡ�����ص㣺
        1����������������Դ��ֻ��������Ŀ��
        2��Ϊ�������������ӹ���
        3����Զ�����׳�IOException
            ���ǣ������׳�����쳣
       ������ӡ���ķ�����ȫһ��
            ���췽�������Ǵ�ӡ�������Ŀ�Ķ�
                PrintStream
                    ���췽��������File���ͣ������ַ����ļ����������ֽ������OutputStream
                PrintWriter
                    ���췽��������File���ͣ������ַ����ļ����������ֽ������OutputStream�������ַ������
*/

import java.io.*;

public class Demo03PrintWriter {
    public static void main(String[] args) throws IOException{
        demoPrint_3();
    }
    /*
        ��ӡ�������Կ����Զ�ˢ�¹���
        ��������������
            1�����������Ŀ�ı�����������
                OutputStream Writer
            2���������println��printf��format���������е�����һ�����������Զ�ˢ��
    */
    private static void demoPrint_3() throws IOException{

        FileOutputStream fos = new FileOutputStream("c:\\demo\\5.txt");
        PrintWriter pw = new PrintWriter(fos, true);
        pw.println("i");
        pw.println("Love");
        pw.println("you");

        pw.close();
    }

    /*
        ��ӡ�������Ŀ�ģ���������
        �������ֽ���������������ַ��������
        OutputStream  Writer
    */
    private static void demoPrint_2() throws IOException {
//        FileOutputStream fos = new FileOutputStream("c:\\demo\\3.txt");
        FileWriter fw = new FileWriter("c:\\demo\\4.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("��ӡ��");
        pw.close();
    }

    /*
        ��ӡ�������Ŀ�ģ�String�ļ���

    */
    private static void demoPrint_1() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("c:\\demo\\2.txt");
        pw.println(3.5);
        pw.close();
    }

    /*
        ��ӡ������File���������Ŀ��д������
        ����print println  ԭ�����
        write���������
    */
    private static void demoPrint() throws FileNotFoundException {
        File file = new File("c:\\demo\\1.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println(100);
        pw.close();
    }
}
