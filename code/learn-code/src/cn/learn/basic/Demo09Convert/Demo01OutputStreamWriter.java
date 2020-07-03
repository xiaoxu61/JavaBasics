package cn.learn.basic.Demo09Convert;
/*
    转换流
        java.io.OutputStreamWriter 继承Writer类
        就是一个字符输出流，写文本文件
        writer() 字符， 字符数组，字符串

        字节流通向字符串的桥梁，可以将字节流转字符流

     OutputStreamWriter 使用方法
     构造方法：
        OutputStreamWriter(OutputStream out) 接收所有的字节输出流
        但是：字节输出流 FileOutputStream

        OutputStreamWriter(OutputStream out, String charsetName)
        String charsetName 传递编码表名字 GBK UTF-8

        OutputStreamWriter 有个子类 FileWriter
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
        //创建转换对象流，构造方法，绑定字节输出流,使用GBK编码表
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        //转换流写数据
        osw.write("你好");

        osw.close();
    }

    /*
        转换流对象OutputStreamWriter
        文本采用GBK的形式写入
    */
    private static void writeGBK() throws IOException {
        //创建字节输出流，绑定数据文件
        FileOutputStream fos = new FileOutputStream("c:\\demo\\gbk.txt");
        //创建转换对象流，构造方法，绑定字节输出流,使用GBK编码表
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        //转换流写数据
        osw.write("你好");

        osw.close();

    }


}
