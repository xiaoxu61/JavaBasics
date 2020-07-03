package cn.learn.basic.Demo10Propertise;
/*
    IO������ʵ��Person�������л����ͷ����л�
    ObjectOutputStream д����ʵ�����л�
    ObjectInputStream  ��ȡ����ʵ�ַ����л�

    ע�⣺��̬�������л�
    transient ��ֹ��Ա�����������л����ڷ�������
*/

import java.io.*;


public class Demo02ObjectStream {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
//        writeObject();
        readObject();

    }
    /*
        ObjectInputStream
        ���췽����ObjectInputStream(InputStream in)
        ���������ֽڵ�����������������װ�ļ������������л����ļ�
        Object readObject() ��ȡ���󷵻�Object
    */
    private static void readObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("c:\\demo\\person.txt");
        //���������л��������췽���У������ֽ�������
        ObjectInputStream ois = new ObjectInputStream(fis);
        //���÷����л����ķ���readObject() ��ȡ����
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
    }

    /*
            ObjectOutputStream
            ���췽����ObjectOutputStream(OutputStream out)
            ����������ֽ������
            void writeObject(Object obj) д������ķ���
        */
    private static void writeObject() throws IOException {
        //�����ֽ����������װ�ļ�
        FileOutputStream fos = new FileOutputStream("c:\\demo\\person.txt");
        //����д����������л����Ķ��󣬹��췽�������ֽ������
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person p = new Person("lisi", 25);
        //�������л�����ķ���writeObject��д������
        oos.writeObject(p);
        fos.close();

    }


}
