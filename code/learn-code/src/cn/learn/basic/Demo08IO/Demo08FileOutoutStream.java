package cn.learn.basic.Demo08IO;
/*
    FileOutputStream
        写入数据文件，学习父类方法，使用子类对象

        子类中的构造方法：作用：绑定输出的输出目的
            参数：
                File  封装文件
                String 字符串的文件名
    使用步骤：
        1、创建流子类对象，绑定数据对象
        2、调用流对象的方法write写
        3、close释放资源
    注意：流对象的构造方法：如果文件不存在，可以创建文件；如果文件存在，直接覆盖
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo08FileOutoutStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("c:\\demo\\b.txt");
        //流对象，的方法write写数据
        //写一个字节
        fos.write(97);

        fos.write(49);
        fos.write(48);
        fos.write(48);
        //字节数组
        byte[] bytes = {65, 66, 67, 68};
        fos.write(bytes);
        //写数组中的一部分
        fos.write(bytes, 2, 2);

        //写入字节数组的简便方式
        //写入字符串
        fos.write("hello".getBytes());
        //关闭资源
        fos.close();

    }
}
