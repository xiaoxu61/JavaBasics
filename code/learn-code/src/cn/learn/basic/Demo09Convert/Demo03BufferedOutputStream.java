package cn.learn.basic.Demo09Convert;
/*
    字节输出流的缓冲流
        java.ui.BufferedOutputStream 作用：提高原有输出流的写入效率
        BufferedOutputStream 继承 OutputStream
        方法，写入write 字节，字节数组

        构造方法：
            BufferedOutputStream(OutputStream out)
                可以传递任意的字节输出流，传递的是哪个字节流，就对哪个字节流提高效率

            FileOutputStream
*/

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("c:\\demo\\buffer.txt");

        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(55);

        byte[] bytes = "HelloWorld\r\n".getBytes();
        bos.write(bytes);

        bos.write(bytes, 3, 2);

        bos.close();
    }
}
