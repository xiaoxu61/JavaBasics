package cn.learn.basic.Demo07Error;
/*
Throwable
 Exception 可治愈的错误，可将异常处理掉，可以继续执行
    JVM：
        1、创建了异常的对象
        2、将异常的对象进行抛出，扔出去了，抛给方法的调用者
        注意：一旦异常被抛出，后面的所有程序【不再执行】
 Error 问题较严重，必须修改程序才可运行
    JVM：
        1、将异常信息，以红色字体输出控制台
        2、将程序停止，结束

  编译异常：调用了抛出异常的方法，不处理编译失败（try throws）处理
  运行异常：抛出的异常时RuntimeException，或者是他的子类

  运行异常的特点：
        方法内部抛出的异常是运行异常，new XXXException
        方法的声明上，不需要throws语句，调用者，不需要处理
        设计原因：
            运行异常，不能发生，但是如果发生了，程序人员停止程序修改源代码

            运行异常：一旦发生，不要处理，请你修改源代码。运行异常一旦发生，后面的代码没有执行的意义


*/

public class Demo01 {
    public static void main(String[] args) throws Exception {
        int[] arr = null;
//        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException数组越界异常
//        int[] array = new int[999999999];//OutOfMemoryError 超界错误
//        System.out.println(array[3]);
        int i = demo01(arr);
        System.out.println(i);
    }
    /*
        异常中的关键字
            throw，在方法内部，抛出异常的对象
            throw后面，必须写new 对象，必须是异常的对象，必须是Exception或者子类

            方法中申明异常关键字：
                throws 用于方法的声明上，标明此方法可能出现异常，请调用者处理
                throws 后面必须写异常类的类名

               调用了一个抛出异常的方法，调用者就必须处理
               不处理，编译失败

    */
    private static int demo01(int[] arr) throws Exception {
        //对方法参数进行合法性的判断，进行判断是不是null
        if(arr == null) {
            //抛出异常的形式，告诉调用者
            //关键字throw
            throw new Exception("传递数组不存在");
        }
        //对数组进行判断，判断数组中是不是有元素
        if (arr.length == 0) {
            //抛出异常的形式，告诉调用者，数组没有元素
            throw new Exception("数组中没有任何元素");
        }
        int i = arr[arr.length - 1];
        return i*2;
    }
}
