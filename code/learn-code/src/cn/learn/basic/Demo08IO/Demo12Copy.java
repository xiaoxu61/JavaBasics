package cn.learn.basic.Demo08IO;
/*
    �ַ������ơ��ı��ļ����������ı��ļ�
    �ַ�����ѯ����Ĭ�ϵı������������GBK
    FileReader ��ȡ����
    FileWriterд�鵽����Ŀ��
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
            throw new RuntimeException("�ļ�����ʧ��");
        }finally {
            try {
                if (fw != null)
                    fw.close();
            }catch (IOException ex) {
                throw new RuntimeException("�ͷ��ļ�ʧ��");
            }finally {
                try {
                    if (fr != null)
                        fr.close();
                }catch (IOException ex) {
                    throw new RuntimeException("�ͷ��ļ�ʧ��");
                }
            }
        }
    }
}
