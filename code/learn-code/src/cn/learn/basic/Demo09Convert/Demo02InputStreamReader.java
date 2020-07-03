package cn.learn.basic.Demo09Convert;
/*
转换流
    java.io.InputStreamReader 继承 Reader
    字符输入流，读取文本文件

    InputStreamReader 是字节流通向字符流的桥梁，将字节流转字符流

    读取的方法：
        read() 读取一个字符，读取字符数组

    技巧：
        OutputStreamWriter 写了文件
        InputStreamReader 读取文件

        OutputStreamWriter(OutputStream out)所有字节输出流
        InputStreamReader(InputStream in) 接收所有的字节输入流
            可以传递的字节输入流：FileInputStream
        InputStreamReader(InputStream in, String charsetName)传递编码表名字
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo02InputStreamReader {
    public static void main(String[] args) throws IOException{
        readGBK();
        readUTF();
    }

    private static void readUTF() throws IOException{
        FileInputStream fis = new FileInputStream("c:\\demo\\utf.txt");

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        char[] chars = new char[1024];
        int len = isr.read(chars);
        System.out.println(new String(chars, 0, len));

        isr.close();
    }

    /*
        转换流InputStreamReader，读取文本
        采用系统默认编码表，读取GBK文件
    */
    public static void readGBK() throws IOException {
        FileInputStream fis = new FileInputStream("c:\\demo\\gbk.txt");

        InputStreamReader isr = new InputStreamReader(fis);

        char[] chars = new char[1024];
        int len = isr.read(chars);
        System.out.println(new String(chars, 0, len));

        isr.close();
    }
}
