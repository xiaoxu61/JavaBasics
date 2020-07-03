package cn.learn.basic.Demo08IO;
/*
    FileOutputStream文件的续写和换行问题
        续写：FileOutputStream构造方法，的第二个参数中，加入true
        在文件中，写入换行，符号换行：\r\n
        \r\n 可以写在上一行的末尾，也可以写在下一行的开头

    IO流的异常处理
    try catch finally
    细节：
        1、保证流对象变量，作用域足够
        2、catch里面，怎么处理异常
            输出异常信息，看到哪里出现了问题
            停下程序，重新尝试
        3、如果流对象建立失败了，需要关闭资源吗
            new对象的时候，失败了，没有占用系统资源
            释放资源的时候，对流对象判断是不是null
            变量不是null，对象建立成功，需要关闭资源
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo08FileOutputStream {
    public static void main(String[] args) {
        //try 外面声明变量，try里面建立对象
        FileOutputStream fos = null;
        try {
            File file = new File("c:\\demo\\b.txt");
            fos = new FileOutputStream(file, true);
            fos.write("Hello\r\n".getBytes());
            fos.write("World".getBytes());
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("文件写入失败，请重试");
        }finally {
            try {
                if (fos != null)
                fos.close();
            }catch (IOException ex){
                throw new RuntimeException("关闭资源失败");
            }

        }




    }
}
