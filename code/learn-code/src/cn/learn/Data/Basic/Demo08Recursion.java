package cn.learn.Data.Basic;
/*
�ݹ�

*/

public class Demo08Recursion {
    public static void main(String[] args) {
        test(4);

        int i = factorial(50);
        System.out.println(i);
    }

    //��ӡ����
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n="+n);
    }

    //�׳�����
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }
}
