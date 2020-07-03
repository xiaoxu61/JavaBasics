package cn.learn.basic.Demo08IO;
/*
    字节输出流
        java.io.OutputStream 所有字节输出流的超类
        作用：从Java程序，写出文件
        字节：这样流每次只操作文件中的一个字节
        写任意文件

        方法都是写文入的方法
        write(int o)写入一个字节
        write(byte[] b)写入字节数组
        write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流
        close() 关闭此输出流并释放与此流有关的所有系统资源。

        流对象，操作文件的时候，自己不做，依赖操作系统
*/

public class Demo08OutputStream {
    public static void main(String[] args) {

    }
}
