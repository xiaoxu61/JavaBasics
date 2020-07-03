package cn.learn.Data.DP;
/*
    01背包问题
        有N键物品和一个容量是V的背包
        第i件物品的体积是Vi，价值是Wi
        求解将那些物品装入背包，可以使得这些物品的总体积不超过背包容量，并且总价值最大

        输入格式：
            第一行两个整数，N，V，用空格隔开，分别表示物品的数量和背包容积
            接下来有N行，每行两个数V[i]，W[i]，用空格隔开，分别表示第i件物品的体积和价值
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

public class Demo01Package_01 {
    public static void main(String[] args) {
        getValue(7);
        getMaxValue(7);
    }

    /**
     * 优化空间复杂度后的01背包问题
     * <p>
     * 步骤：
     * 先初始化数组f[] = {0,0,0,0,0,0,0}  其中f[n]中的n代表背包的容量
     * 当有一个物品时 背包从最大容量到等于该物品体积大小时，背包所能得到的最大价值f[] = {0,0,3,3,3,3,3,3}
     * 当有两个物品时 背包从最大容量到等于该物品体积大小时。背包所能得到的最大价值f[] = {0,0,3,4,4,7,7,7}
     * 当有三个物品时 背包从最大容量到等于该物品体积大小时。背包所能得到的最大价值f[] = {0,0,3,4,5,7,8,9}
     */
    public static void getMaxValue(int N) {
        int[] V = {0, 2, 3, 4};
        int[] W = {0, 3, 4, 5};

        int f[] = new int[N + 1];
        for (int i = 0; i < V.length; i++) {
            for (int j = N; j >= V[i]; j--) {
                f[j] = Math.max(f[j], f[j - V[i]] + W[i]);
            }
        }

        System.out.println(Arrays.toString(f));

    }

    /**
     * 二维的动态规划
     * f[i][j] 表示只看前i个物品。总体积是j的情况下，总价值最大是多少
     * result = max{f[n][0~V]}
     * f[i][j]:
     * 1、不选第i个物品，f[i][j] = f[i-1][j]
     * 2、选第i个物品，f[i][j] = f[i-1][j - V[i]] + W[i]
     * f[i][j] = max{1,2} 转移方程
     * <p>
     * f[0][0] = 0;
     * @param N    背包容量
     * @return     最大总价值
     */
    public static void getValue(int N) {
        int[] V = {0, 2, 3, 4};
        int[] W = {0, 3, 4, 5};

        int f[][] = new int[V.length][N + 1];
        /*for (int i = 1; i < V.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    f[i][j] = 0;
                }else {
                    f[i][j] = f[i - 1][j];
                }
                if (j >= V[i]) {
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j - V[i]] + W[i]);
                }
            }
        }*/
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < V.length; j++) {
                if (i == 0 || j == 0) {
                    f[j][i] = 0;
                } else {
                    f[j][i] = f[j - 1][i];
                    if (i >= V[j]) {
                        f[j][i] = Math.max(f[j - 1][i], f[j - 1][i - V[j]] + W[j]);
                    }
                }
            }
        }

        System.out.println(f[V.length - 1][N]);
    }

}
