package cn.learn.basic.Demo09Convert;
/*
    使用缓冲区流对象，复制文本文件
    数据源 BufferedReader + FileReader 读取
    数据目的 BufferedWriter + FileWriter 写入

    读取文本行的方式，第一行，写一行，写换行
*/

import java.io.*;

public class Demo08copy {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("c:\\eclipse\\plugins.rar"));
        BufferedWriter bfw = new BufferedWriter(new FileWriter("c:\\demo\\plugins.txt"));

        //读取文本行的方式，第一行，写一行，写换行
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
