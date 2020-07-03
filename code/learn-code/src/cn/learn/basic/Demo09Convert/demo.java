package cn.learn.basic.Demo09Convert;

import java.io.*;

public class demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c:\\demo\\utf.txt");
        FileOutputStream fos = new FileOutputStream("c:\\demo\\gbk.txt");

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        char[] chars = new char[1024];
        int len = isr.read(chars);

        osw.write(chars, 0, len);

        osw.close();
        isr.close();
    }
}
