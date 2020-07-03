package cn.learn.basic.Demo08IO;
/*
    将数据源：c:\\a.txt
    复制到 d:\\a.txt 数据目的
    字节输入流，绑定数据源
    字节输出流，绑定数据目的

    输入：读取一个字节
    输出：写一个字节
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo10Copy {
    public static void main(String[] args) {
        //定义两个流对象的变量
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //建立两个数据流的对象，绑定数据源和数据目的
            fis = new FileInputStream("c:\\eclipse\\plugins.rar");
            fos = new FileOutputStream("c:\\demo\\t.rar");
            //字节输入流读一个字节，输出流写一个字节
            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
        }catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("文件复制失败");
        }finally {
            try {
                if (fos != null)
                    fos.close();
            }catch (IOException ex) {
                throw new RuntimeException("释放资源失败");
            }finally {
                try {
                    if (fis != null)
                        fis.close();
                }catch (IOException ex) {
                    throw new RuntimeException("释放资源失败");
                }
            }
        }
    }
}
