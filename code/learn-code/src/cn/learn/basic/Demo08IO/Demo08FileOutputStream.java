package cn.learn.basic.Demo08IO;
/*
    FileOutputStream�ļ�����д�ͻ�������
        ��д��FileOutputStream���췽�����ĵڶ��������У�����true
        ���ļ��У�д�뻻�У����Ż��У�\r\n
        \r\n ����д����һ�е�ĩβ��Ҳ����д����һ�еĿ�ͷ

    IO�����쳣����
    try catch finally
    ϸ�ڣ�
        1����֤������������������㹻
        2��catch���棬��ô�����쳣
            ����쳣��Ϣ�������������������
            ͣ�³������³���
        3�������������ʧ���ˣ���Ҫ�ر���Դ��
            new�����ʱ��ʧ���ˣ�û��ռ��ϵͳ��Դ
            �ͷ���Դ��ʱ�򣬶��������ж��ǲ���null
            ��������null���������ɹ�����Ҫ�ر���Դ
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo08FileOutputStream {
    public static void main(String[] args) {
        //try ��������������try���潨������
        FileOutputStream fos = null;
        try {
            File file = new File("c:\\demo\\b.txt");
            fos = new FileOutputStream(file, true);
            fos.write("Hello\r\n".getBytes());
            fos.write("World".getBytes());
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("�ļ�д��ʧ�ܣ�������");
        }finally {
            try {
                if (fos != null)
                fos.close();
            }catch (IOException ex){
                throw new RuntimeException("�ر���Դʧ��");
            }

        }




    }
}
