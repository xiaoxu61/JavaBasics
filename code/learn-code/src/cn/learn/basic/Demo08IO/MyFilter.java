package cn.learn.basic.Demo08IO;
/*
    自定义过滤器
    实现FileFilter接口，重写抽象方法
*/

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        /*
            pathname 接收到的也是文件的全路径
            c:\\demo\\1.txt
            对路径进行判断，如果是java文件，返回true，不是java文件，返回false
            文件的后缀结尾是  .java
        */
        //判断获取的是目录，直接返回true
        if (pathname.isDirectory())
            return true;
        String name = pathname.getName();
        return name.toLowerCase().endsWith(".java");
    }
}
