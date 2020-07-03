package cn.learn.basic.Demo01;
/*
  如何获取数组的长度
  格式：数组名称.length
  将会的到一个int数字，代表数组的长度。

  数组一旦创建，程序运行期间长度不可改变
*/

public class Demo09ArrayLength {
    public static void main(String[] args) {
        int[] arrayA = new int[3];
        int[] arrayB = {10, 20, 30, 3, 5, 6, 65,56, 564};
        int len = arrayB.length;
        System.out.println("arrayB数组的长度是：" + len);

        int[] arrayC = new int[3];
        System.out.println("arrayB数组的长度是：" + arrayC.length);
        arrayC = new int[5];
        System.out.println("arrayB数组的长度是：" + arrayC.length);
    }
}
