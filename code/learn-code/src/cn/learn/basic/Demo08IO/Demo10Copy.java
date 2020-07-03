package cn.learn.basic.Demo08IO;
/*
    ������Դ��c:\\a.txt
    ���Ƶ� d:\\a.txt ����Ŀ��
    �ֽ���������������Դ
    �ֽ��������������Ŀ��

    ���룺��ȡһ���ֽ�
    �����дһ���ֽ�
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo10Copy {
    public static void main(String[] args) {
        //��������������ı���
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //���������������Ķ��󣬰�����Դ������Ŀ��
            fis = new FileInputStream("c:\\eclipse\\plugins.rar");
            fos = new FileOutputStream("c:\\demo\\t.rar");
            //�ֽ���������һ���ֽڣ������дһ���ֽ�
            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
        }catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("�ļ�����ʧ��");
        }finally {
            try {
                if (fos != null)
                    fos.close();
            }catch (IOException ex) {
                throw new RuntimeException("�ͷ���Դʧ��");
            }finally {
                try {
                    if (fis != null)
                        fis.close();
                }catch (IOException ex) {
                    throw new RuntimeException("�ͷ���Դʧ��");
                }
            }
        }
    }
}
