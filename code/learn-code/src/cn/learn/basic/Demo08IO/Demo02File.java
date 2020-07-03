package cn.learn.basic.Demo08IO;
/*
    File��Ĵ�����ɾ������
    �ļ�������Ŀ¼
*/

import java.io.File;
import java.io.IOException;

public class Demo02File {
    public static void main(String[] args) throws IOException {
        function();
        function_1();
        function_2();
    }
    /*
        File���ɾ������
        boolean delate()
        ɾ�����ļ��������ļ��У���File���췽���и���
        ɾ���ɹ�����true��ɾ��ʧ�ܷ���false

        ɾ���������߻���վ��ֱ�Ӵ�Ӳ����ɾ��
        ɾ���з��գ����������
    */
    private static void function_2() {
        File file = new File("D:\\develop\\book");
        boolean delete = file.delete();
        System.out.println(delete);
    }

    /*
        �����ļ��еĹ���
            boolean mkdirs()��������ļ���
            ������·��Ҳ��File���췽���и���
            �ļ����Ѿ������ˣ����ٴ���
    */
    public static void function_1() {
        File file = new File("D:\\develop\\book");
        boolean newFile = file.mkdirs();//��ָ�����ļ��������򷵻�
        System.out.println(newFile);
    }
    /*
        File�����ļ��Ĺ���
        boolean createNewFile
        �������ļ�·�����ļ�������File���췽���и���
    */
    public static void function() throws IOException {
        File file = new File("D:\\develop\\a.txt");
        boolean newFile = file.createNewFile();//��ָ�����ļ��������򷵻�false
        System.out.println(newFile);
    }
}
