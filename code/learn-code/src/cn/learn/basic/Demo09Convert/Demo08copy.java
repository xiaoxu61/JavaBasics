package cn.learn.basic.Demo09Convert;
/*
    ʹ�û����������󣬸����ı��ļ�
    ����Դ BufferedReader + FileReader ��ȡ
    ����Ŀ�� BufferedWriter + FileWriter д��

    ��ȡ�ı��еķ�ʽ����һ�У�дһ�У�д����
*/

import java.io.*;

public class Demo08copy {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("c:\\eclipse\\plugins.rar"));
        BufferedWriter bfw = new BufferedWriter(new FileWriter("c:\\demo\\plugins.txt"));

        //��ȡ�ı��еķ�ʽ����һ�У�дһ�У�д����
        String line = null;
        while ((line = bfr.readLine()) != null) {
            bfw.write(line);
            bfw.newLine();
            bfw.flush();
        }

        bfw.close();
        bfr.close();
    }
}
