package cn.learn.Data.Basic.CommonAlgorithm;
/*
   迪杰斯特拉算法
        是典型最短路径算法，用于计算一个节点到其他节点的最短路径，他的主要特点是以起始点为中心向外层层
   扩展（广度优先搜索思想），直到扩展到终点为止
        设置出发顶点为v，顶点集合V(v1,v2,v3....)，v到V中各顶点的距离构成距离集合Dis，Dis(d1,d2,d3....)
   Dis集合记录着v到图中各个顶点的距离（到自身可以看作0，v到vi的距离对应为di）
        从Dis中选择值最小的di并移出Dis集合，同时移除V集合中对应的顶点vi，此时的v到vi即为最短路径
        更新Dis集合，更新规则为：比较v到V集合中顶点的距离值，与v通过vi到V集合中顶点的距离值，保留值较小
   的一个（同时也应该更新顶点的前驱节点为vi，表明是通过vi到达的）
        重复执行两步骤，直到最短路径为目标顶点即可结束
        应用场景-最短路径问题
        A-------5--------B
       /  \             / \
      7     2         3     9
     /        \     /        \
    C            G            D
     \         /    \        /
      8      4        6     4
        \  /            \  /
          E------5--------F
     1、战争时期，胜利乡有7个村庄A，B，C，D，E，F，G 现有六个邮差，需要分别把邮件分别送到这六个村庄
     2、问：如何计算出G村庄到各个村庄的最短距离
     3、如果从其他点出发到各个点的最短距离又是多少？
*/

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};
        //创建Graph
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        //测试
        graph.dsj(6);
    }
}

class Graph{
    private  char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;//已经访问顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void showGraph() {
        for (int[] link : matrix) {
            for (int i : link) {
                System.out.printf("%5d\t",i);
            }
            System.out.println();
        }
    }

    //迪杰斯特拉算法

    /**
     *
     * @param index 表示出发顶点对应的下标
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length,index);
        update(index);//更新index顶点到周围顶点的距离和前驱顶点

        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱顶点
        }
    }


    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    private void update(int index) {
        int len = 0;
        //根据遍历我们的邻接矩阵matrix[index]行
        for (int i = 0; i < matrix[index].length; i++) {
            //len含义是：出发顶点到index顶点的距离+从index顶点到i顶点的距离的和
            len = vv.getDis(index) + matrix[index][i];
            //如果i顶点没有被访问过，并且len小于出发顶点到i顶点的距离，就需要更新
            if (!vv.in(i) && len < vv.getDis(i)) {
                vv.updataPre(i,index);//更新i顶点的前驱为index顶点
                vv.updateDis(i,len);//更新出发顶点到i顶点的距离
            }
        }
    }
}

class VisitedVertex{
    //记录各个顶点是否访问过，1表示访问过，0未访问，会动态更新
    public int[] already_arr;
    //每个下标对应的值为前一个顶点下标，会更新动态
    public int[] pre_visited;
    //记录出发顶点到其他所有顶点的距离，比如G为出发顶点，就会记录G到其他顶点的距离，会动态更新
    //求得最短距离就会存放到dis
    public int[] dis;

    /**
     *
     * @param length 表示顶点的个数
     * @param index 出发顶点对应的下标，比如G顶点，下标就是6
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis,65535);
        this.already_arr[index] = 1;//设置出发顶点被访问过
        this.dis[index] = 0;//设置出发顶点的访问距离为0
    }

    /**
     * 判断index顶点是否被访问过
     * @param index
     * @return 如果访问过，就返回true，否则就返回false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新pre这个顶点的前驱顶点为index顶点
     * @param pre
     * @param index
     */
    public void updataPre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问节点，比如这里的G完后，就是A作为新的访问顶点（注意不是出发顶点）
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新index顶点被访问过
        already_arr[index] = 1;
        return index;
    }

    public void show() {
        System.out.println("=================");
    }
}