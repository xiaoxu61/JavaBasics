package cn.learn.basic.Demo11;

import org.apache.commons.io.FilenameUtils;

public class Demo01Comons {
    public static void main(String[] args) {
        function_2();
    }
    /*
        boolean isExtension(String filename, String extension)
        �ж��ļ����ĺ�׺�ǲ���extension
    */
    private static void function_2() {
        boolean b = FilenameUtils.isExtension("c:\\demo\\a.txt", "java");
        System.out.println(b);
    }

    /*
        FilenameUtil��ķ���
        static String getName(String filename)
        ��ȡ�ļ���
    */
    private static void function_1() {
        String name = FilenameUtils.getName("c:\\demo\\a.txt");
        System.out.println(name);
    }

    /*
            FilenameUtil��ķ���
            static String getExtension(String filename)
        */
    private static void function() {
        String name = FilenameUtils.getExtension("abc.java");
        System.out.println(name);
    }

}
