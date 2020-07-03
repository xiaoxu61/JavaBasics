package cn.learn.basic.Demo09Convert;
/*
    �ļ����Ʒ�ʽ���ֽ�����һ��4����ʽ
        1���ֽ�����д�����ֽ�
        2���ֽ�����д�ֽ�����             3482����
        3���ֽ�������������д�����ֽ�     9786����
        4���ֽ�������������д�ֽ�����     1242����
*/

import java.io.*;

public class Demo05Copy {
    public static void main(String[] args) throws IOException{
        long s = System.currentTimeMillis();
        copy_4(new File("c:\\eclipse\\plugins.rar"), new File("c:\\demo\\plugins.rar"));
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }
    //�ֽ�������������д�ֽ�����
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
    //�ֽ�������������д�����ֽ�
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

    //�ֽ�����д�ֽ�����
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
           ������ʵ���ļ�����
               1���ֽ�����д�����ֽ�
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
