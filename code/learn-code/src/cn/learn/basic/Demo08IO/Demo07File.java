package cn.learn.basic.Demo08IO;
/*
    ����Ŀ¼����ȡĿ¼������.java�ļ�
    �����༶Ŀ¼�������ݹ�ʵ��
    �����Ĺ��̣�ʹ�ù�����
*/

import java.io.File;

public class Demo07File {
    public static void main(String[] args) {
        getAllJava(new File("c:\\demo"));
    }
    /*
        ���巽����ʵ�ֱ���ָ��Ŀ¼
        ��ȡĿ¼�����е�.java�ļ�
    */
    public static void getAllJava(File dir) {
        //����File����listFiles() ��ȡ�����������
        File[] files = dir.listFiles(new MyFilter());
        for (File f : files) {
            //��f·�����ж��ǲ����ļ���
            if (f.isDirectory()) {
                //�ݹ�����ļ��б���
                getAllJava(f);
            }else {
                System.out.println(f);
            }
        }
    }
}
