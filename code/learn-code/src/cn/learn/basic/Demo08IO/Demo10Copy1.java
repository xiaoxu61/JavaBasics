package cn.learn.basic.Demo08IO;
/*
    字节流复制文件
        采用数组缓冲提高效率
        字节数组
        FileInputStream 读取字节数组
        FileOutputStream 写字节数组

*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo10Copy1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("c:\\eclipse\\plugins.rar");
            fos = new FileOutputStream("c:\\demo\\t.rar");
            //定义字节数组，缓冲
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        }catch (IOException ex) {
            throw new RuntimeException("文件复制失败");
        }finally {
            try {
                if (fos != null)
                    fos.close();
            }catch (IOException ex) {
                throw new RuntimeException("文件关闭失败");
            }finally {
                try {
                    if (fis != null)
                        fis.close();
                }catch (IOException ex) {
                    throw new RuntimeException("文件关闭失败");
                }
            }
        }
    }
}
