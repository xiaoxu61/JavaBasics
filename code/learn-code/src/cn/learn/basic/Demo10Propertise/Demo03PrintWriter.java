package cn.learn.basic.Demo10Propertise;
/*
    打印流：
        PrintStream
        PrintWriter
    打印流的特点：
        1、此流不负责数据源，只负责数据目的
        2、为其他输出流，添加功能
        3、永远不会抛出IOException
            但是，可能抛出别的异常
       两个打印流的方法完全一致
            构造方法，就是打印流的输出目的端
                PrintStream
                    构造方法，接收File类型，接收字符串文件名，接收字节输出流OutputStream
                PrintWriter
                    构造方法，接收File类型，接收字符串文件名，接收字节输出流OutputStream，接收字符输出流
*/

import java.io.*;

public class Demo03PrintWriter {
    public static void main(String[] args) throws IOException{
        demoPrint_3();
    }
    /*
        打印流，可以开启自动刷新功能
        满足两个条件：
            1、输出的数据目的必须是流对象
                OutputStream Writer
            2、必须调用println，printf，format三个方法中的其中一个才能启用自动刷新
    */
    private static void demoPrint_3() throws IOException{

        FileOutputStream fos = new FileOutputStream("c:\\demo\\5.txt");
        PrintWriter pw = new PrintWriter(fos, true);
        pw.println("i");
        pw.println("Love");
        pw.println("you");

        pw.close();
    }

    /*
        打印流，输出目的，是流对象
        可以是字节输出流，可以是字符的输出流
        OutputStream  Writer
    */
    private static void demoPrint_2() throws IOException {
//        FileOutputStream fos = new FileOutputStream("c:\\demo\\3.txt");
        FileWriter fw = new FileWriter("c:\\demo\\4.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("打印流");
        pw.close();
    }

    /*
        打印流，输出目的，String文件名

    */
    private static void demoPrint_1() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("c:\\demo\\2.txt");
        pw.println(3.5);
        pw.close();
    }

    /*
        打印流，向File对象的数据目的写入数据
        方法print println  原样输出
        write方法走码表
    */
    private static void demoPrint() throws FileNotFoundException {
        File file = new File("c:\\demo\\1.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println(100);
        pw.close();
    }
}
