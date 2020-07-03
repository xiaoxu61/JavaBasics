package cn.learn.basic.Demo01;
/*
  面向过程：当需要实现一个功能的时候，每一个具体的步骤都要亲力亲为，详细处理每一个细节
  面向对象：当需要实现一个功能的时候，不关心具体的步骤，而是找一个具有该功能的人，来帮我做事

*/

import java.util.Arrays;

public class Demo14PrintArray {
    public static void main(String[] args) {
        int[] array = {10, 2, 5, 6};

        //要求打印格式为：[10,2,5,6]
        //使用面向过程
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                System.out.println(array[i] + "]");
            }else {
                System.out.print(array[i] + ", ");
            }
        }
        //使用面向对象
        //找一个JDK给我们提供好的Arrays类
        //其中有一个toString方法，直接就能把数组变成想要的格式字符串
        System.out.println(Arrays.toString(array));

    }
}
