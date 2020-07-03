package cn.learn.Data.Basic.CommonAlgorithm;
/*
背包问题：
    有一个背包，容量为4磅，现有如下物品
    物品    重量     价格
    吉他     1       1500
    音响     4       3000
    电脑     3       2000
 1、要求达到的目标围为装入的背包的总价值最大，并且重量不超出
 2、要求装入的物品不能重复
    W[i] 和 V[i] 来确定是否需要将该物品放入到背包中，V[i] W[i]分别为第i个物品的价值和重量，C为背包的容量
再令V[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值，则我们有下面的结果：
    1、V[i][0] = V[0][j] = 0; 表示填入表 第一行和第一列是0
    2、当W[i] > j 时，V[i][j] = V[i-1][j]; 当准备加入新增的商品的容量大于当前背包的容量时，就直接
使用上一个单元的装入策略
    3、当j >= W[i]时：V[i][j] = max{ V[i-1][j], V[i]+V[i-1][j-W[i]] }
    //当准备加入的新增的商品的容量小于等于当前背包的容量，
    //装入的方式：
        V[i-1][j]: 就是上一个单元格的装入的最大值
        V[i]: 表示当前商品的价值V[i-1][j-W[i]]: 装入i-1商品，到剩余空间j-W[i]
*/

import java.util.Arrays;

public class Package {
    public static void main(String[] args) {
        int [] w = {0,1,4,3};//物品的重量
        int [] val = {0,1500,3000,2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数



        //创建二维数组
        int[][] v = new int[n][m+1];
        //为了记录商品的情况，定义一个二维数组
        int[][] path = new int[n][m+1];

        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++ ) {
            v[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i] > j) {
                    v[i][j] = v[i-1][j];
                }else {
                    //v[i][j] = Math.max(v[i-1][j],v[i-1][j-w[i]] + val[i]);
                    //为了记录商品背包的情况
                    if (v[i-1][j] < (v[i-1][j-w[i]] + val[i])) {
                        v[i][j] = v[i-1][j-w[i]] + val[i];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        show(v);
        System.out.println("物品存放方法：");
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i];
            }
            i--;
        }
    }

    public static void show(int[][] v) {
        for (int[] arr : v) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
