package cn.learn.basic.Demo06;
/*
JDK 1.5 新特性，静态导入
目的：减少开发的代码量
*/

import static java.lang.System.out;
import static java.util.Arrays.sort;

public class Demo01StaticImport {
    public static void main(String[] args) {
        out.println();
        int[] arr = {1, 4, 6, 2, 1};
        sort(arr);

    }
}
