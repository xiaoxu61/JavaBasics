package cn.learn.basic.Demo08IO;
/*
    对一个目录下的所有内容，进行完全的遍历
*/

import java.io.File;

public class Demo05File {
    public static void main(String[] args) {
        File file = new File("c:\\demo");
        getAllDir(file);
    }
    /*
        定义方法实现目录的全遍历
    */
    public static void getAllDir(File file) {
        System.out.println(file);
        //调用方法listFiles() 对目录，dir进行遍历
        File[] fileArr = file.listFiles();
        for (File file1 : fileArr) {
            if (file1.isDirectory()) {
                getAllDir(file1);//方法的递归调用
            }else {
                System.out.println(file1);
            }

        }
    }
}
