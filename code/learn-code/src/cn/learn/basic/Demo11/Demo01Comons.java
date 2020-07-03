package cn.learn.basic.Demo11;

import org.apache.commons.io.FilenameUtils;

public class Demo01Comons {
    public static void main(String[] args) {
        function_2();
    }
    /*
        boolean isExtension(String filename, String extension)
        判断文件名的后缀是不是extension
    */
    private static void function_2() {
        boolean b = FilenameUtils.isExtension("c:\\demo\\a.txt", "java");
        System.out.println(b);
    }

    /*
        FilenameUtil类的方法
        static String getName(String filename)
        获取文件名
    */
    private static void function_1() {
        String name = FilenameUtils.getName("c:\\demo\\a.txt");
        System.out.println(name);
    }

    /*
            FilenameUtil类的方法
            static String getExtension(String filename)
        */
    private static void function() {
        String name = FilenameUtils.getExtension("abc.java");
        System.out.println(name);
    }

}
