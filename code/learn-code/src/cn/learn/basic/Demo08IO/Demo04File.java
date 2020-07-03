package cn.learn.basic.Demo08IO;
/*
File 类的判断功能
*/

import java.io.File;

public class Demo04File {
    public static void main(String[] args) {
        function();
        function_1();
        System.out.println("===========");
        /*
            File类的获取功能
            list
            listFile
        */
        function_2();
        System.out.println("==================");
        /*
            File类的获取，文件获取过滤器
            遍历目录的时候，可以根据需要，只获取满足条件的文件
            遍历目录方法listFile重载形式
            listFile(FileFilter filter) 接口类型
            传递FileFilter接口的实现类
            自定义FileFilter接口实现类，重写抽象方法
            接口实现类对象传递到遍历方法listFiles

            一旦方法返回了true
            listFile将路径，保存到File数组中
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
        获取到，File构造方法中封装的路径中的文件和文件名（遍历一个目录）

        File[] listFile()
        获取到，File构造方法中封装的路径中的文件和文件名
        返回的是目录或者文件的全路径
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
         判断File构造方法中封装的路径是不是文件夹
         如果是文件夹，返回true，不是文件夹范围false

         boolean isFile()
         判断File构造方法中封装的路径是不是文件

    */
    private static void function_1() {
        File file = new File("c:\\eclipse\\eclipse.exe");
        boolean directory = file.isDirectory();
        System.out.println(directory);
    }

    /*
        File 判断功能
        boolean exists()
        判断File构造方法中封装路径是否存在
        存在返回true， 不存在返回false
    */
    public static void function() {
        File file = new File("src");
        boolean exist = file.exists();
        System.out.println(exist);
    }
}
