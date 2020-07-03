package cn.learn.basic.Demo08IO;
/*
    File��Ļ�ȡ����
*/

import java.io.File;

public class Demo03FileGet {
    public static void main(String[] args) {
        //function_get();
       // function_1();
        function_2();
       // function_3();

    }
    /*
        String getParent()
        File getParentFile()
        ��ȡ��·��
    */
    private static void function_3() {
        File file = new File("C:\\eclipse\\eclipse.exe");
        File parent = file.getParentFile();
        System.out.println(parent);
    }

    /*
        String getAbsolutePath() ����String����
        File getAbsoluteFile()  ����File����
        ��ȡ����·��

        ��д����һ�����·������ȡ�����Ǿ���λ���ǣ���ǰ���̵ĸ�Ŀ¼
    */
    private static void function_2() {
        File file = new File("eclipse");
        File absolute = file.getAbsoluteFile();
        System.out.println(absolute);
    }

    /*
        File��ȡ����
        long length()
        ����·���б�ʾ���ļ����ֽ���
    */
    private static void function_1() {
        File file = new File("C:\\eclipse\\eclipse.exe");
        long length = file.length();
        System.out.println(length);
    }

    /*
        File��Ļ�ȡ����
        String getName()
        ����·��·���б�ʾ���ļ������ļ���

        ��ȡ·���ַ����е���󲿷ֵ�����
    */
    private static void function_get() {
        File file = new File("C:\\eclipse\\eclipse.exe");
        String name = file.getName();
        System.out.println(name);
    }
}
