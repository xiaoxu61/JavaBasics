package cn.learn.Data.Basic;
/*
    存储顶点String 使用ArrayList 保存矩阵int[][]
图的深度优先遍历DepthFirstSearch：
    深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，深度优先遍历的策略就是首先访问第一个
邻接结点，然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点，可以这样理解：每次在访问完当前
结点后，首先访问当前结点的第一个邻接结点
    我们可以看到这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问
    显然深度优先搜索是一个递归的过程
    算法步骤：
        1访问初始结点v，并标记结点v为已访问
        2查找结点v的第一个邻接结点w
        3若w存在，则继续执行4，如果w不存在，则回到第一步，将从v的下一个结点继续
        4若w未被访问，对w进行深度优先遍历递归（即把w当作另一个v，然后进行步骤123
        5查找到结点v的w邻接结点的下一个邻接结点，转到步骤3

图的广度优先遍历
    图的广度优先搜索（BroadFirstSearch）类似于一个分层搜索的过程，广度优先遍历需要一个队列以保持
访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点
    广度优先遍历算法步骤：
        1访问初始点v并标记为结点v为已访问
        2结点v入队列
        3当队列非空时，继续执行，否则算法结束
        4出队列，取得队头结点u
        5查找结点u的第一个邻接结点w
        6若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
            6.1若结点w尚未被访问，则访问结点w并标记已访问
            6.2结点w入队列
            6.3查找结点的u的继w邻接结点的下一个邻接结点w，转到步骤6
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Demo15Tu {
    private ArrayList<String> vertexList; // 存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的个数

    //定义一个数组，记录某个结点是否被访问过
    private boolean[] isVisited;

    public static void main(String[] args) {
        //int n = 5;//结点个数
        //String[] VertexValue = {"A","B","C","D","E"};
        String[] VertexValue = {"1","2","3","4","5","6","7","8"};
        int n = VertexValue.length;
        //创建图对象
        Demo15Tu graph = new Demo15Tu(n);
        for (String s : VertexValue) {
            graph.insertVertex(s);
        }
        //添加边
        //A-B,A-C,B-C,B-D,B-E
        /*graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);*/

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,1);

        //显示一把邻接矩阵
        graph.showGraph();

        //dfs测试
        System.out.println("深度遍历：");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先");
        graph.bfs();
    }

    //构造器
    public Demo15Tu(int n) {
        //初始化矩阵和ArrayList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    //得到第一个邻接结点的下标 w
    /**
     * @param index
     * @return 如果存在就返回下标，否则返回-1
    */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u;//表示队列的头节点对应下标
        int w;//邻接结点的下标w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "->");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接结点的下标
            w = getFirstNeighbor(u);

            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记已访问
                    isVisited[w] = true;
                    //入队列
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接结点
                w = getNextNeighbor(u,w);//体现出广度优先
            }
        }
    }

    //遍历所有结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited,i);
            }
        }
    }

    //深度优先遍历算法 i可以理解第一次就是0
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将该结点设置为已经访问
        isVisited[i] = true;

        int w = getFirstNeighbor(i);

        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }

    }

    //对dfs进行重载，遍历我们所有的结点，并进行dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //显示图所对应的矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i（下标）对应的数据  0->A, 1->B, 2->C
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    /**
     * @param v1  表示点的下标，即是第几个顶点
     * @param v2  第二个顶点对应的下标
     * @param weight
     *
    */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
