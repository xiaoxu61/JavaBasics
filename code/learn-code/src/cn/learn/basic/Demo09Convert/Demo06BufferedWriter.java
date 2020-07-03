package cn.learn.basic.Demo09Convert;
/*
    字符输出流缓冲区流
        java.io.BufferedWriter 继承 Writer
        写入方法write()  单个字符，字符数组，字符串

        构造方法：
            BufferedWriter(Writer w) 传递任意字符输出流
            传递谁，就高效谁
                能传递的字符输出流FileWriter，OutputStreamWriter

        BufferedWriter 具有自己的特有方法
        void newLine() 写换行,运行结果和操作的相互关系
        方法具有平台无关性
        Windows 换行符 \r\n
        Linux   换行符 \n


*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo06BufferedWriter {
    public static void main(String[] args) throws IOException {
        //创建字符输出流，封装文件
        FileWriter fw = new FileWriter("c:\\demo\\buffer.txt");

        BufferedWriter bfw = new BufferedWriter(fw);

        bfw.write(100);
        bfw.flush();

        bfw.write("你好".toCharArray());
        bfw.newLine();
        bfw.flush();

        bfw.write("我好\r\n");
        bfw.flush();


        bfw.write("大家好");
        bfw.flush();

        bfw.close();
    }
}
