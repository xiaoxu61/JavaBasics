package cn.learn.basic.Demo08IO;
/*
    �Զ��������
    ʵ��FileFilter�ӿڣ���д���󷽷�
*/

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        /*
            pathname ���յ���Ҳ���ļ���ȫ·��
            c:\\demo\\1.txt
            ��·�������жϣ������java�ļ�������true������java�ļ�������false
            �ļ��ĺ�׺��β��  .java
        */
        //�жϻ�ȡ����Ŀ¼��ֱ�ӷ���true
        if (pathname.isDirectory())
            return true;
        String name = pathname.getName();
        return name.toLowerCase().endsWith(".java");
    }
}
