package cn.learn.basic.Demo08IO;
/*
File ����жϹ���
*/

import java.io.File;

public class Demo04File {
    public static void main(String[] args) {
        function();
        function_1();
        System.out.println("===========");
        /*
            File��Ļ�ȡ����
            list
            listFile
        */
        function_2();
        System.out.println("==================");
        /*
            File��Ļ�ȡ���ļ���ȡ������
            ����Ŀ¼��ʱ�򣬿��Ը�����Ҫ��ֻ��ȡ�����������ļ�
            ����Ŀ¼����listFile������ʽ
            listFile(FileFilter filter) �ӿ�����
            ����FileFilter�ӿڵ�ʵ����
            �Զ���FileFilter�ӿ�ʵ���࣬��д���󷽷�
            �ӿ�ʵ������󴫵ݵ���������listFiles

            һ������������true
            listFile��·�������浽File������
        */
        function_3();
    }

    private static void function_3() {
        File file = new File("c:\\demo");
        File[] files = file.listFiles(new MyFilter());
        for (File f : files) {
            System.out.println(f);
        }

    }

    /*
        String[] list()
        ��ȡ����File���췽���з�װ��·���е��ļ����ļ���������һ��Ŀ¼��

        File[] listFile()
        ��ȡ����File���췽���з�װ��·���е��ļ����ļ���
        ���ص���Ŀ¼�����ļ���ȫ·��
    */
    private static void function_2() {
        File file = new File("c:\\eclipse");
        String[] strArr = file.list();
        System.out.println(strArr.length);
        for (String str : strArr) {
            System.out.println(str);
        }
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /*
        boolean isDirectory()
         �ж�File���췽���з�װ��·���ǲ����ļ���
         ������ļ��У�����true�������ļ��з�Χfalse

         boolean isFile()
         �ж�File���췽���з�װ��·���ǲ����ļ�

    */
    private static void function_1() {
        File file = new File("c:\\eclipse\\eclipse.exe");
        boolean directory = file.isDirectory();
        System.out.println(directory);
    }

    /*
        File �жϹ���
        boolean exists()
        �ж�File���췽���з�װ·���Ƿ����
        ���ڷ���true�� �����ڷ���false
    */
    public static void function() {
        File file = new File("src");
        boolean exist = file.exists();
        System.out.println(exist);
    }
}
