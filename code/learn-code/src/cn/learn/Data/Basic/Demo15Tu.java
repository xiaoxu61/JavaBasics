package cn.learn.Data.Basic;
/*
    �洢����String ʹ��ArrayList �������int[][]
ͼ��������ȱ���DepthFirstSearch��
    ������ȱ������ӳ�ʼ���ʽ���������ʼ���ʽ������ж���ڽӽ�㣬������ȱ����Ĳ��Ծ������ȷ��ʵ�һ��
�ڽӽ�㣬Ȼ��������������ʵ��ڽӽ����Ϊ��ʼ��㣬�������ĵ�һ���ڽӽ�㣬����������⣺ÿ���ڷ����굱ǰ
�������ȷ��ʵ�ǰ���ĵ�һ���ڽӽ��
    ���ǿ��Կ��������ķ��ʲ����������������ھ����룬�����Ƕ�һ�����������ڽӽ����к������
    ��Ȼ�������������һ���ݹ�Ĺ���
    �㷨���裺
        1���ʳ�ʼ���v������ǽ��vΪ�ѷ���
        2���ҽ��v�ĵ�һ���ڽӽ��w
        3��w���ڣ������ִ��4�����w�����ڣ���ص���һ��������v����һ��������
        4��wδ�����ʣ���w����������ȱ����ݹ飨����w������һ��v��Ȼ����в���123
        5���ҵ����v��w�ڽӽ�����һ���ڽӽ�㣬ת������3

ͼ�Ĺ�����ȱ���
    ͼ�Ĺ������������BroadFirstSearch��������һ���ֲ������Ĺ��̣�������ȱ�����Ҫһ�������Ա���
���ʹ��Ľ���˳���Ա㰴���˳����������Щ�����ڽӽ��
    ������ȱ����㷨���裺
        1���ʳ�ʼ��v�����Ϊ���vΪ�ѷ���
        2���v�����
        3�����зǿ�ʱ������ִ�У������㷨����
        4�����У�ȡ�ö�ͷ���u
        5���ҽ��u�ĵ�һ���ڽӽ��w
        6�����u���ڽӽ��w�����ڣ���ת������3������ѭ��ִ�������������裺
            6.1�����w��δ�����ʣ�����ʽ��w������ѷ���
            6.2���w�����
            6.3���ҽ���u�ļ�w�ڽӽ�����һ���ڽӽ��w��ת������6
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Demo15Tu {
    private ArrayList<String> vertexList; // �洢���㼯��
    private int[][] edges;//�洢ͼ��Ӧ���ڽӾ���
    private int numOfEdges;//��ʾ�ߵĸ���

    //����һ�����飬��¼ĳ������Ƿ񱻷��ʹ�
    private boolean[] isVisited;

    public static void main(String[] args) {
        //int n = 5;//������
        //String[] VertexValue = {"A","B","C","D","E"};
        String[] VertexValue = {"1","2","3","4","5","6","7","8"};
        int n = VertexValue.length;
        //����ͼ����
        Demo15Tu graph = new Demo15Tu(n);
        for (String s : VertexValue) {
            graph.insertVertex(s);
        }
        //��ӱ�
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

        //��ʾһ���ڽӾ���
        graph.showGraph();

        //dfs����
        System.out.println("��ȱ�����");
        graph.dfs();
        System.out.println();
        System.out.println("�������");
        graph.bfs();
    }

    //������
    public Demo15Tu(int n) {
        //��ʼ�������ArrayList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    //�õ���һ���ڽӽ����±� w
    /**
     * @param index
     * @return ������ھͷ����±꣬���򷵻�-1
    */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }
    //����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //������ȱ���
    private void bfs(boolean[] isVisited, int i) {
        int u;//��ʾ���е�ͷ�ڵ��Ӧ�±�
        int w;//�ڽӽ����±�w
        //���У���¼�����ʵ�˳��
        LinkedList queue = new LinkedList();
        //���ʽ�㣬��������Ϣ
        System.out.print(getValueByIndex(i) + "->");
        //���Ϊ�ѷ���
        isVisited[i] = true;
        //�����������
        queue.addLast(i);

        while (!queue.isEmpty()) {
            //ȡ�����е�ͷ�ڵ��±�
            u = (Integer) queue.removeFirst();
            //�õ���һ���ڽӽ����±�
            w = getFirstNeighbor(u);

            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //����ѷ���
                    isVisited[w] = true;
                    //�����
                    queue.addLast(w);
                }
                //��uΪǰ���㣬��w�������һ���ڽӽ��
                w = getNextNeighbor(u,w);//���ֳ��������
            }
        }
    }

    //�������н�㣬�����й����������
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited,i);
            }
        }
    }

    //������ȱ����㷨 i��������һ�ξ���0
    private void dfs(boolean[] isVisited, int i) {
        //�������Ƿ��ʸý�㣬���
        System.out.print(getValueByIndex(i) + "->");
        //���ý������Ϊ�Ѿ�����
        isVisited[i] = true;

        int w = getFirstNeighbor(i);

        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //���w����Ѿ������ʹ�
            w = getNextNeighbor(i,w);
        }

    }

    //��dfs�������أ������������еĽ�㣬������dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //�������еĽ�㣬����dfs[����]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }

    //ͼ�г��õķ���
    //���ؽ��ĸ���
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //��ʾͼ����Ӧ�ľ���
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    //�õ��ߵ���Ŀ
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //���ؽ��i���±꣩��Ӧ������  0->A, 1->B, 2->C
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //����v1��v2��Ȩֵ
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //������
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //��ӱ�
    /**
     * @param v1  ��ʾ����±꣬���ǵڼ�������
     * @param v2  �ڶ��������Ӧ���±�
     * @param weight
     *
    */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
