package cn.learn.basic.Demo08IO;
/*
    File类的获取功能
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
        获取父路径
    */
    private static void function_3() {
        File file = new File("C:\\eclipse\\eclipse.exe");
        File parent = file.getParentFile();
        System.out.println(parent);
    }

    /*
        String getAbsolutePath() 返回String对象
        File getAbsoluteFile()  返回File对象
        获取绝对路径

        若写的是一个相对路径，获取到的是绝对位置是，当前工程的根目录
    */
    private static void function_2() {
        File file = new File("eclipse");
        File absolute = file.getAbsoluteFile();
        System.out.println(absolute);
    }

    /*
        File获取功能
        long length()
        返回路径中表示的文件的字节数
    */
    private static void function_1() {
        File file = new File("C:\\eclipse\\eclipse.exe");
        long length = file.length();
        System.out.println(length);
    }

    /*
        File类的获取功能
        String getName()
        返回路径路径中表示的文件或者文件名

        获取路径字符串中的最后部分的名字
    */
    private static void function_get() {
        File file = new File("C:\\eclipse\\eclipse.exe");
        String name = file.getName();
        System.out.println(name);
    }
}
