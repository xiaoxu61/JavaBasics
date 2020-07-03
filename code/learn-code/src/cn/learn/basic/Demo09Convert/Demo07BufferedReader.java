package cn.learn.basic.Demo09Convert;
/*
    �������Ļ�������
        java.io.BufferedReader �̳� Reader
        ��ȡ����read() �����ַ����ֽ�����
        ���췽����
            BufferedReader(Reader r)
            ����������ַ�������
            FileReader InputStreamReader

        BufferedReader�Լ��Ĺ���
        String readLine() ��ȡ�ı��� \r\n

        ������ȡ����ĩβ������null
        С�ص㣺
            ��ȡ���ݵķ���һ�㶼�з���ֵ
            int û�з��ض��Ǹ���
            �������� �Ҳ�������null
            boolean �Ҳ�������false

            String s = null
            String s = "null"

            readLine() ���������е���Ч�ַ���û��\r\n���з�
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo07BufferedReader {
    public static void main(String[] args) throws IOException {
        //�����ַ�������������󣬹��췽�������ַ�����������װ����Դ�ļ�
        BufferedReader bfr = new BufferedReader(new FileReader("c:\\demo\\a.txt"));

        //���û������ķ���readLine() ��ȡ�ı���

        /*String line = bfr.readLine();
        System.out.println(line);

        line = bfr.readLine();
        System.out.println(line);*/
        int lineNumber = 0;
        String line = null;
        while ((line = bfr.readLine()) != null) {
            lineNumber++;
            System.out.print(lineNumber + " " + line);
        }

        bfr.close();
    }
}
