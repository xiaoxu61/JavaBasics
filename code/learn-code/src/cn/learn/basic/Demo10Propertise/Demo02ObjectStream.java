package cn.learn.basic.Demo10Propertise;
/*
    IO流对象，实现Person对象序列化，和反序列化
    ObjectOutputStream 写对象，实现序列化
    ObjectInputStream  读取对象，实现反序列化

    注意：静态不能序列化
    transient 阻止成员变量进行序列化，在方法类中
*/

import java.io.*;


public class Demo02ObjectStream {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
//        writeObject();
        readObject();

    }
    /*
        ObjectInputStream
        构造方法：ObjectInputStream(InputStream in)
        传递任意字节的输入流，输入流封装文件，必须是序列化的文件
        Object readObject() 读取对象返回Object
    */
    private static void readObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("c:\\demo\\person.txt");
        //创建反序列化流，构造方法中，传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(fis);
        //调用反序列化流的方法readObject() 读取对象
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
    }

    /*
            ObjectOutputStream
            构造方法：ObjectOutputStream(OutputStream out)
            传递任意的字节输出流
            void writeObject(Object obj) 写出对象的方法
        */
    private static void writeObject() throws IOException {
        //创建字节输出流，封装文件
        FileOutputStream fos = new FileOutputStream("c:\\demo\\person.txt");
        //创建写出对象的序列化流的对象，构造方法传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person p = new Person("lisi", 25);
        //调用序列化对象的方法writeObject，写出对象
        oos.writeObject(p);
        fos.close();

    }


}
