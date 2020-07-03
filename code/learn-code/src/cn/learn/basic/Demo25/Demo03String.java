package cn.learn.basic.Demo25;
/*
    String类特点：
        一切都是对象，字符串事物""，也是对象
        类是描述事物，String类，描述字符串对象的类
        所有的""，都是String类的对象

        字符串是一个常量，一旦创建不可更改
        将字节数组中的每个字节，查询了编码表，得到的结果
        字节是负数，汉字的字节编码就是负数，默认编码表，一个汉字两个字节

        String(byte[] bytes, int offset, int length)传递字节数组
            字节数组的一部分转成字符串
            offset数组的起始索引
            length取的个数，转几个
*/

public class Demo03String {
    public static void main(String[] args) {
        String str = "tiCast";
        System.out.println(str);

        str = "itHeiMa";
        System.out.println(str);

        function();
        function1();
        function_2();
        function_3();
        function_4();
        function_5();
        function_6();
    }
    /*
        byte[] getBytes() 将字符串转成字节数组
        此功能和String构造方法相反
        byte数组相关的功能，都会查询编码表
    */
    private static void function_6() {
        String s = "abc";

        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    /*
        int indexOf(char ch)
        查找一个字符，在字符串中第一次出现的索引
        被查找的字符不存在，返回-1
    */
    private static void function_5() {
        String s = "itCast.cn";

        int index = s.indexOf('x');
        System.out.println(index);
    }

    /*
        判断一个一个字符串中，是否包含另一个字符串
            boolean contains(String s)
    */
    private static void function_4() {
        String s = "itCast";

        boolean b = s.contains("Ca");
        System.out.println(b);
    }

    /*
        boolean startsWith(String prefix)
            判断一个字符串是不是另一个字符串的前缀，开头
        boolean endsWith(String prefix)
            判断一个字符串是不是另一个字符串的前缀，结尾
    */
    private static void function_3() {
        String s = "HowAreYou";
        boolean b = s.startsWith("H");
        System.out.println(b);

        boolean b1 = s.endsWith("ou");
        System.out.println(b1);
    }

    /*
        获取字符串的一部分：
            String substring(int beginIndex, int endIndex)
                包含头，不包含尾
            String substring(int beginIndex) 包含头，后面的字符全要
    */
    public static void function_2() {
        String s = "dfhdufvh14iufd";
        //调用String类方法substring获取字符串一部分
        System.out.println(s.substring(1,5));

        System.out.println(s.substring(5));
    }
    /*
        String(char[] value) 传递字符数组
        将字符数组，转成字符串，字符数组的参数，不查询编码表

        String(char[] bytes, int offset, int count)传递字节数组
    */
    public static void function1() {
        char[] ch = {'a','b','c'};

        String s = new String(ch);
        System.out.println(s);

        String s1 = new String(ch, 0, 2);
        System.out.println(s1);
    }
    /*
    定义方法：String类的构造方法
        String(byte[] bytes) 传递字节数组
            通过使用平台的默认字符集解码指定的byte数组，构造一个新的String
                平台：机器操作系统
                默认字符集：操作系统的默认编码表，默认编码表GBK
    */
    public static void function() {
        byte[] bytes = {-97, -98, -99, -100};
        String s = new String(bytes);
        System.out.println(s);

        byte[] bytes1 = {65, 66, 67, 68, 69};
        //调用String构造方法，传递组，传递两个int值
        String s1 = new String(bytes1, 1, 2);
        System.out.println(s1);
        //返回字符串长度
        System.out.println(s1.length());
    }
}
