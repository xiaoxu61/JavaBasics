package cn.learn.Data.Basic.CommonAlgorithm;
/*
    普利姆算法
        应用场景-修路问题
        A-------5--------B
       /  \             / \
      7     2         3     9
     /        \     /        \
    C            G            D
     \         /    \        /
      8      4        6     4
        \  /            \  /
          E------5--------F
          1、有胜利乡有7个村庄（A、B、C、D、E、F、G），现需要修路把7个村庄连通
          2、各个村庄的距离用边线表示（权），比如A-B距离5公里
          3、问：如何修路保证各个村庄都能连通，并且总的修建公路总里程最短？
            思路：将10条边，连接即可，当时总的里程数不是最小
            正确思路：尽可能地选择少地路线，并且每条路最小，保证总里程数最少
        1、假如从A开始处理原有集合<A>：A-C[7] A-G[2] A-B[5]  选取最小则 <A> ======> <A,G>
        2、<A,G>开始，将A和G顶点和他们相邻的还没有访问的顶点进行处理
            A-C[7] A-B[5] G-B[3] G-F[6] G-E[4]                      <A,G> ======> <A,G,B>
        3、<A,G,B>开始 A-C[7] G-F[6] G-E[4] B-D[9]                 <A,G,B> ======> <A,G,B,E>
        .
        .
        .
        <A,G,B,E,F,D,C>
    最小生成树：
        修路问题本质就是最小生成树问题，先介绍一下最小生成树（MinimumCostSpanningTree），简称MST
        1、给定一个带权地无向连通图，如何选取一棵生成树，使树上所有边上权的总和为最小，这叫最小生成数
        2、N个顶点，一定有N-1条边
        3、包含全部顶点
        4、N-1条边都在图中
        5、求最小生成数的算法主要是普利姆算法和克鲁斯卡尔算法
    普利姆算法介绍：
        1、普利姆算法求最小生成树，也就是在包含n个顶点的连通图中，找出只有（n-1）条边包含所有n个顶点的
    连通子图，也就是所谓的极小连通子图
        2、普利姆算法如下：
            1、设G=(V,E)是连通网，T=(U,D)是最小生成树，VU是顶点集合，ED是边的集合
            2、若从顶点u开始构造最小生成树，则从集合V中取出顶点u放入集合U中，标记顶点v的visited[u]=1
            3、若集合U中顶点ui与集合V-U中的顶点vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路
        将顶点vj加入集合U中，将边(ui,vj)加入集合D中，标记visited[vj]=1
            4、重复步骤2，直到U与V相等，即所有顶点都被标记为访问过，此时D中有n-1条边
            5、提示：单独看步骤很难理解，通过代码讲解
*/

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示
        int[][] weight = {
                          {10000,5,7,10000,10000,10000,2},
                          {5,10000,10000,9,10000,10000,3},
                          {7,10000,10000,10000,8,10000,10000},
                          {10000,9,10000,10000,10000,4,10000},
                          {10000,10000,8,10000,1000,5,4},
                          {10000,10000,10000,4,5,10000,6},
                          {2,3,10000,10000,4,6,10000}
                          };
        //创建MGraph对象
        MGraph mGraph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        //输出
        minTree.showGraph(mGraph);
        minTree.prim(mGraph, 0);

    }
}

//创建最小生成树->村庄的图
class MinTree{
    //创建图的邻接矩阵
    /**
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
    */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i,j;
        for (i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的方法
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树

    /**
     *
     * @param graph 图
     * @param v 表示从图的第一个顶点开始生成'A' -> 0, 'B' -> 1 .....
     */
    public void prim(MGraph graph, int v) {
        //visited[] 标记节点（顶点是否被访问过）
        int[] visited = new int[graph.verxs];//默认元素的值都是0，表示没有访问过

        //把当前这个节点标记为已访问
        visited[v] = 1;

        //用h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将minWeight初始成一个大数，后面在遍历过程中，会被替换
        for (int k = 1; k < graph.verxs; k++) {//因为有graph.verxs顶点，普利姆算法结束后，有graph.verxs-1条边

            //这个是确定每一次生成的子图，和哪个节点的距离最近
            for (int i = 0; i < graph.verxs; i++) {//i节点表示被访问过的节点
                for (int j = 0; j < graph.verxs; j++) {//j节点表示未访问过的节点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight（寻找已访问过的节点和未访问过的节点间的权值最小的边
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值：" + minWeight);
            //将当前这个节点标记为已经访问
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}

class MGraph{
    int verxs;//表示图的节点个数
    char[] data;//存放节点数据
    int[][] weight;//存放边，就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
