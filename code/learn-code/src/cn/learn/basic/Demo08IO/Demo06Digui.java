package cn.learn.basic.Demo08IO;
/*
    方法自己调用自己
    适用于，方法中运算的主题不变，但是运行的时候，参与运行的方法参数会变化
    注意：
        递归一定要有出口，必须可以让程序停下来
        递归次数不能过多
        构造方法，禁止递归
*/

public class Demo06Digui {
    public static void main(String[] args) {
        System.out.println(getSum(100));
        System.out.println(getJieCheng(5));
        System.out.println(getFBNQ(12));
    }
    /*
        方法的递归，计算斐波拉契数列
    */
    public static int getFBNQ(int month) {
        if (month == 1)
            return 1;
        if (month ==2)
            return 1;
        return getFBNQ(month - 1) + getFBNQ(month -2);
    }
    /*
        计算阶乘
            5*4*3*2*1
    */
    public static int getJieCheng(int n) {
        if (n == 1)
            return 1;
        return n*getJieCheng(n -1);
    }
    /*
        计算1加到100的和
        计算规律：
            n + (n-1) + (n -2) + ... + 1
    */
    public static int getSum(int n) {
        if (n == 1){
            return 1;
        }
        return n + getSum(n - 1);
    }
}
