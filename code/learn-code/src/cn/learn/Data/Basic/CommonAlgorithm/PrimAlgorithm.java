package cn.learn.Data.Basic.CommonAlgorithm;
/*
    ����ķ�㷨
        Ӧ�ó���-��·����
        A-------5--------B
       /  \             / \
      7     2         3     9
     /        \     /        \
    C            G            D
     \         /    \        /
      8      4        6     4
        \  /            \  /
          E------5--------F
          1����ʤ������7����ׯ��A��B��C��D��E��F��G��������Ҫ��·��7����ׯ��ͨ
          2��������ׯ�ľ����ñ��߱�ʾ��Ȩ��������A-B����5����
          3���ʣ������·��֤������ׯ������ͨ�������ܵ��޽���·�������̣�
            ˼·����10���ߣ����Ӽ��ɣ���ʱ�ܵ������������С
            ��ȷ˼·�������ܵ�ѡ���ٵ�·�ߣ�����ÿ��·��С����֤�����������
        1�������A��ʼ����ԭ�м���<A>��A-C[7] A-G[2] A-B[5]  ѡȡ��С�� <A> ======> <A,G>
        2��<A,G>��ʼ����A��G������������ڵĻ�û�з��ʵĶ�����д���
            A-C[7] A-B[5] G-B[3] G-F[6] G-E[4]                      <A,G> ======> <A,G,B>
        3��<A,G,B>��ʼ A-C[7] G-F[6] G-E[4] B-D[9]                 <A,G,B> ======> <A,G,B,E>
        .
        .
        .
        <A,G,B,E,F,D,C>
    ��С��������
        ��·���Ȿ�ʾ�����С���������⣬�Ƚ���һ����С��������MinimumCostSpanningTree�������MST
        1������һ����Ȩ��������ͨͼ�����ѡȡһ����������ʹ�������б���Ȩ���ܺ�Ϊ��С�������С������
        2��N�����㣬һ����N-1����
        3������ȫ������
        4��N-1���߶���ͼ��
        5������С���������㷨��Ҫ������ķ�㷨�Ϳ�³˹�����㷨
    ����ķ�㷨���ܣ�
        1������ķ�㷨����С��������Ҳ�����ڰ���n���������ͨͼ�У��ҳ�ֻ�У�n-1�����߰�������n�������
    ��ͨ��ͼ��Ҳ������ν�ļ�С��ͨ��ͼ
        2������ķ�㷨���£�
            1����G=(V,E)����ͨ����T=(U,D)����С��������VU�Ƕ��㼯�ϣ�ED�Ǳߵļ���
            2�����Ӷ���u��ʼ������С����������Ӽ���V��ȡ������u���뼯��U�У���Ƕ���v��visited[u]=1
            3��������U�ж���ui�뼯��V-U�еĶ���vj֮����ڱߣ���Ѱ����Щ����Ȩֵ��С�ıߣ������ܹ��ɻ�·
        ������vj���뼯��U�У�����(ui,vj)���뼯��D�У����visited[vj]=1
            4���ظ�����2��ֱ��U��V��ȣ������ж��㶼�����Ϊ���ʹ�����ʱD����n-1����
            5����ʾ�����������������⣬ͨ�����뽲��
*/

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //�ڽӾ���Ĺ�ϵʹ�ö�ά�����ʾ
        int[][] weight = {
                          {10000,5,7,10000,10000,10000,2},
                          {5,10000,10000,9,10000,10000,3},
                          {7,10000,10000,10000,8,10000,10000},
                          {10000,9,10000,10000,10000,4,10000},
                          {10000,10000,8,10000,1000,5,4},
                          {10000,10000,10000,4,5,10000,6},
                          {2,3,10000,10000,4,6,10000}
                          };
        //����MGraph����
        MGraph mGraph = new MGraph(verxs);
        //����һ��MinTree����
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        //���
        minTree.showGraph(mGraph);
        minTree.prim(mGraph, 0);

    }
}

//������С������->��ׯ��ͼ
class MinTree{
    //����ͼ���ڽӾ���
    /**
     * @param graph ͼ����
     * @param verxs ͼ��Ӧ�Ķ������
     * @param data ͼ�ĸ��������ֵ
     * @param weight ͼ���ڽӾ���
    */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i,j;
        for (i = 0; i < verxs; i++) {//����
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //��ʾͼ�ķ���
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //��дprim�㷨���õ���С������

    /**
     *
     * @param graph ͼ
     * @param v ��ʾ��ͼ�ĵ�һ�����㿪ʼ����'A' -> 0, 'B' -> 1 .....
     */
    public void prim(MGraph graph, int v) {
        //visited[] ��ǽڵ㣨�����Ƿ񱻷��ʹ���
        int[] visited = new int[graph.verxs];//Ĭ��Ԫ�ص�ֵ����0����ʾû�з��ʹ�

        //�ѵ�ǰ����ڵ���Ϊ�ѷ���
        visited[v] = 1;

        //��h1��h2��¼����������±�
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //��minWeight��ʼ��һ�������������ڱ��������У��ᱻ�滻
        for (int k = 1; k < graph.verxs; k++) {//��Ϊ��graph.verxs���㣬����ķ�㷨��������graph.verxs-1����

            //�����ȷ��ÿһ�����ɵ���ͼ�����ĸ��ڵ�ľ������
            for (int i = 0; i < graph.verxs; i++) {//i�ڵ��ʾ�����ʹ��Ľڵ�
                for (int j = 0; j < graph.verxs; j++) {//j�ڵ��ʾδ���ʹ��Ľڵ�
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //�滻minWeight��Ѱ���ѷ��ʹ��Ľڵ��δ���ʹ��Ľڵ���Ȩֵ��С�ı�
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            //�ҵ�һ��������С
            System.out.println("��<" + graph.data[h1] + "," + graph.data[h2] + ">Ȩֵ��" + minWeight);
            //����ǰ����ڵ���Ϊ�Ѿ�����
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}

class MGraph{
    int verxs;//��ʾͼ�Ľڵ����
    char[] data;//��Žڵ�����
    int[][] weight;//��űߣ��������ǵ��ڽӾ���

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
