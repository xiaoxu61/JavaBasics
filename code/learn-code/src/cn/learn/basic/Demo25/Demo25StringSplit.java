package cn.learn.basic.Demo25;
/*
分割字符串的方法：
   public String[] split(String regex)：按照参数的规则，将字符串切成若干部分
   注意：split方法的参数其实是一个“正则表达式”，今后学习
   今天要注意：如果英文句点"."进行切分，必须写"\\."（两个反斜杠）
*/

public class Demo25StringSplit {
    public static void main(String[] args) {
        String str1 = "aaa,bbb,ccc";
        String[] array1 = str1.split(",");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(" 第" + i + "个：");
            System.out.print(array1[i]);
        }
        System.out.println();
        System.out.println("=================");
        String str2 = "aaa bbb ccc";
        String[] array2 = str2.split(" ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(" 第" + i + "个：");
            System.out.print(array2[i]);
        }
        System.out.println();
        System.out.println("==================");

        String str3 = "XXX.YYY.ZZZ";
        String[] array3 = str3.split(".");
        System.out.println(array3.length);
        for (int i = 0; i < array3.length; i++) {
            System.out.print(" 第" + i + "个：");
            System.out.print(array3[i]);
        }
        System.out.println("===========================");
        String[] array4 = str3.split("\\.");
        System.out.println(array4.length);
        for (int i = 0; i < array4.length; i++) {
            System.out.print(" 第" + i + "个：");
            System.out.print(array4[i]);
        }
    }
}
