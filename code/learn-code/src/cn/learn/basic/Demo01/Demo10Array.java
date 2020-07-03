package cn.learn.basic.Demo01;
/*
  数组的遍历
*/


public class Demo10Array {
    public static void main(String[] args) {

        int[] array = {11, 15, 6, 40};
        //使用循环，次数其实就是数组的长度
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
