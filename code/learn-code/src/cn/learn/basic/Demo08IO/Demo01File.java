package cn.learn.basic.Demo08IO;
/*
    java.io.File
        ������ϵͳ�еģ��ļ���Ŀ¼���ļ��У���·������װ��File����
        �ṩ����������ϵͳ�е�����
        File��ϵͳ�޹ص���
        �ļ� file
        Ŀ¼ directory
        ·�� path
*/

import java.io.File;

public class Demo01File {
    public static void main(String[] args) {
        demo01();
        //File��Ĺ��췽��
        //����������ʽ
        demo02File();
        demo02File02();
        demo02File03();

    }
    /*
    File(File parent, String child)
    ����·��������File���͸�·�����ַ�����·��
    �ô�����·����File���ͣ���·������ֱ�ӵ���File�෽��
    */
    private static void demo02File03() {
        File parent = new File("d:");
        File file  = new File(parent, "develop");
        System.out.println(file);
    }

    /*
        File(String parent, String child)
        ����·���������ַ�����·�����ַ���·��
        �ô�������������·������·��
    */
    private static void demo02File02() {
        File file = new File("d:", "develop");
        System.out.println(file);
    }

    /*
        File(String pathname)
        ����·����������д���ļ��У�����д��һ���ļ�
        c:\\abc   c:\\abc\\demo.java
    */
    private static void demo02File() {
        File file = new File("d:\\develop");
        System.out.println(file);


    }

    private static void demo01() {
        //File�࣬��̬��Ա����
        //��ϵͳ�йص�·���ָ���
        String separator = File.pathSeparator;
        System.out.println(separator);//��һ���ֺţ�Ŀ¼�ķָ���� Linux���� ��

        //��ϵͳҪ�ص�Ĭ�����Ʒָ���
        separator = File.separator;
        System.out.println(separator);//����\ Ŀ¼���Ʒָ�  Linux���� /
    }
}
