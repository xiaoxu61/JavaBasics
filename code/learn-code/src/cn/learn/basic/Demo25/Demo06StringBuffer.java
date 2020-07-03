package cn.learn.basic.Demo25;


public class Demo06StringBuffer {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("weefdw");
        function();
        function_1();
        function_2();
        function_3();
        function_4();
        function_5();
    }
    /*
        String tostring() 继承Object，重写toString
        将缓冲区的所有字符变成字符串
    */
    private static void function_5() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.append(123465);
        System.out.println(buffer);
        //将可变的缓冲区对象，变成了不可变的String对象
        String s = buffer.toString();
        System.out.println(s);
    }

    /*
        reverse() 将缓冲区的字符反转
    */
    private static void function_4() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.reverse();
        System.out.println(buffer);
    }

    /*
        replace(int start, int end, String str)
        将指定的索引范围内所有字符，替换成新的字符串
    */
    private static void function_3() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.replace(2,6, "QQ");
        System.out.println(buffer);
    }

    /*
        insert(int index, 任意类型)
            将任意类型数据，插入到缓冲区的指定索引上
    */
    public static void function_2() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        buffer.insert(5, 5.5);
        System.out.println(buffer);
    }
    /*
        delete(int start, int end) 删除缓冲区字符
    */
    private static void function_1() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("abcdef");
        System.out.println(buffer);
        buffer.delete(1,5);
        System.out.println(buffer);
    }

    /*
        StringBuffer append,将任意类型的数据，添加缓冲区
        返回值 return this
        调用者是谁，返回值就是谁
    */
    public static void function() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(6).append(false);
        System.out.println(buffer);
    }
}
