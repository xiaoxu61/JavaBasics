package cn.learn.basic.Demo01;

/*
   ASCII编码表演示
   字符Java 数据类型，char
   整数Java 数据类型，int

   int类型和char数据类型转换
   char 两个字节，int四个字节
   char转成int类型的时候，属于类型自动提升，char数据类型，会查询编码表，得到整数
   int转成char类型的时候，强制转换，会查询编码表

   char存储汉字，查询Unicode编码表

   char可以和int计算，提升为int类型，内存中两个字节
   char 取值范围0~65535
 */
public class ASCIIDemo {
    public static  void main(String[] args){
        char c = 'a';
        int i = c + 1;
        System.out.println(i);

        int j = 90;
        char h = (char)j;
        System.out.println(h);
        System.out.println((char)6);

        char k = '你';
        System.out.println(k);

        char b = 32766;

    }
}
