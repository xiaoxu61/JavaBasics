package cn.learn.basic.Demo10Propertise;
/*
    ��ӡ��ʵ���ı�����
        ��ȡ����Դ BufferedReader ��ȡ�ı���
        д������Ŀ��PrintWriter + println �Զ�ˢ��

*/

import java.io.*;

public class Demo04PrintWriter {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("c:\\demo\\a.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("d:\\a.txt"), true);
        String line = null;
        while ((line = bfr.readLine()) != null) {
            pw.println(line);
        }

        pw.close();
        bfr.close();
    }
}
