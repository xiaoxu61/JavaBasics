package cn.learn.basic.Demo11;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Demo02Commons {
    public static void main(String[] args) throws IOException{
        function_3();
    }
    /*
        static copyDirectoryToDirectory(File src, File desc)
        �����ļ���
    */
    private static void function_3() throws IOException{
        FileUtils.copyDirectoryToDirectory(new File("d:\\whale"), new File("c:\\demo\\whale"));
    }

    /*
        static void copyFile(File src, File desc)
        �����ļ�
    */
    private static void function_2() throws IOException{
        FileUtils.copyFile(new File("f:\\ͼƬ\\1.jpg"), new File("c:\\demo\\1.jpg"));
    }

    /*
        static void writeStringtoFile(File src, String date)
        ���ַ���ֱ��д���ļ���
    */
    private static void function_1() throws IOException{
        FileUtils.writeStringToFile(new File("c:\\demo\\b.txt"), "�Ұ����");
    }

    /*
        FileUtils ������ķ���
        static String readFileToString(File src) ��ȡ�ı��������ַ���
    */
    private static void function() throws IOException {
        String s = FileUtils.readFileToString(new File("c:\\demo\\a.txt"));
        System.out.println(s);
    }
}
