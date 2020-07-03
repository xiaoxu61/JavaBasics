package cn.learn.basic.Demo08IO;
/*
    File类的创建和删除功能
    文件或者是目录
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
        File类的删除功能
        boolean delate()
        删除的文件或者是文件夹，在File构造方法中给出
        删除成功返回true，删除失败返回false

        删除方法不走回收站，直接从硬盘中删除
        删除有风险，运行需谨慎
    */
    private static void function_2() {
        File file = new File("D:\\develop\\book");
        boolean delete = file.delete();
        System.out.println(delete);
    }

    /*
        创建文件夹的功能
            boolean mkdirs()创建多层文件夹
            创建的路径也在File构造方法中给出
            文件夹已经存在了，不再创建
    */
    public static void function_1() {
        File file = new File("D:\\develop\\book");
        boolean newFile = file.mkdirs();//若指定的文件，若存则返回
        System.out.println(newFile);
    }
    /*
        File创建文件的功能
        boolean createNewFile
        创建的文件路径和文件名，在File构造方法中给出
    */
    public static void function() throws IOException {
        File file = new File("D:\\develop\\a.txt");
        boolean newFile = file.createNewFile();//若指定的文件，若存则返回false
        System.out.println(newFile);
    }
}
