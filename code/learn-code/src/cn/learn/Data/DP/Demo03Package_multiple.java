package cn.learn.Data.DP;
/*
    有N个物品和一个容量是V的背包
        第i种物品最多有s[i]件，每件体积是v[i]，价值是w[i]
        求解将哪些物品放入背包，可使物品总体积和不超过背包容量，且总价值最大
*/

import java.util.Arrays;

public class Demo03Package_multiple {
    public static void main(String[] args) {
        getValue(7);
        getMaxValue(7);
    }

    /**
     * 优化后的多重背包问题
     *      可以将物品的个数拆分后放到物品中，转化为01背包问题
     *      也就是说：第i种物品最多有s[i]件，每件体积是v[i]，价值是w[i]
     *            将s件物品添加到物品栏
     *      二进制的拆法：
     *          0
     *          1
     *          2
     *          3 = 1 + 2
     *          4 = 4
     *          5 = 1 + 4
     *          6 = 2 + 4
     *          7 = 1 + 2 + 4
     *     s最少把s分为多少个数，可以拼成小于等于s的数：log 以2为底的s，向上取整
     *
    */
    private static void getMaxValue(int N) {

    }

    /**
     * f[i]总体积是i的情况下，最大价值是多少
     *    for (int i = 0; i < V.length; i++) {
     *       for (int j = V[i]; j <= N; j++) {
     *           if (i == 0) {
     *               f[j] = 0;
     *           }else {
     *               f[j] = Math.max(f[j], f[j - V[i]] + W[i], f[j - 2*V[i]] + 2*W[i],...,f[j - s*V[i]] + s*W[i]);
     *           }
     *       }
     *     }
    */
    private static void getValue(int N) {
        int[] V = {0,2,3,4};//物品的容量
        int[] W = {0,3,4,5};//物品的价值
        int[] S = {0,2,2,1};//物品的个数
        int[] f = new int[N+1];

        for (int i = 0; i < V.length; i++) {
            for (int j = N; j >= 0; j--) {
                for (int k = 1; k <= S[i] && j >= k*V[i]; k++) {
                    f[j] = Math.max(f[j], f[j - k*V[i]] + k*W[i]);
                }
            }
        }
        System.out.println(f[N]);
        System.out.println(Arrays.toString(f));
    }
}
