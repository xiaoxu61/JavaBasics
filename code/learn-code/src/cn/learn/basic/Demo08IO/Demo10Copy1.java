package cn.learn.basic.Demo08IO;
/*
    �ֽ��������ļ�
        �������黺�����Ч��
        �ֽ�����
        FileInputStream ��ȡ�ֽ�����
        FileOutputStream д�ֽ�����

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
            //�����ֽ����飬����
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        }catch (IOException ex) {
            throw new RuntimeException("�ļ�����ʧ��");
        }finally {
            try {
                if (fos != null)
                    fos.close();
            }catch (IOException ex) {
                throw new RuntimeException("�ļ��ر�ʧ��");
            }finally {
                try {
                    if (fis != null)
                        fis.close();
                }catch (IOException ex) {
                    throw new RuntimeException("�ļ��ر�ʧ��");
                }
            }
        }
    }
}
