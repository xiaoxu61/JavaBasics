package cn.learn.basic.Demo08IO;
/*
    字符流复制【文本文件】，必须文本文件
    字符流查询本机默认的编码表，简体中文GBK
    FileReader 读取数据
    FileWriter写书到数据目的
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo12Copy {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("c:\\demo\\a.txt");
            fw = new FileWriter("c:\\demo\\b.txt");
            char[] ch = new char[1024];
            int len = 0;
            while ((len = fr.read(ch)) != -1) {
                fw.write(ch, 0, len);
                fw.flush();
            }
        }catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("文件复制失败");
        }finally {
            try {
                if (fw != null)
                    fw.close();
            }catch (IOException ex) {
                throw new RuntimeException("释放文件失败");
            }finally {
                try {
                    if (fr != null)
                        fr.close();
                }catch (IOException ex) {
                    throw new RuntimeException("释放文件失败");
                }
            }
        }
    }
}
