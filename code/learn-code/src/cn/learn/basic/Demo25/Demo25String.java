package cn.learn.basic.Demo25;
/*
java.lang.String类代表字符串
API当中说：Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
其实是说：程序当中所有的双引号字符串，都是String类的对象，（就算没有new 也照样是）

字符串的特点：
1、字符串的内容永不可变【重点】
2、正是因为字符串不可改变，所有字符串是可以共享使用的
3、字符串效果相当于是char []字符数组，但底层原理是byte [] 字节数组

创建字符串的常见3+1种方法
三种构造方法：
    1、public String()：创建一个空白字符串，不含任何内容
    2、public String(char[] array)：根据字符数组的内容，来创建对应的字符串
    3、public String(byte[] array)：根据字节数组的内容，来创建对应的字符串
    4、直接创建
*/

public class Demo25String {
    public static void main(String[] args) {
        //空参数构造
        String str1 = new String();
        System.out.println(str1);

        //根据字符数组创建字符串
        char[] charArray = {'a','d','e'};
        String str2 = new String(charArray);
        System.out.println(str2);

        //根据字节数组创建字符串
        byte[] byteArra = {97,98,99};
        String str3 = new String(byteArra);
        System.out.println(str3);

        /*
        字符串常量池，程序当中直接写上的双引号字符串，就在字符串常量池中。

        对于基本类型来说 == 是进行数值的比较
        对于引用类型来说 == 是进行地址值的比较   若要对字符串内容进行比较，可以使用两个方法
        public boolean equals(Object obj)：参数可以是任何对象，只有参数是一个字符串并且内容相同才会给true，否则返回false
        备注：任何对象都能用Object进行接收
              equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样
              如果比较双方一个常量一个变量，推荐把常量字符串写在前面
              推荐："abc".equals(str)   不推荐：str.equals("abc")
        public boolean equalsIgnoreCase(String str)：忽略大小写进行内容比较
        */
        String str4 = "Hello";
        String str5 = "Hello";
        char[] charArra = {'H','e','l','l','o'};
        String str6 = new String(charArra);
        System.out.println(str4.equals(str5));
        System.out.println(str5.equals(str6));
        System.out.println(str5.equals("Hello"));
        System.out.println("Hello".equals(str4));
        System.out.println("======================");
        String str7 = null;
        System.out.println("Hello".equals(str7));//推荐
        //System.out.println(str7.equals("Hello"));//不推荐：报错，空指针异常，NullPointerException
        System.out.println("=================");
        String strA = "Java";
        String strB = "java";
        System.out.println(strA.equals(strB));
        System.out.println(strA.equalsIgnoreCase(strB));
    }

}
