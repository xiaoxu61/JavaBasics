package cn.learn.Data.DP;
/*
    完全背包问题
        有N种物品和一个容量是V的背包，每种物品都有无限件可用
        第i种物品的体积是V[i]，价值是W[i]
        求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且价值最大
    输入格式：
        第一行两个整数，N，V 用空格隔开，分别表示物品数和背包容积
        接下来有N行， 每行两个整数V[i]，W[i] 用空格隔开，分别表示第i种物品的体积和价值
    输出格式：
        输出一个整数，表示最大价值
     数据范围：
            0 < N, V <= 1000
            0 < V[i], W[i] <= 1000
        输入样例：
            4 5
            1 2
            2 4
            3 4
            4 5
        输出样例：
            8
*/

import java.util.Arrays;

public class Demo02Package_all {
    public static void main(String[] args) {
        getValue(7);
        getMaxValue(7);
    }

    /**
     * f[i]表示 总体积是i的情况下，最大价值是多少
     * result = max{f[0~m]}
     *
     * for (int i = 0; i < V.length; i++) {
     *             for (int j = V[i]; j <= m; j++) {
     *                f[j] = Math.max(f[j],f[j - V[i]] + W[i]);
     *             }
     *             for (int j = m; j >= V[i]; j--) {
     *                 for (int k = 0; k*V[i] <= m; k++) {
     *                     f[j] = max{f[j], f[j - k*V[i]] + k*W[i]}
     *                 }
     *             }
     *         }
     *
     * 数学归纳法：
     *     1、假设考虑前i-1个物品之后，所有的f[j]都是正确的
     *     2、来证明：考虑完第i和物品之后，所有的f[j]也都是正确的
     * 以背包为0~7的容量大小为例，放入物品后的结果如下：
     *   {0,0,0,0,0,0,0,0}  前0个物品
     *   {0,0,3,3,6,6,9,9}  前1物品放入时
     *   {0,0,3,4,6,7,9,10} 前两个物品放入时
     *   {0,0,3,4,6,7,9,10} 前三个物品放入时
     *
     *  对于某个j而言，如果最优解中包含k个V[i]
    */
    public static void getMaxValue(int N) {
        int[] V = {0,2,3,4};
       int[] W = {0,3,4,5};
        int f[] = new int[N+1];

        for (int i = 0; i < V.length; i++) {
            for (int j = V[i]; j <= N; j++) {
                if (i == 0) {
                    f[j] = 0;
                }else {
                    f[j] = Math.max(f[j],f[j - V[i]] + W[i]);
                }
            }
        }
        System.out.println(f[N]);
        System.out.println(Arrays.toString(f));
    }

    /**
     * 用二维思想解决完全背包问题
     *      状态转移方程：f[i][j] = max{f[i-1][j],f[i-1][j-k*V[i]] + W[i]}
     *      初始化：f[0][0] = 0;
    */
    public static void getValue(int N) {
        int[] V = {0,2,3,4};
        int[] W = {0,3,4,5};
        int f[][] = new int[V.length][N+1];

        for (int i = 0; i < V.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0 || i == 0) {
                    f[i][j] = 0;
                }else {
                    f[i][j] = f[i-1][j];
                    if (j >= V[i]) {
                       // int max = 0;
                        for (int k = 1; j >= k * V[i]; k++) {
                            //if (max < f[i-1][j - k*V[i]] + k*W[i]) {
                               // max = f[i - 1][j - k * V[i]] + k * W[i];
                           // }
                            f[i][j] = Math.max(f[i][j],f[i - 1][j - k * V[i]] + k * W[i]);
                        }
                        //f[i][j] = Math.max(f[i-1][j],max);
                    }
                }
            }
        }
        System.out.println(f[V.length - 1][N]);
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
    }
}
