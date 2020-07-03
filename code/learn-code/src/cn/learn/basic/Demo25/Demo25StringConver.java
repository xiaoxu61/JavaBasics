package cn.learn.basic.Demo25;
/*
String 当中与转换相关的常用方法：
   public char[] toCharArray：将当前字符串拆分成字符串字数作为返回值
   public byte[] getByte()：获得当前字符串底层的字节数组
   public String replace(CharSequence oldString, CharSequence newString)：将所有出现的老字符串替换为新的字符串
      返回替换之后的结果新字符串.备注：CharSequence意思就是说可以接受字符串类型。
*/

public class Demo25StringConver {
    public static void main(String[] args) {
        //转换成字符串数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);//H
        System.out.println(chars.length);
        System.out.println("=================");

        //转换成字节数组
        byte[] bytes = "ABC".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("========================");
        //字符串内容替换
        String str1 = "How do you do?";
        String str2 = str1.replace("o", "*");
        System.out.println(str1);
        System.out.println(str2);

        String lang1 = "会不会玩啊！你大爷的!你大爷的！你大爷的！ ";
        String lang2 = lang1.replace("你大爷的","口吐芬芳");
        System.out.println(lang2);
    }
}
