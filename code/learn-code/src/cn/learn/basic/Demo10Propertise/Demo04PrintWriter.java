package cn.learn.basic.Demo10Propertise;
/*
    打印流实现文本复制
        获取数据源 BufferedReader 读取文本行
        写入数据目的PrintWriter + println 自动刷新

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
