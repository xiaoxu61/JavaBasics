package cn.learn.basic.Demo03;
/*
    数学计算的工具类
    java.lang.Math 静态方法组成
*/


public class Demo07Math {
    public static void main(String[] args) {
        function_1();
        function_2();
        function_3();
        function_4();
        function_5();
    }
    /*
        获取参数的四舍五入，取整数
        static double round(double d)
    */
    private static void function_5() {
        double d = Math.round(6.3);
        System.out.println(d);
    }

    /*
        static double random() 返回随机数0.0-1.0之间
            来源，也是Rando类
    */
    private static void function_4() {
        for (int i = 0; i < 10; i++) {
            double d = Math.random();
            System.out.println(d);
        }
    }

    /*
        static double pow(double a, double b)
            返回值：a的b次方

        static double sqrt(double a)
            返回参数的平方根
    */
    private static void function_3() {
        double d = Math.pow(2, 3);
        System.out.println(d);

        System.out.println(Math.sqrt(8));
    }

    /*
        static double ceil(double b)
            返回大于或者等于参数的最小整数
        static double floor(double b)
    */
    private static void function_2() {
        double d = Math.ceil(5.1);
        System.out.println(d);

        double d1 = Math.floor(5.1);
        System.out.println(d1);
    }

    /*
        static int abs(int i)
        获取参数的绝对值
    */
    private static void function_1() {
        int abs = Math.abs(-9);
        System.out.println(abs);
    }
}
