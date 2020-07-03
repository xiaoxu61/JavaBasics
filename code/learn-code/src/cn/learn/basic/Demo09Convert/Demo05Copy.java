package cn.learn.basic.Demo09Convert;
/*
    文件复制方式，字节流，一共4个方式
        1、字节流读写单个字节
        2、字节流读写字节数组             3482毫秒
        3、字节流缓冲区流读写单个字节     9786毫秒
        4、字节流缓冲区流读写字节数组     1242毫秒
*/

import java.io.*;

public class Demo05Copy {
    public static void main(String[] args) throws IOException{
        long s = System.currentTimeMillis();
        copy_4(new File("c:\\eclipse\\plugins.rar"), new File("c:\\demo\\plugins.rar"));
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }
    //字节流缓冲区流读写字节数组
    private static void copy_4(File src, File desc) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();
    }
    //字节流缓冲区流读写单个字节
    private static void copy_3(File src, File desc) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));

        int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }

        bos.close();
        bis.close();
    }

    //字节流读写字节数组
    private static void copy_2(File src, File desc) throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fis.close();
        fos.close();
    }

    /*
           方法，实现文件复制
               1、字节流读写单个字节
       */
    private static void copy_1(File src, File desc) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);

        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        fis.close();
        fos.close();
    }


}
