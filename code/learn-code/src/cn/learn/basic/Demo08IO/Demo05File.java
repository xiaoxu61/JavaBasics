package cn.learn.basic.Demo08IO;
/*
    ��һ��Ŀ¼�µ��������ݣ�������ȫ�ı���
*/

import java.io.File;

public class Demo05File {
    public static void main(String[] args) {
        File file = new File("c:\\demo");
        getAllDir(file);
    }
    /*
        ���巽��ʵ��Ŀ¼��ȫ����
    */
    public static void getAllDir(File file) {
        System.out.println(file);
        //���÷���listFiles() ��Ŀ¼��dir���б���
        File[] fileArr = file.listFiles();
        for (File file1 : fileArr) {
            if (file1.isDirectory()) {
                getAllDir(file1);//�����ĵݹ����
            }else {
                System.out.println(file1);
            }

        }
    }
}
