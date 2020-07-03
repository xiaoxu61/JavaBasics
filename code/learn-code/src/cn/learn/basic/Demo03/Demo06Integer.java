package cn.learn.basic.Demo03;
/*
装箱：把基本类型的数据，包装到包装类中（基本类型数据 --> 包装类）
    构造方法：
        Integer(int value)构造一个新分配的 Integer 对象，它表示指定的int值
        Integer(String s) 构造一个新分配的 Integer 对象，它表示String参数所指示的int值
            传递的字符串必须是，基本类型的字符串，否则会抛出异常，例如："100"正确，"a"抛异常
    静态方法：
        static Integer valueOf(int i)返回一个表示指定的 int 值的Integer实例
        static Integer valueOf(String s) 返回指定的 String 的值的 Integer对象
拆箱：在包装类中取出基本类型的数据  包装类 --> 基本类型的数据
    成员方法
        int intValue() 以 int类型返回该Integer值
*/

public class Demo06Integer {

    public static void main(String[] args) {
        //装箱
        Integer in1 = new Integer(1);//方法上有横线，说明方法过时了
        System.out.println(in1);

        Integer in2 = new Integer("2");
        System.out.println(in2);

        //静态方法
        Integer in3 = Integer.valueOf(1);
        Integer in31 = Integer.parseInt("2");
        System.out.println(in3 + in31);

//        Integer in4 = Integer.valueOf("a");//error:NumberFormatException数据格式化异常
        Integer in4 = Integer.valueOf("1");
        System.out.println(in4);

        //拆箱
        int i = in1.intValue();
        System.out.println(i);

        //Integer类的静态成员变量
        //MAX_VALUE MIN_VALUE
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        //三个静态方法
        //进制转换
        //十进制转成二进制 toBinaryString(int)
        //十进制转成八进制 toOctalString(int)
        //十进制转成16进制 toHexString(int)
        //三个方法返回值都是String形式出现
        System.out.println(Integer.toBinaryString(99));
        System.out.println(Integer.toOctalString(99));
        System.out.println(Integer.toHexString(999));

    }

}
