package cn.learn.basic.Demo08IO;
/*
    java.io.File
        将操作系统中的，文件，目录（文件夹），路径，封装成File对象
        提供方法，操作系统中的内容
        File与系统无关的类
        文件 file
        目录 directory
        路径 path
*/

import java.io.File;

public class Demo01File {
    public static void main(String[] args) {
        demo01();
        //File类的构造方法
        //三种重载形式
        demo02File();
        demo02File02();
        demo02File03();

    }
    /*
    File(File parent, String child)
    传递路径，传递File类型父路径，字符串子路径
    好处：父路径是File类型，父路径可以直接调用File类方法
    */
    private static void demo02File03() {
        File parent = new File("d:");
        File file  = new File(parent, "develop");
        System.out.println(file);
    }

    /*
        File(String parent, String child)
        传递路径，传递字符串父路径，字符子路径
        好处：单独操作父路径和子路径
    */
    private static void demo02File02() {
        File file = new File("d:", "develop");
        System.out.println(file);
    }

    /*
        File(String pathname)
        传递路径名：可以写到文件夹，可以写到一个文件
        c:\\abc   c:\\abc\\demo.java
    */
    private static void demo02File() {
        File file = new File("d:\\develop");
        System.out.println(file);


    }

    private static void demo01() {
        //File类，静态成员变量
        //与系统有关的路径分隔符
        String separator = File.pathSeparator;
        System.out.println(separator);//是一个分号，目录的分割符， Linux下是 ：

        //与系统要关的默认名称分隔符
        separator = File.separator;
        System.out.println(separator);//向右\ 目录名称分割  Linux下是 /
    }
}
