package cn.learn.basic.Demo08IO;
/*
    FileInputStream读取文件
        构造方法：为这个流对象绑定数据源

    参数：
        File 类型对象
        String 对象
    输入流读取文件的步骤
        1、创捷字节输入流的子类对象
        2、调用读取方法read读取
        3、关闭资源
    read() 方法
        read()执行一次，就会自动读取下一个字节
        返回值：返回读取到的字节，当方法读取到结尾，返回-1
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Demo09FileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c:\\demo\\a.txt");
        /*//读取一个字节，调用方法read， 返回int
        int i = fis.read();
        System.out.println(i);

        i = fis.read();
        System.out.println(i);*/
        //使用循环方式读取文件
        int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.print((char)len);
        }
        //关闭资源
        fis.close();
    }
}
