package cn.learn.basic.Demo08IO;
/*
    FileOutputStream
        д�������ļ���ѧϰ���෽����ʹ���������

        �����еĹ��췽�������ã�����������Ŀ��
            ������
                File  ��װ�ļ�
                String �ַ������ļ���
    ʹ�ò��裺
        1��������������󣬰����ݶ���
        2������������ķ���writeд
        3��close�ͷ���Դ
    ע�⣺������Ĺ��췽��������ļ������ڣ����Դ����ļ�������ļ����ڣ�ֱ�Ӹ���
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo08FileOutoutStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("c:\\demo\\b.txt");
        //�����󣬵ķ���writeд����
        //дһ���ֽ�
        fos.write(97);

        fos.write(49);
        fos.write(48);
        fos.write(48);
        //�ֽ�����
        byte[] bytes = {65, 66, 67, 68};
        fos.write(bytes);
        //д�����е�һ����
        fos.write(bytes, 2, 2);

        //д���ֽ�����ļ�㷽ʽ
        //д���ַ���
        fos.write("hello".getBytes());
        //�ر���Դ
        fos.close();

    }
}
