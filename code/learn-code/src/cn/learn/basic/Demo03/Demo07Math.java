package cn.learn.basic.Demo03;
/*
    ��ѧ����Ĺ�����
    java.lang.Math ��̬�������
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
        ��ȡ�������������룬ȡ����
        static double round(double d)
    */
    private static void function_5() {
        double d = Math.round(6.3);
        System.out.println(d);
    }

    /*
        static double random() ���������0.0-1.0֮��
            ��Դ��Ҳ��Rando��
    */
    private static void function_4() {
        for (int i = 0; i < 10; i++) {
            double d = Math.random();
            System.out.println(d);
        }
    }

    /*
        static double pow(double a, double b)
            ����ֵ��a��b�η�

        static double sqrt(double a)
            ���ز�����ƽ����
    */
    private static void function_3() {
        double d = Math.pow(2, 3);
        System.out.println(d);

        System.out.println(Math.sqrt(8));
    }

    /*
        static double ceil(double b)
            ���ش��ڻ��ߵ��ڲ�������С����
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
        ��ȡ�����ľ���ֵ
    */
    private static void function_1() {
        int abs = Math.abs(-9);
        System.out.println(abs);
    }
}
