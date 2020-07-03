package cn.learn.basic.Demo09Convert;
/*
    输入流的缓冲区流
        java.io.BufferedReader 继承 Reader
        读取功能read() 单个字符，字节数组
        构造方法：
            BufferedReader(Reader r)
            可以任意的字符输入流
            FileReader InputStreamReader

        BufferedReader自己的功能
        String readLine() 读取文本行 \r\n

        方法读取到流末尾，返回null
        小特点：
            获取内容的方法一般都有返回值
            int 没有返回都是负数
            引用类型 找不到返回null
            boolean 找不到返回false

            String s = null
            String s = "null"

            readLine() 方法返回行的有效字符，没有\r\n换行符
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo07BufferedReader {
    public static void main(String[] args) throws IOException {
        //创建字符输入流缓冲对象，构造方法传递字符输入流，包装数据源文件
        BufferedReader bfr = new BufferedReader(new FileReader("c:\\demo\\a.txt"));

        //调用缓冲流的方法readLine() 读取文本行

        /*String line = bfr.readLine();
        System.out.println(line);

        line = bfr.readLine();
        System.out.println(line);*/
        int lineNumber = 0;
        String line = null;
        while ((line = bfr.readLine()) != null) {
            lineNumber++;
            System.out.print(lineNumber + " " + line);
        }

        bfr.close();
    }
}
