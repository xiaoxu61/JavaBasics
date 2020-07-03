package cn.learn.Data.Basic.CommonAlgorithm;
/*
克鲁斯卡尔算法
    1、用于求加权连通图的最小生成树的算法
    2、基本思想：按照权值从小到大的顺序选择n-1条边，并保证n-1条边不构成回路
    3、具体做法：首先构造一个只含n个顶点的森林，然后易权值从小到达连通网中选择加入到森林中，并使森林
       不产生回路，直到森林变成一棵树为止
       加入的边的两个顶点不能指向同一个终点，否则将构成回路
    应用场景-公交站问题
        B----10----C
      /   \      / | \
    12      7   6  |  3
    /        \ /   |   \
   A---16---- F    5    D
    \        / \   |   /
      14    9   2  |  4
        \  /     \ | /
          G---8----E
    1、某城市新增7个站点(A,B,C,D,E,F,G) 现需要修路把7个站点连通
    2、各个站点的距离用边线表示（权），比如A-B距离12公里
    3、问如何修路保证各个站点都能连通，并且总的修建公路里程最短

*/

import java.util.Arrays;

public class KruskalAlgorithm {
    private int edgeNum;//边的个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE;//INF表示两个顶点不能连通

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        //创建克鲁斯卡尔对象实例
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexs, matrix);
        kruskalAlgorithm.print();
        EData[] edges = kruskalAlgorithm.getEdges();
        System.out.println("排序前==>" + Arrays.toString(edges));
        kruskalAlgorithm.sortEdges(edges);
        System.out.println("排序后==>" + Arrays.toString(edges));
        kruskalAlgorithm.kruskal();






    }

    //构造器
    public KruskalAlgorithm(char[] vertexs, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertexs.length;

        //初始化顶点
        this.vertexs = new char[vlen];
        System.arraycopy(vertexs, 0, this.vertexs, 0, vertexs.length);

        //初始化边，使用的是复制copy的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, vlen);
        }

        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%10d\t",anInt);
            }
            System.out.println();
        }
    }

    public void kruskal() {
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//用于保存"已有最小生成树"中每个顶点在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] res = new EData[edgeNum];

        //获取图中所有的边的集合，一共有12条边
        EData[] edges = getEdges();
        //按照边的权值大小进行排序
        sortEdges(edges);

        //遍历edges数组，将边添加到最小生成树时，判断准备加入的边是否构成回路，如果没有就加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取到第i条边的第2个顶点
            int p2 = getPosition(edges[i].end);

            //获取p1这个顶点在已有的最小生成树中的终点
            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            //是否构成回路
            if (m != n) {//没有构成回路
                ends[m] = n;//设置m在“已有最小生成树”中的终点
                res[index++] = edges[i];//有一条边加入到res数组
            }
        }
        //统计并打印最小生成树
        System.out.println("最小生成树为");
        for (int i = 0; i < index; i++) {
            System.out.print(res[i] + " ");
        }
    }
    //对边进行排序
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    //传入顶点的值，返回该顶点对应的下标，如果找不到，则返回-1
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //获取图中的边，放入EData[]数组中，后面需要遍历该数组
    //通过matrix邻接矩阵来获取 EData[] --> 形式[['A','B',12],['B','F',7]...]
    private EData[] getEdges() {
        int index = 0;
        EData[] edges= new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //获取下标为i的顶点的终点，用于判断两个顶点的终点是否相同
    //i表示传入的顶点对应的下标
    //返回的就是下标为i的这个顶点对应的终点的下标
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

//创建一个类EData，他的对象实例就是表示一条边
class EData{
    char start;//边的一个点
    char end;//边的另外一个点
    int weight;//边的权值

    //构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //重写toString方法

    @Override
    public String toString() {
        return "EData{" +
                start +
                "-->" + end +
                " = " + weight +
                '}';
    }
}