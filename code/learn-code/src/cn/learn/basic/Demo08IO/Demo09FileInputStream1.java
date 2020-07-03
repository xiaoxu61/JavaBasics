package cn.learn.basic.Demo08IO;
/*
    FileInputStream读取文件
        读取方法 int read(byte[] b) 读取字节数组
        数组作用： 缓冲作用，提高效率
        read方法返回int的含义： 读取到的有效字节数
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Demo09FileInputStream1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c:\\demo\\a.txt");
        //创建字节数组
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            System.out.print(new String(b, 0, len));
        }

        /*len = fis.read(b);
        System.out.println(new String(b));
        System.out.println(len);

        len = fis.read(b);
        System.out.println(new String(b));
        System.out.println(len);*/

        fis.close();
    }
}
