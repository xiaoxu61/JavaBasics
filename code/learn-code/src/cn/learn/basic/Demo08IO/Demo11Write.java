package cn.learn.basic.Demo08IO;
/*
    字符输出流
        java.io.Writer所有字符输出流的超类
   写文件，写文本文件

   写的方法writer
   write(int c) 写一个字符
   write(char[] c) 写字符数组
   write(char[] c, int off, int len) 写入字符数组的某一部分
   write(String s) 写入字符串

   Writer类的子类对象FileWriter

   构造方法：写入数据目的
    File 类型对象
    String 文件名

    字符输出流写数据的时候，必须要运行一个功能，刷新功能
    flush()
*/

import java.io.FileWriter;
import java.io.IOException;

public class Demo11Write {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("c:\\demo\\a.txt");

        //写一个字符
        fw.write(100);
        fw.flush();
        char[] c = {'a', 'm', 'v', 'f', 'd'};
        fw.write(c);
        fw.write("\r\n");
        fw.flush();

        fw.write(c, 2, 2);
        fw.flush();

        fw.write("Hello");
        fw.flush();

        fw.close();
    }
}
