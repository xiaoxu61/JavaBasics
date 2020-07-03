package cn.learn.basic.Demo08IO;
/*
    遍历目录，获取目录下所有.java文件
    遍历多级目录，方法递归实现
    遍历的过程，使用过滤器
*/

import java.io.File;

public class Demo07File {
    public static void main(String[] args) {
        getAllJava(new File("c:\\demo"));
    }
    /*
        定义方法，实现遍历指定目录
        获取目录中所有的.java文件
    */
    public static void getAllJava(File dir) {
        //调用File对象listFiles() 获取，加入过滤器
        File[] files = dir.listFiles(new MyFilter());
        for (File f : files) {
            //对f路径，判断是不是文件夹
            if (f.isDirectory()) {
                //递归进入文件夹遍历
                getAllJava(f);
            }else {
                System.out.println(f);
            }
        }
    }
}
